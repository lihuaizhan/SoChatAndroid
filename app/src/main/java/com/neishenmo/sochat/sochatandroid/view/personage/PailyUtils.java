package com.neishenmo.sochat.sochatandroid.view.personage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.alipay.sdk.app.AuthTask;
import com.neishenmo.sochat.sochatandroid.utils.AuthResult;
import com.neishenmo.sochat.sochatandroid.utils.OrderInfoUtil2_0;
import com.vondear.rxtools.module.alipay.PayResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-05-11.
 */

public class PailyUtils {

    private Activity mActivity;
    public static String result;
    private String mNum;
    public void setActivity(Activity activity,String num) {
        mActivity = activity;
        mNum = num;
         setHandle(mActivity);
    }

    private void setHandle(Activity mact) {
        mHandler = new Handler(mact.getMainLooper()) {
            public void handleMessage(Message msg) {
                Log.i("wy", "11111111111" + msg.what);
                switch (msg.what) {
                    case SDK_PAY_FLAG: {
                        PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                        /**
                         对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                         */
                        String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                        String resultStatus = payResult.getResultStatus();
                        // 判断resultStatus 为9000则代表支付成功
                        if (TextUtils.equals(resultStatus, "9000")) {
                            // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                            Log.i("wy", "1");
                        } else {
                            // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                            Log.i("wy", "2");
                        }
                        break;
                    }
                    case SDK_AUTH_FLAG: {
                        AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                        String resultStatus = authResult.getResultStatus();


                        // 判断resultStatus 为“9000”且result_code
                        // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                        if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                            // 获取alipay_open_id，调支付时作为参数extern_token 的value
                            // 传入，则支付账户为该授权账户
                            result = authResult.getResult();
                            String[] split = result.split("&");
                            Map map = new HashMap();
                            for(int i=0;i<split.length;i++)
                            {
                                String[] split1 = split[i].split("=");
                                map.put(split1[0],split1[1]);
                            }
                            String user_id = (String) map.get("user_id");

                                Intent intent = new Intent(mActivity,SendInternalCodeActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("user_id",user_id);
                                bundle.putString("num",mNum);
                                intent.putExtras(bundle);
                                mActivity.startActivity(intent);


                            Log.i("wy", "3");
                        } else {
                            // 其他状态值则为授权失败
                            Log.i("wy", "4");
                        }
                        break;
                    }
                    default:
                        break;
                }
            }
        };
    }

    private static final int SDK_PAY_FLAG = 11;
    private static final int SDK_CHECK_FLAG = 12;
    private static final int MSG_GET_ACTIVATION = 2;
    private static final int SDK_AUTH_FLAG = 2;

    private Handler mHandler;

    //调用该方法进行支付宝sdk调用
    public void pay(final String payInfo) {
        Runnable authRunnable = new Runnable() {
            @Override
            public void run() {
                // 构造AuthTask 对象
                AuthTask authTask = new AuthTask(mActivity);
                // 调用授权接口，获取授权结果
                Map<String, String> result = authTask.authV2(payInfo, true);
                Message msg = new Message();
                msg.what = SDK_AUTH_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread authThread = new Thread(authRunnable);
        authThread.start();
    }



}
