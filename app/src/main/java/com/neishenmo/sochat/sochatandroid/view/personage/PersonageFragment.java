package com.neishenmo.sochat.sochatandroid.view.personage;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.alipay.sdk.app.AuthTask;
import com.alipay.sdk.app.PayTask;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.app.NeiShenMeApp;
import com.neishenmo.sochat.sochatandroid.base.BaseFragment;
import com.neishenmo.sochat.sochatandroid.bean.ApilyLogin;
import com.neishenmo.sochat.sochatandroid.bean.LogOut;
import com.neishenmo.sochat.sochatandroid.bean.MyMessage;
import com.neishenmo.sochat.sochatandroid.bean.Perfect;
import com.neishenmo.sochat.sochatandroid.net.RetrofitHelper;
import com.neishenmo.sochat.sochatandroid.net.ServiceApi;
import com.neishenmo.sochat.sochatandroid.popupwindow.CommonPopupWindow;
import com.neishenmo.sochat.sochatandroid.requestbean.HeadRequst;
import com.neishenmo.sochat.sochatandroid.requestbean.PerfectRequest;
import com.neishenmo.sochat.sochatandroid.requestbean.RelationShipRequest;
import com.neishenmo.sochat.sochatandroid.requestbean.SetName;
import com.neishenmo.sochat.sochatandroid.utils.AuthResult;
import com.neishenmo.sochat.sochatandroid.utils.GlideCircleTransform;
import com.neishenmo.sochat.sochatandroid.utils.LogUtils;
import com.neishenmo.sochat.sochatandroid.utils.ObtainAlbumUtils;
import com.neishenmo.sochat.sochatandroid.utils.OrderInfoUtil2_0;
import com.neishenmo.sochat.sochatandroid.utils.ToastUtils;
import com.neishenmo.sochat.sochatandroid.view.signin.AlbumActivity;
import com.neishenmo.sochat.sochatandroid.view.signin.PerfectDataActivity;
import com.neishenmo.sochat.sochatandroid.view.signin.SplaActivity;
import com.tsy.sdk.social.SocialApi;


import java.util.Map;

import bpwidget.lib.wjj.blurpopupwindowlib.widget.BlurPopWin;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static com.neishenmo.sochat.sochatandroid.view.signin.PerfectDataActivity.PICTUR_HEAD;

/**
 * Created by Administrator on 2018-04-24.
 */

public class PersonageFragment extends BaseFragment {
    private View view;
    private ImageView picture;
    private ImageView setMessage;
    private ImageView mExit;
    private ImageView mSave;
    private ImageView mCallCamera;
    private RequestManager with;
    private String mPhotoPath;
    private String uploadFilePath;
    private static final String WX_APPID = "wx143deeda4d112579";
    /**
     * 姓名
     */
    private TextView myName;
    private ImageView paint;
    /**
     * 输入金额
     */
    private EditText importMoney;
    /**
     * 当前最大提现金额为2700
     */
    private TextView mReminder;
    private ImageView mWithdrawAlipay;
    private ImageView mWithdrawWeixin;
    private LinearLayout mWithdraw;
    /**
     * 确认提现
     */
    private Button mDeposit;
    private ImageView mMoney;
    /**
     * 收到红包数量
     */
    private TextView mMoneyNum;
    private ImageView mLove;
    /**
     * 收到点赞数量
     */
    private TextView mLoveNum;
    /**
     * 2700
     */
    private TextView mMoneyTotal;
    /**
     * 提现
     */
    private Button affirmDeposit;
    private LinearLayout mMaster;
    private TextView cancelDeposit;
    //背景
    private LinearLayout bg;
    private EditText setName;

    private Activity activity;
    private SharedPreferences user;
    private RelationShipRequest request;
    private ServiceApi serviceApi;
    private String accessKeyId = "LTAIH2OdoTZKNR7k ";
    private String accessKeySecret = "H4woB6oRaJ2lJRnUQNmTE5OOtpYT9p ";
    private OSS oss;
    private String endpoint = "https://oss-cn-beijing.aliyuncs.com";
    private static final String testBucket = "neishenme";
    private String token;
    private long time;
    private String name;
    private SetName setName1;
    //    private SocialApi mSocialApi;
    private String orderInfo;
    //提现输入数
    private String s;
    /**
     * 支付宝支付业务：入参app_id
     */
    public static final String APPID = "";

