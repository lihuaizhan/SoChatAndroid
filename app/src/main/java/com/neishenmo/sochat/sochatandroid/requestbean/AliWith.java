package com.neishenmo.sochat.sochatandroid.requestbean;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018-05-11.
 */

public class AliWith {

    /**
     * token : 343715DB39552AB47EA3C43F37C65FFC
     * aliUserId : 2088312066711825
     * balance : 1
     * msgCode : 123456
     */

    private String token;
    private String aliUserId;
    private BigDecimal balance;
    private String msgCode;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAliUserId() {
        return aliUserId;
    }

    public void setAliUserId(String aliUserId) {
        this.aliUserId = aliUserId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }
}
