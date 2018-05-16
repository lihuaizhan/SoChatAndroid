package com.neishenmo.sochat.sochatandroid.bean;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018\4\28 0028.
 */

public class VerificationBean {

    /**
     * code : 200
     * msg : 登陆成功
     * data : {"userId":6,"telephone":"17319229663","nickName":"有何不可\n","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/857571E799AAE56AE44412058D7C7DDD1526264107795","birthday":"1993年1月1日","sex":"男","registerTime":"2018-05-09 17:17:47","constellation":"未知","state":1,"ipAddr":"","balance":8,"hxPassword":"9jOY21D8","remark":"","lon":0,"lat":0,"distance":-1,"simpleAddress":"","token":"E81B68703A29643AC636A8E5DA33C3D0","lastActiveTime":"2018-05-15 16:44:06","lastLoginTime":"2018-05-15 16:44:06"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userId : 6
         * telephone : 17319229663
         * nickName : 有何不可

         * picture : https://neishenme.oss-cn-beijing.aliyuncs.com/857571E799AAE56AE44412058D7C7DDD1526264107795
         * birthday : 1993年1月1日
         * sex : 男
         * registerTime : 2018-05-09 17:17:47
         * constellation : 未知
         * state : 1
         * ipAddr :
         * balance : 8
         * hxPassword : 9jOY21D8
         * remark :
         * lon : 0
         * lat : 0
         * distance : -1
         * simpleAddress :
         * token : E81B68703A29643AC636A8E5DA33C3D0
         * lastActiveTime : 2018-05-15 16:44:06
         * lastLoginTime : 2018-05-15 16:44:06
         */

        private String userId;
        private String telephone;
        private String nickName;
        private String picture;
        private String birthday;
        private String sex;
        private String registerTime;
        private String constellation;
        private int state;
        private String ipAddr;
        private BigDecimal balance;
        private String hxPassword;
        private String remark;
        private double lon;
        private double lat;
        private double distance;
        private String simpleAddress;
        private String token;
        private String lastActiveTime;
        private String lastLoginTime;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
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

        public String getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(String registerTime) {
            this.registerTime = registerTime;
        }

        public String getConstellation() {
            return constellation;
        }

        public void setConstellation(String constellation) {
            this.constellation = constellation;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getIpAddr() {
            return ipAddr;
        }

        public void setIpAddr(String ipAddr) {
            this.ipAddr = ipAddr;
        }

        public BigDecimal getBalance() {
            return balance;
        }

        public void setBalance(BigDecimal balance) {
            this.balance = balance;
        }

        public String getHxPassword() {
            return hxPassword;
        }

        public void setHxPassword(String hxPassword) {
            this.hxPassword = hxPassword;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getSimpleAddress() {
            return simpleAddress;
        }

        public void setSimpleAddress(String simpleAddress) {
            this.simpleAddress = simpleAddress;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getLastActiveTime() {
            return lastActiveTime;
        }

        public void setLastActiveTime(String lastActiveTime) {
            this.lastActiveTime = lastActiveTime;
        }

        public String getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(String lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }
    }
}
