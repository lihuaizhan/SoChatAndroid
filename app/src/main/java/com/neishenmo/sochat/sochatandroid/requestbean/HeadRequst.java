package com.neishenmo.sochat.sochatandroid.requestbean;

/**
 * Created by Administrator on 2018-05-04.
 */

public class HeadRequst {
    private String token;
    private String  picture;

    public HeadRequst(String token, String picture) {
        this.token = token;
        this.picture = picture;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