    /**
     * 支付宝账户登录授权业务：入参pid值
     */
    public static final String PID = "";
    /**
     * 支付宝账户登录授权业务：入参target_id值
     */
    public static final String TARGET_ID = "";

    /** 商户私钥，pkcs8格式 */
    /** 如下私钥，RSA2_PRIVATE 或者 RSA_PRIVATE 只需要填入一个 */
    /** 如果商户两个都设置了，优先使用 RSA2_PRIVATE */
    /** RSA2_PRIVATE 可以保证商户交易在更加安全的环境下进行，建议使用 RSA2_PRIVATE */
    /** 获取 RSA2_PRIVATE，建议使用支付宝提供的公私钥生成工具生成， */
    /**
     * 工具地址：https://doc.open.alipay.com/docs/doc.htm?treeId=291&articleId=106097&docType=1
     */
    public static final String RSA2_PRIVATE = "";
    public static final String RSA_PRIVATE = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC355ZYftshg3FJvqnGCVgBZegAFBAibZyB91C9fXNivjQg8o8H+12S1BV56xPKKWn7laskh+Tb0iOKI6UBqfmYYBVZAivdrvLQ+njDe3iFCmZFc27H8eP11dxe4H7mdhIA0fwi599qdzlU63Vgy4+vGZ7lEkJ4/V1vNly++DHAIgMUKCaSw56QXoeJvJhffnLdBZtSrdTigKIxsfqWJrioOVspo6KNixFbxjiPiuITxzPliwWqckClaVw0RH1eO/vDu4Ng9JtIRb6LJqvbHY/o4NFE072tJCTF+tAWErGoWZh68zBXns6D1E1EfBuuav04Hx/kmWq6sFfjzD9HgaCLAgMBAAECggEAGd9W43RVV82qLnnIYLgHzYqMrRYlfvJ0xkQI89+mUAn6Q3hcbv8KFxIHQ3OzAQn6gw53WVhU9igGH/ULzcQf/TPnTPJlQXbPal8Shk3kkrL32GV4/GAndfp0WlSzBbEurzbbhf2hDNVhF3VYuhlpSXUNSaTb/TGH55F6UtOQDDt/ixeiym+M2CLApgg+Q5ztrcFSjUXRLP+XZWiwrbBK5bCEDBdXw1qaV+SgkEEtPnQ9mWmR1FLbdabnHxp0CyjWpAy4fNBHwu/Dz5qSdtDCsz79BTWIltQYCCW5ggH5DGAUG54jdb37V9XDoWhsawJ75U2cmlQiwqKCwMjqhB8U4QKBgQDoAnJl3+kC1CLKuBYxC/vs3T7qNZ+LR6mhUtffxZo66G6Zy4/57WDDT9o3CI5Xu+UPp7jPZkTK8/RmL+dGDcG5fA6rv2UahmgG3JcMWk+s6YpVdN+tgI3/xLdgiFZ/KAUe6MO2lqz6+ld5t+Bd+WJGfJ96bRkntUNsx74Ja7CzTwKBgQDK67/OopLhtrD/i8RFdL12Q8Y9M+yttJXMa8nU49jGcLtE9c4/mKiJSOyMcUfpFxesIveM18LYafpTee+e5CqwGLaZ1me5+fdL9+hODjV3YJUBMYG6wbma8nF7HJOTD5HhFxC8net3MX66sbOuECLYDqSTzzhftaWiDLzuhwfgBQKBgQDcwH9CyZK2u0vDYPbUgheZX0YeqRj9+BjBw8ZdR3IhPMkHkrWSUzevfsoddQmjFsezZp2k0SUBiq9vj4LZl/tM1mpLJlg3rc1LQhaCjWekGa4i84pkVp5Fz1HACtlqMZT1vPmDQMikIRCcYsWcBM5qTOedIDNAIetelIsQAaRmZwKBgBW0dcXCefeOtQwAhTPwsrtNsIynWy+RW1yMQwB0hqFjOYS8zhzbVVup4zN6gniaMbwF2XjFM2A2pcH8Dvdt7Gr9mbqGxn2METmdAMoolut39zgzdW7mfdXnDOBgRCC8z5vF/dJPCfqr3qRVkaSSsUdu+Yed6KfEJD1bI3JYGy2JAoGAOmSzbJq7Rtu/quneuZuxeP2TuhG/eKDIzuzGbkCQvNOvHZBjqZl0bjojczzalSW5F64" +
            "7OyI4ws0ksiVaFc1IeLUjtUW5M5pGoFCljI2hkmQ2lqo+WChkTY8ZGnqpenODSwXJX4sglm/mLI2KX5DrizZqI/2LlrWJ1IIMT4ZdFq8=";

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;

//    @SuppressLint("HandlerLeak")
//    private Handler mHandler = new Handler() {
//        @SuppressWarnings("unused")
//        public void handleMessage(Message msg) {
//
//
//            @SuppressWarnings("unchecked")
//            AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
//            String resultStatus = authResult.getResultStatus();
//
//            // 判断resultStatus 为“9000”且result_code
//            // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
//            if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
//                // 获取alipay_open_id，调支付时作为参数extern_token 的value
//                // 传入，则支付账户为该授权账户
//                Toast.makeText(getActivity(),
//                        "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
//                        .show();
//            } else {
//                // 其他状态值则为授权失败
//                Toast.makeText(getActivity(),
//                        "授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();
//            }
//            };
//            };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取sp
        user = getActivity().getSharedPreferences("user", 0);
        if (user.getString("token", "").equals("")) {
            Intent intent = new Intent(getActivity(), SplaActivity.class);
            startActivity(intent);
//            getActivity().finish();
//            ViewPager viewById = getActivity().findViewById(R.id.viewPager);
//            viewById.setCurrentItem(0);
        }
    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        view = inflater.inflate(R.layout.presenter_layout, container, false);

