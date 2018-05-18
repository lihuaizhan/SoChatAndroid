package com.neishenmo.sochat.sochatandroid.requestbean;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018-05-18.
 */

public class WeiXinRequest {
    private String token;
    private String msgCode;
    private String wxCode;
    private BigDecimal balance;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getWxCode() {
        return wxCode;
    }

    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
