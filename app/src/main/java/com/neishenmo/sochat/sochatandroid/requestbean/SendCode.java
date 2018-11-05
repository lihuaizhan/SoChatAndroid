package com.neishenmo.sochat.sochatandroid.requestbean;

/**
 * Created by Administrator on 2018-05-11.
 */

public class SendCode {
    private String token;
    private String telephone;
    private String msgType;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
