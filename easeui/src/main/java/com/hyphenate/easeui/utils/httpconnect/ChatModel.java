package com.hyphenate.easeui.utils.httpconnect;

import android.util.Log;

import com.google.gson.Gson;
import com.hyphenate.easeui.utils.HttpPostUtils;
import com.hyphenate.easeui.utils.PostWordModel;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/29.
 */

public class ChatModel extends BaseModel {


    /**
     * 用户聊天记录保存接口
     *
     * @param bib
     */
    public void sendTheMessage(String telephonefrom, String content, String telephoneto, final BaseModelIB bib) {
        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
        if (bib == null)
            Log.e("TTError", "appnsm 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams("UTF-8");
        //传递参数
        List<PostWordModel> map = new ArrayList<>();
        map.add(new PostWordModel("telephonefrom", telephonefrom));
        map.add(new PostWordModel("content", content));
        map.add(new PostWordModel("telephoneto", telephoneto));

        HttpPostUtils.postSysHead("17");
        HttpPostUtils.postBody(map);
        Gson gson = new Gson();
        try {
            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
            params.setBodyEntity(new StringEntity(code, "UTF-8"));
            params.setContentType("application/json");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (!StringUtil.isEmpty(resultInfo.result) && resultInfo.result.substring(0, 1).equals("[")) { // 成功
                    BIBSucessful(bib, resultInfo.result);
                } else {// 失败
                    BIBFailed(bib, "网络状态不佳..."); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }

    /**
     * 一个用户对另外一个用户认识接口数据添加
     *
     * @param knowedbody:被认识的人手机号
     * @param knowbody：认识的人手机号
     * @param bib
     */
    public void toKnow(String knowedbody, String knowbody, final BaseModelIB bib) {
        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
        if (bib == null)
            Log.e("TTError", "address_del 参数bib为null"); // 回调不能为空

        BIBStart(bib); // 开始bib
        RequestParams params = new RequestParams("UTF-8");
        //传递参数
        List<PostWordModel> map = new ArrayList<>();
        map.add(new PostWordModel("knowedbody", knowedbody));
        map.add(new PostWordModel("knowbody", knowbody));

        HttpPostUtils.postSysHead("11");
        HttpPostUtils.postBody(map);
        Gson gson = new Gson();
        try {
            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
            params.setBodyEntity(new StringEntity(code, "UTF-8"));
            params.setContentType("application/json");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
            @Override
            public void onSuccess(ResponseInfo<String> resultInfo) {
                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
                if (resultInfo.result.substring(0, 1).equals("[")) { // 成功
                    BIBSucessful(bib, resultInfo.result);
                } else {// 失败
                    BIBFailed(bib, "网络状态不佳..."); // 失败标志位
                }
            }

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
            }
        });
    }
}
