package com.neishenmo.sochat.sochatandroid.net;


import com.neishenmo.sochat.sochatandroid.bean.Friends;
import com.neishenmo.sochat.sochatandroid.bean.HomeListBean;
import com.neishenmo.sochat.sochatandroid.bean.HomeOthers;
import com.neishenmo.sochat.sochatandroid.bean.Like;
import com.neishenmo.sochat.sochatandroid.bean.LogOut;
import com.neishenmo.sochat.sochatandroid.bean.LoveListBean;
import com.neishenmo.sochat.sochatandroid.bean.MoneyListBean;
import com.neishenmo.sochat.sochatandroid.bean.MyMessage;
import com.neishenmo.sochat.sochatandroid.bean.OtherLiveMsg;
import com.neishenmo.sochat.sochatandroid.bean.Perfect;
import com.neishenmo.sochat.sochatandroid.bean.PerfectDataBean;
import com.neishenmo.sochat.sochatandroid.bean.PhoneBean;
import com.neishenmo.sochat.sochatandroid.bean.SignBean;
import com.neishenmo.sochat.sochatandroid.bean.Thumbs;
import com.neishenmo.sochat.sochatandroid.bean.VerificationBean;
import com.neishenmo.sochat.sochatandroid.bean.Visitor;
import com.neishenmo.sochat.sochatandroid.requestbean.HeadRequst;
import com.neishenmo.sochat.sochatandroid.requestbean.HomeRequst;
import com.neishenmo.sochat.sochatandroid.requestbean.LoveListRequst;
import com.neishenmo.sochat.sochatandroid.requestbean.MoneyListRequst;
import com.neishenmo.sochat.sochatandroid.requestbean.PerfectDataRequst;
import com.neishenmo.sochat.sochatandroid.requestbean.PerfectRequest;
import com.neishenmo.sochat.sochatandroid.requestbean.PhoneRequest;
import com.neishenmo.sochat.sochatandroid.requestbean.RelationShipRequest;
import com.neishenmo.sochat.sochatandroid.requestbean.SetName;
import com.neishenmo.sochat.sochatandroid.requestbean.SignRequst;
import com.neishenmo.sochat.sochatandroid.requestbean.VerificationRequst;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by dell on 2018-02-26  16:31
 */
//Retrofit请求API
public interface ServiceApi {

    //关系
    //来访
    @POST(ConnectorApi.GETVISITOR_LIST_URL + ConnectorApi.SUFFIX)
    Observable<Visitor> getVisitor(@Body RelationShipRequest request);
    //喜欢
    @POST(ConnectorApi.GETTHUMBS_LIST_URL + ConnectorApi.SUFFIX)
    Observable<Like> getLike(@Body RelationShipRequest request);
    //好友
    @POST(ConnectorApi.GETFRIENDS_LIST_URL + ConnectorApi.SUFFIX)
    Observable<Friends> getFriends(@Body RelationShipRequest request);
    //完善信息
    @POST(ConnectorApi.PERFECT_URL + ConnectorApi.SUFFIX)
    Observable<Perfect> setPerfect(@Body PerfectRequest request);
    /**
     *  手机号发送验证码
     */
    @POST(ConnectorApi.VERIFICATION_URL+ConnectorApi.SUFFIX)
    Observable<PhoneBean> getPhone(@Body PhoneRequest request);
    /**
     * 验证登录验证码
     */
    @POST(ConnectorApi.LOGIN_URL+ConnectorApi.SUFFIX)
    Observable<VerificationBean> getVerification(@Body VerificationRequst requst);
    /**
     * 验证注册验证码
     */
    @POST(ConnectorApi.REGIS_URL+ConnectorApi.SUFFIX)
    Observable<SignBean> getSign(@Body SignRequst requst);
    /**
     * 完善个人信息
     */
    @POST(ConnectorApi.PERFECT_URL+ConnectorApi.SUFFIX)
    Observable<PerfectDataBean> getPerfectData(@Body PerfectDataRequst requst);
    /**
     * 获取首页列表信息
     */
    @POST(ConnectorApi.HOME_DATA_URL+ConnectorApi.SUFFIX)
    Observable<HomeListBean> getHomeList(@Body HomeRequst requst);
    /**
     * 获取点击喜欢我的列表
     */
    @POST(ConnectorApi.LOVE_LIST_URL+ConnectorApi.SUFFIX)
    Observable<LoveListBean> getLoveList(@Body LoveListRequst requst);
    /**
     * 退出登录
     * */
    @POST(ConnectorApi.LOG_OUT_URL+ConnectorApi.SUFFIX)
    Observable<LogOut> logOut(@Body RelationShipRequest requst);
    /**
     * 获取我的页面信息
     * */
    @POST(ConnectorApi.MY_MESSAGE_URL+ConnectorApi.SUFFIX)
    Observable<MyMessage> getMyMessage(@Body RelationShipRequest requst);
    /**
     * 修改昵称
     * */
    @POST(ConnectorApi.MODIFY_NICK_NAME_URL+ConnectorApi.SUFFIX)
    Observable<LogOut> setName(@Body SetName requst);

    /**
     * 获取红包列表
     */
    @POST(ConnectorApi.MONEY_LIST_URL+ConnectorApi.SUFFIX)
    Observable<MoneyListBean> getMonet(@Body MoneyListRequst requst);
    /**
     * 获取首页信息
     */
    @POST(ConnectorApi.HOME_DATA_URL+ConnectorApi.SUFFIX)
    Observable<HomeOthers> getHomeOthers(@Body MoneyListRequst requst);
    /**
     * 获取点赞状态
     */
    @POST(ConnectorApi.LIKE_URL+ConnectorApi.SUFFIX)
    Observable<LogOut> setThumbs(@Body Thumbs requst);
    /**
     * 修改头像
     */
    @POST(ConnectorApi.MODIFY_PICYURE_URL+ConnectorApi.SUFFIX)
    Observable<LogOut> setHead(@Body HeadRequst requst);
    /**
     * 获取他人动态信息
     */
    @POST(ConnectorApi.GETLIVE_MSG_URL+ConnectorApi.SUFFIX)
    Observable<OtherLiveMsg> getOtherLive(@Body PhoneRequest requst);


}