        return view;
    }

    @Override
    protected void initData() {
        //获取控件id
        bg = view.findViewById(R.id.bg);
        picture = view.findViewById(R.id.picture);
        setMessage = view.findViewById(R.id.set_message);
        myName = view.findViewById(R.id.my_name);
        paint = view.findViewById(R.id.set_paint);
        importMoney = view.findViewById(R.id.import_money);
        affirmDeposit = view.findViewById(R.id.affirm_deposit);
        mExit = (ImageView) view.findViewById(R.id.exit);
        mCallCamera = (ImageView) view.findViewById(R.id.call_camera);
        mReminder = (TextView) view.findViewById(R.id.reminder);
        mWithdrawAlipay = (ImageView) view.findViewById(R.id.withdraw_alipay);
        mWithdrawWeixin = (ImageView) view.findViewById(R.id.withdraw_weixin);
        mWithdraw = (LinearLayout) view.findViewById(R.id.withdraw);
        mDeposit = (Button) view.findViewById(R.id.deposit);
        mMoney = (ImageView) view.findViewById(R.id.money);
        mMoneyNum = (TextView) view.findViewById(R.id.money_num);
        mLove = (ImageView) view.findViewById(R.id.love);
        mLoveNum = (TextView) view.findViewById(R.id.love_num);
        mMoneyTotal = (TextView) view.findViewById(R.id.money_total);
        mMaster = (LinearLayout) view.findViewById(R.id.master);
        mSave = view.findViewById(R.id.saves);
        cancelDeposit = view.findViewById(R.id.deposit_cancel);
        setName = view.findViewById(R.id.set_name);
        SocialApi mSocialApi = SocialApi.get(getActivity().getApplicationContext());

        //初始化阿里云
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(accessKeyId, accessKeySecret);
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000);//连接超时时间
        conf.setSocketTimeout(15 * 1000);//socket 超时时间
        conf.setMaxConcurrentRequest(5); //最大发送数
        conf.setMaxErrorRetry(2); // 失败后最大重连次数
        OSSLog.enableLog();
        oss = new OSSClient(getActivity().getApplicationContext(), endpoint, credentialProvider, conf);


        final PailyUtils pailyUtils = new PailyUtils();
        final SetName rqe = new SetName();
        rqe.setToken(user.getString("token", ""));
        //支付宝提现
        mWithdrawAlipay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // WXEntryActivity.loginWeixin(getActivity(), NeiShenMeApp.sApi);
                serviceApi.apilyLogin(rqe).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<ApilyLogin>() {
                            @Override
                            public void accept(ApilyLogin apilyLogin) throws Exception {
                                orderInfo = apilyLogin.getData();
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        });
                s = importMoney.getText().toString().trim();
                pailyUtils.setActivity(getActivity(), s);
                if (s != null & !s.equals("")) {
                    pailyUtils.pay(orderInfo);
                } else {
                    Toast.makeText(getActivity(), "请输入提现数量", Toast.LENGTH_SHORT).show();
                }


            }
        });

