package com.neishenmo.sochat.sochatandroid.requestbean;

/**
 * Created by Administrator on 2018-04-25.
 */
//获取关系信息请求类
public class RelationShipRequest {
    private String pageNo;
    private String token;

    public RelationShipRequest(String pageNo, String token) {
        this.pageNo = pageNo;
        this.token = token;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
