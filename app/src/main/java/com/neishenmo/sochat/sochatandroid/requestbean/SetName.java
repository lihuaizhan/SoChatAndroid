package com.neishenmo.sochat.sochatandroid.requestbean;

/**
 * Created by Administrator on 2018-05-03.
 */

public class SetName {
    private String token;
    private String nickName;

    public SetName() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "SetName{" +
                "token='" + token + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
