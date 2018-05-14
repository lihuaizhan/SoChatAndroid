package com.hyphenate.easeui.utils;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;

import java.util.List;


/**
 * Created by Administrator on 2018/1/2.
 */

public class HttpPostUtils {
    private static JSONObject params = new JSONObject();
    private static JSONObject sys_head = new JSONObject();
    private static JSONObject body = new JSONObject();


    public static void postSysHead( String scene_id) {
        sys_head.clear();
        sys_head.put("service_id", "120020007");
        sys_head.put("scene_id", scene_id);
        params.put("sys_head", sys_head);
    }

    public static void postBody(List<PostWordModel> map) {
        body.clear();
        for (int i = 0; i < map.size(); i++) {
                body.put(map.get(i).key, map.get(i).value);
        }
        params.put("body", body);
    }

    public static JSONObject getPostData() {
        Log.e("上传消息","上传的参数为：" + params.toJSONString());
        return params;
    }

    @Override
    public String toString() {
        return "sys_head:" + sys_head.getString("service_id");
    }
}
