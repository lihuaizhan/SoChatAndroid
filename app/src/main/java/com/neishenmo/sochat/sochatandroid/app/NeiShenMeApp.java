package com.neishenmo.sochat.sochatandroid.app;

import android.app.Activity;
import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

import com.hyphenate.easeui.controller.EaseUI;

import com.neishenmo.sochat.sochatandroid.view.signin.SplaActivity;


import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


/**
 * Created by Administrator on 2018-04-24.
 */

public class NeiShenMeApp extends Application {
    public static Activity activity = new SplaActivity();

    public static IWXAPI mWxApi;
    @Override
    public void onCreate() {
        super.onCreate();
        //第二个参数也可以填 null，这样就使用它们初始化好的
        //EaseUI.getInstance().init(this, null);
        EMOptions options = new EMOptions();
        //这里我设置的是true 代表 添加好友时不需要验证
        options.setAcceptInvitationAlways(true);
        options.setAutoLogin(true);
        EMClient.getInstance().init(this, options);
        EaseUI.getInstance().init(this, options);
        registerToWX();
    }

    private void registerToWX() {
        //第二个参数是指你应用在微信开放平台上的AppID
        mWxApi = WXAPIFactory.createWXAPI(this, "wx143deeda4d112579", false);
        // 将该app注册到微信
        mWxApi.registerApp("wx143deeda4d112579");
    }
//    public static Activity activity = new SplaActivity();
////    private static NeiShenMeApp mContext;
////    private DBOpenHelper dbOpenHelper;
////    private HistoryDataManager historyDataManager;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        //mContext = this;
////        new DatasStore();
//        //第二个参数也可以填 null，这样就使用它们初始化好的
//        //EaseUI.getInstance().init(this, null);
////        EMOptions options = new EMOptions();
////        //这里我设置的是true 代表 添加好友时不需要验证
////        options.setAcceptInvitationAlways(true);
////        EMClient.getInstance().init(this, options);
//        EaseUI.getInstance().init(this, null);
//       // RxTool.init(this);
//       //initWeiXin();
//    }
////    public static IWXAPI sApi;
////    private void initWeiXin() {
////        sApi = WXEntryActivity.initWeiXin(this,"wx143deeda4d112579" );
////    }
//
////    public static NeiShenMeApp getInstance() {
////        return mContext;
////    }
//
//
////    public DBOpenHelper getDBOpenHelper() {
////        if (dbOpenHelper == null) {
////            dbOpenHelper = new DBOpenHelper(this, DatasStore.getUserPhone());
////        }
////        return dbOpenHelper;
////    }
////
////    public HistoryDataManager getHistoryDataManager() {
////        if (historyDataManager == null) {
////            historyDataManager = new HistoryDataManager(this, getDBOpenHelper().getReadableDatabase());
////        }
////        return historyDataManager;
////    }


}
