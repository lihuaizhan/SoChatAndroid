package com.neishenmo.sochat.sochatandroid.wxapi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.neishenmo.sochat.sochatandroid.app.NeiShenMeApp;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by Administrator on 2018-05-09.
 */

// 实现IWXAPIEventHandler 接口，以便于微信事件处理的回调
public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    private static final String WEIXIN_ACCESS_TOKEN_KEY = "wx_access_token_key";
    private static final String WEIXIN_OPENID_KEY = "wx_openid_key";
    private static final String WEIXIN_REFRESH_TOKEN_KEY = "wx_refresh_token_key";

   // private Gson mGson;c
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 微信事件回调接口注册
        NeiShenMeApp.sApi.handleIntent(getIntent(), this);
       // mGson = new Gson();
    }

    /**
     * 微信组件注册初始化
     * @param context 上下文
     * @param weixin_app_id appid
     * @return 微信组件api对象
     */

    public static IWXAPI initWeiXin(Context context, @NonNull String weixin_app_id) {
    if (TextUtils.isEmpty(weixin_app_id)) {
    Toast.makeText(context.getApplicationContext(), "app_id 不能为空", Toast.LENGTH_SHORT).show();
    }
    IWXAPI api = WXAPIFactory.createWXAPI(context, weixin_app_id, true);
    api.registerApp(weixin_app_id);
    return api;
    }

    /**
     * 登录微信
     *
     * @param api 微信服务api
     */
    public static void loginWeixin(Context context, IWXAPI api) {
        // 判断是否安装了微信客户端
        if (!api.isWXAppInstalled()) {
            Toast.makeText(context.getApplicationContext(), "您还未安装微信客户端！", Toast.LENGTH_SHORT).show();
            return;
        }
        // 发送授权登录信息，来获取code
        SendAuth.Req req = new SendAuth.Req();
        // 应用的作用域，获取个人信息
        req.scope = "snsapi_userinfo";
        /**
         * 用于保持请求和回调的状态，授权请求后原样带回给第三方
         * 为了防止csrf攻击（跨站请求伪造攻击），后期改为随机数加session来校验
         */
        req.state = "diandi_wx_login";
        api.sendReq(req);
    }

    // 微信发送请求到第三方应用时，会回调到该方法
    @Override
    public void onReq(BaseReq req) {
        switch (req.getType()) {
            case ConstantsAPI.COMMAND_GETMESSAGE_FROM_WX:
                break;
            case ConstantsAPI.COMMAND_SHOWMESSAGE_FROM_WX:
                break;
            default:
                break;
        }
    }
    // 第三方应用发送到微信的请求处理后的响应结果，会回调到该方法
    @Override
    public void onResp(BaseResp resp) {
        //登录回调
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                String code = ((SendAuth.Resp) resp).code;
                Log.i("ssssssssssssssssssss",code);
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED://用户拒绝授权
                finish();
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL://用户取消
                finish();
                break;
            default:
                finish();
                break;
        }
    }
}