//微信授权
        mWithdrawWeixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         //   WXEntryActivity.loginWeixin(getActivity(), NeiShenMeApp.sApi);
            }
        });

        //获取token
        request = new RelationShipRequest("0", user.getString("token", ""));
        //获取网络请求辅助类
        serviceApi = RetrofitHelper.getServiceApi();
        LogUtils.d("ssssssssssss", user.getString("token", ""));
        //修改昵称参数类
        setName1 = new SetName();
        setName1.setToken(user.getString("token", ""));
        token = user.getString("token", "");


        //点击心进入点赞详情页面
        mLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoveNumberActivity.class);
                startActivity(intent);
            }
        });

        mMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MoneyListActivity.class);
                startActivity(intent);
            }
        });


        //退出登录弹框
        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BlurPopWin.Builder(getActivity()).setContent("退出后,账号信息会消失哦!")
                        //Radius越大耗时越长,被图片处理图像越模糊
                        .setRadius(3).setTitle("确定退出?")
                        //设置居中还是底部显示
                        .setshowAtLocationType(0)
                        .onClick(new BlurPopWin.PopupCallback() {
                            @Override
                            public void onCancelClick(@NonNull BlurPopWin blurPopWin) {
                                blurPopWin.dismiss();
                            }

                            @Override
                            public void onAffirmClick(@NonNull BlurPopWin blurPopWin) {

                                //来访数据请求
                                serviceApi.logOut(request)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new Consumer<LogOut>() {
                                            @Override
                                            public void accept(final LogOut logOut) throws Exception {
                                                String msg = logOut.getMsg();
                                                if (logOut.getCode() == 200) {
                                                    Toast.makeText(getActivity(), "您以退出登陆", Toast.LENGTH_SHORT).show();
                                                    user.edit().clear().commit();
                                                    Intent intent = new Intent(getActivity(), SplaActivity.class);
                                                    startActivity(intent);
                                                    getActivity().finish();
                                                } else {
                                                    Toast.makeText(getActivity(), "您还没有登陆", Toast.LENGTH_SHORT).show();
                                                }

                                            }
                                        }, new Consumer<Throwable>() {
                                            @Override
                                            public void accept(Throwable throwable) throws Exception {

                                            }
                                        });
                                blurPopWin.dismiss();
                            }
                        }).show(mExit);
            }
        });


//         bg.setOnClickListener(new View.OnClickListener() {
//       @Override
//       public void onClick(View view) {
//           importMoney.setFocusable(false);
//           importMoney.setInputType(InputType.TYPE_NULL); // 关闭软键盘
//       }
//   });
        //修改名字
        paint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myName.setVisibility(View.GONE);
                setName.setVisibility(View.VISIBLE);
                paint.setVisibility(View.GONE);

            }
        });


        //提现隐藏加切换页面
        affirmDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mMaster.setVisibility(View.GONE);
                importMoney.setVisibility(View.VISIBLE);
                mReminder.setVisibility(View.VISIBLE);
                mWithdraw.setVisibility(View.VISIBLE);
                mDeposit.setVisibility(View.VISIBLE);
                cancelDeposit.setVisibility(View.VISIBLE);
            }
        });

        //取消提现
        cancelDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMaster.setVisibility(View.VISIBLE);
                importMoney.setVisibility(View.GONE);
                mReminder.setVisibility(View.GONE);
                mWithdraw.setVisibility(View.GONE);
                mDeposit.setVisibility(View.GONE);
                cancelDeposit.setVisibility(View.GONE);
            }
        });

        //点击修改信息
        setMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint.setVisibility(View.VISIBLE);
                mCallCamera.setVisibility(View.VISIBLE);
                setMessage.setVisibility(View.GONE);
                mSave.setVisibility(View.VISIBLE);
                mExit.setVisibility(View.VISIBLE);
                setName.setText(myName.getText());
