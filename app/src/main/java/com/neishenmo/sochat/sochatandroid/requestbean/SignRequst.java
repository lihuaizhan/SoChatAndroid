package com.neishenmo.sochat.sochatandroid.requestbean;

/**
 * Created by Administrator on 2018\4\28 0028.
 */

public class SignRequst {
    private String telephone;
    private String msgCode;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public SignRequst(String telephone, String msgCode) {
        this.telephone = telephone;
        this.msgCode = msgCode;
    }
}
