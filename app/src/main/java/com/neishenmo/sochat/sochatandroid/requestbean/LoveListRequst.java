package com.neishenmo.sochat.sochatandroid.requestbean;

/**
 * Created by Administrator on 2018\5\2 0002.
 */

public class LoveListRequst {
    private String token;
    private String pageNo;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public LoveListRequst(String token, String pageNo) {

        this.token = token;
        this.pageNo = pageNo;
    }
}