//                mExit.setVisibility(View.VISIBLE);
//                mMaster.setVisibility(View.VISIBLE);
//                setMessage.setVisibility(View.GONE);
//                importMoney.setVisibility(View.GONE);
//                mReminder.setVisibility(View.GONE);
//                mWithdraw.setVisibility(View.GONE);
//                mDeposit.setVisibility(View.GONE);
//                setMessage.setVisibility(View.GONE);

            }
        });

        //保存信息并更改
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s = setName.getText().toString();
                if (s.length() != 0 || s.equals("") == false) {
                    mCallCamera.setVisibility(View.GONE);
                    mExit.setVisibility(View.GONE);
                    paint.setVisibility(View.GONE);
                    setMessage.setVisibility(View.VISIBLE);
                    mSave.setVisibility(View.GONE);

                    // mSave.requestFocus();
                    setName.setVisibility(View.GONE);
                    myName.setVisibility(View.VISIBLE);
                    myName.setText(s);
                    setName1.setNickName(s);
                    time = System.currentTimeMillis();
                    serviceApi.setName(setName1).subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<LogOut>() {
                                @Override
                                public void accept(LogOut logOut) throws Exception {

                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {

                                }
                            });

//                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                    beginupload();


                } else {
                    Toast.makeText(getActivity(), "输入字符不能为空", Toast.LENGTH_SHORT).show();
                }


            }
        });

        mCallCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.makeText(getActivity(), "ssssssss", Toast.LENGTH_LONG);
                new CommonPopupWindow(new CommonPopupWindow.OnPopWindowClickListener() {
                    @Override
                    public void onPopWindowClickListener(View view) {
                        switch (view.getId()) {
                            /**
                             * 头像 拍照
                             */
                            case R.id.tv_menu_1:
//                                uploadFilePath
                                mPhotoPath = ObtainAlbumUtils.getSDPath() + "/" + ObtainAlbumUtils.getPhotoFileName();
                                ObtainAlbumUtils.openCamera(getActivity(), mPhotoPath);
//                openCamera();
                                break;
                            /**
                             * 头像  相册选择
                             */
                            case R.id.tv_menu_2:
                                openAlbum();
                                break;
                            /**
                             * 取消选择
                             */
                            case R.id.tv_close_popup_window:

                                break;
                        }
                    }
                }, getActivity()).show();
            }
        });


        //提现输入框操作
        importMoney.setOnFocusChangeListener(new android.view.View.
                OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // 此处为得到焦点时的处理内容
                    getActivity().findViewById(R.id.magic_indicator4).setVisibility(View.GONE);
                } else {
                    // 此处为失去焦点时的处理内容
                    getActivity().findViewById(R.id.magic_indicator4).setVisibility(View.VISIBLE);
                }
            }
        });
