package com.neishenmo.sochat.sochatandroid.requestbean;

/**
 * Created by Administrator on 2018-04-27.
 */

public class PerfectRequest {
    private String token;
    private String nickName;
    private String picture;
    private String birthday;
    private String sex;

    public PerfectRequest() {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PerfectRequest{" +
                "token='" + token + '\'' +
                ", nickName='" + nickName + '\'' +
                ", picture='" + picture + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
