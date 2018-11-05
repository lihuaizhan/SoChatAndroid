package com.neishenmo.sochat.sochatandroid.requestbean;

/**
 * Created by Administrator on 2018\5\3 0003.
 */

public class MoneyListRequst {
    private String token;
    private String pageNo;

    public MoneyListRequst(String token, String pageNo) {
        this.token = token;
        this.pageNo = pageNo;
    }

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
}