//        importMoney.setOnTouchListener(new View.OnTouchListener()
//        { public boolean onTouch(View v, MotionEvent event)
//        {     InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(INPUT_METHOD_SERVICE);
//              imm.showSoftInputFromInputMethod(importMoney.getWindowToken(),0);
//
//            return false;
//            }});

        //设置提现输入框只能输入两位小数点
        importMoney.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (s.toString().contains(".")) {
                    if (s.length() - 1 - s.toString().indexOf(".") > 2) {
                        s = s.toString().subSequence(0,
                                s.toString().indexOf(".") + 3);
                        importMoney.setText(s);
                        importMoney.setSelection(s.length());
                    }
                }
                if (s.toString().trim().substring(0).equals(".")) {
                    s = "0" + s;
                    importMoney.setText(s);
                    importMoney.setSelection(2);
                }

                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        importMoney.setText(s.subSequence(0, 1));
                        importMoney.setSelection(1);
                        return;
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }

        });

        //请求参数
        RelationShipRequest request = new RelationShipRequest("", user.getString("token", ""));
        //请求获取个人信息
        serviceApi = RetrofitHelper.getServiceApi();
        serviceApi.getMyMessage(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyMessage>() {
                    @Override
                    public void accept(MyMessage myMessage) throws Exception {
                        //glide图片加载框架
                        with = Glide.with(getActivity());
                        //获取昵称并显示
                        myName.setText(myMessage.getDataMap().getNickName());
                        //获取收到红包数量并显示
                        mMoneyNum.setText(myMessage.getDataMap().getCountRedPacket() + "");
                        //获取收到点赞数量并显示
                        mLoveNum.setText(myMessage.getDataMap().getCountThumbsUp() + "");
                        setName.setText(myMessage.getDataMap().getNickName());
                        //判断头像非空
                        if (myMessage.getDataMap().getPicture().equals("baidu.com")) {
                            with.load("https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg").transform(new GlideCircleTransform(getActivity())).into(picture);
                        } else {
                            with.load(myMessage.getDataMap().getPicture()).transform(new GlideCircleTransform(getActivity())).into(picture);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    protected void setDefaultFragmentTitle(String title) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 选择照片完成后传回
         */
        if (requestCode == PICTUR_HEAD && resultCode == AlbumActivity.HEAD_OK) {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = bundle.getParcelable("bitmap");
            uploadFilePath = ObtainAlbumUtils.writeFileByBitmap(bitmap);
            picture.setImageBitmap(bitmap);
        }
        /**
         * 调用截图
         */
        else if (requestCode == 33) {
            if (data != null) {
                ObtainAlbumUtils.BitmapScreenshot(data, getActivity());
            }
        }
        /**
         * 截图之后设置头像
         */
        else if (requestCode == ObtainAlbumUtils.HEAD_SCREENSHOT) {
            if (data != null) {
                Bitmap bitmap = data.getParcelableExtra("data");
                uploadFilePath = ObtainAlbumUtils.writeFileByBitmap(bitmap);
                picture.setImageBitmap(bitmap);
            }
        }
    }

    /**
     * 打开相册
     */

    private void openAlbum() {
        Intent intent = new Intent(getActivity(), AlbumActivity.class);
        startActivityForResult(intent, PICTUR_HEAD);
    }

    /**
     * 图片传到阿里云服务器
     */
    private void beginupload() {
        PutObjectRequest put = new PutObjectRequest(testBucket, token + time, uploadFilePath);
        OSSAsyncTask task = oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                NextStop();
//                Log.d("TAG", "UploadSuccess");
//                Log.d("TAG", "ETag"+result.getETag());
//                Log.d("TAG", "RequestId"+result.getRequestId());
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientException, ServiceException serviceException) {
                if (clientException != null) {
                    Log.d("TAG", "本地异常");
                    // 本地异常如网络异常等
                }
                if (serviceException != null) {
                    Log.d("TAG", "服务异常");
                    // 服务异常
                }
            }
        });
    }

    private void NextStop() {
        serviceApi.setHead(new HeadRequst(token, "https://neishenme.oss-cn-beijing.aliyuncs.com/" + token + time)).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LogOut>() {
                    @Override
                    public void accept(LogOut logOut) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    /**
     * 支付宝账户授权业务
     *
     * @param
     */
//        public void authV2() {
//            if (TextUtils.isEmpty(PID) || TextUtils.isEmpty(APPID)
//                    || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty(RSA_PRIVATE))
//                    || TextUtils.isEmpty(TARGET_ID)) {
//                new AlertDialog.Builder(getActivity()).setTitle("警告").setMessage("需要配置PARTNER |APP_ID| RSA_PRIVATE| TARGET_ID")
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialoginterface, int i) {
//                            }
//                        }).show();
//                return;
//            }
//
//            /**
//             * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
//             * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
//             * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
//             *
//             * authInfo的获取必须来自服务端；
//             */
//            boolean rsa2 = (RSA2_PRIVATE.length() > 0);
//            Map<String, String> authInfoMap = OrderInfoUtil2_0.buildAuthInfoMap(PID, APPID, TARGET_ID, rsa2);
//            String info = OrderInfoUtil2_0.buildOrderParam(authInfoMap);
//
//            String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
//            String sign = OrderInfoUtil2_0.getSign(authInfoMap, privateKey, rsa2);
//            final String authInfo = info + "&" + sign;
//            Runnable authRunnable = new Runnable() {
//
//                @Override
//                public void run() {
//                    // 构造AuthTask 对象
//                    AuthTask authTask = new AuthTask(getActivity());
//                    // 调用授权接口，获取授权结果
//                    Map<String, String> result = authTask.authV2(authInfo, true);
//
//                    Message msg = new Message();
//                    msg.what = SDK_AUTH_FLAG;
//                    msg.obj = result;
//                    mHandler.sendMessage(msg);
//                }
//            };
//
//            // 必须异步调用
//            Thread authThread = new Thread(authRunnable);
//            authThread.start();
//        }
}
