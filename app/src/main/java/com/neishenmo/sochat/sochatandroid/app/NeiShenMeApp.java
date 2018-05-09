package com.neishenmo.sochat.sochatandroid.app;

import android.app.Activity;
import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;
import com.neishenmo.sochat.sochatandroid.view.signin.SplaActivity;
import com.neishenmo.sochat.sochatandroid.wxapi.WXEntryActivity;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.vondear.rxtools.RxTool;

/**
 * Created by Administrator on 2018-04-24.
 */

public class NeiShenMeApp extends Application {

    public static Activity activity = new SplaActivity();
    @Override
    public void onCreate() {
        super.onCreate();
        //第二个参数也可以填 null，这样就使用它们初始化好的
        //EaseUI.getInstance().init(this, null);
        EMOptions options = new EMOptions();
        //这里我设置的是true 代表 添加好友时不需要验证
        options.setAcceptInvitationAlways(true);
        EMClient.getInstance().init(this, options);
        EaseUI.getInstance().init(this, options);
        RxTool.init(this);
        initWeiXin();
    }
    public static IWXAPI sApi;
    private void initWeiXin() {
        sApi = WXEntryActivity.initWeiXin(this,"wx143deeda4d112579" );
    }
}
