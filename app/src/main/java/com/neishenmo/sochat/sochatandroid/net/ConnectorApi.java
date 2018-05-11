package com.neishenmo.sochat.sochatandroid.net;

/**
 * Created by dell on 2018-02-26  16:31
 * 接口api
 */

public class ConnectorApi {

    //生成环境
    public static final String BASE_URL = "http://47.104.134.162/nsm-master/";
    //后缀
    public static final String SUFFIX = ".shtml";
    //发送外部验证码（登陆、注册）,params:telephone;
    public static final String VERIFICATION_URL = "msgCode/sendExternalCode";
    //发送内部验证码（钱包支付、提现）
    public static final String PAY_URL = "msgCode/sendInternalCode";
    //用户注册
    public static final String REGIS_URL = "user/registUser";
    //完善用户资料
    public static final String PERFECT_URL = "user/perfectUser";
    //用户登录
    public static final String LOGIN_URL = "user/userLogin";
    //获取首页用户列表
    public static final String HOME_DATA_URL = "home/onlineUser";
    //点赞,喜欢
    public static final String LIKE_URL = "thumbsUp/thumbsUpToTelephone";
    //用户更新位置(每5分钟更新一次)
    public static final String ADDRESS_URL = "behavior/updateLocation";
    //获取他人的基本资料
    public static final String GETDATA_URL = "otherUser/getOtherUserInfo";
    //获取他人的动态列表
    public static final String GETLIVE_MSG_URL = "otherUser/getOtherUserLiveMsg";
    //获取来访列表
    public static final String GETVISITOR_LIST_URL = "relationship/getVisitorList";
    //获取喜欢列表
    public static final String GETTHUMBS_LIST_URL = "relationship/getThumbsUpList";
    //获取好友列表
    public static final String GETFRIENDS_LIST_URL = "relationship/getFriendsList";
    //修改头像
    public static final String MODIFY_PICYURE_URL = "mine/modifyPicture";
    //修改昵称
    public static final String MODIFY_NICK_NAME_URL = "mine/modifyNickName";
    //获取喜欢的人列表
    public static final String LOVE_LIST_URL = "mine/getMineThumbsUpList";
    //退出登录
    public static final String LOG_OUT_URL = "user/signOut";
    //获取我的页面信息
    public static final String MY_MESSAGE_URL = "mine/getMineInfo";
    //获取红包列表
    public static final String MONEY_LIST_URL = "mine/getMineRedPacketList";
    //支付宝提现授权接口
    public static final String ALI_AUTH_LOGIN  = "AliPay/aliAuthLogin";
    //支付宝提现
    public static final String ALI_WITHD_RAWAL  = "AliPay/aliWithdrawal";

}
