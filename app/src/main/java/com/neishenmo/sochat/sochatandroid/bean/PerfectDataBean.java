package com.neishenmo.sochat.sochatandroid.bean;

/**
 * Created by Administrator on 2018\4\28 0028.
 */

public class PerfectDataBean {


    /**
     * code : 200
     * msg : 注册成功
     * data : {"telephone":"17612341234","nickName":"测试0","picture":"baidu.com","birthday":"2006-06-06","sex":"男","registerTime":"2018-05-14 11:38:21","constellation":"双子座","state":1,"ipAddr":"127.0.0.1","balance":0,"userId":"NHPEV5lZ","hxPassword":"W9b9E6gQ","remark":"","lon":0,"lat":0,"distance":-1,"simpleAddress":"","token":"766142657032B0BA91AF26479668FCC7","lastActiveTime":"2018-05-14 11:38:21","lastLoginTime":"2018-05-14 11:38:21"}
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
         * telephone : 17612341234
         * nickName : 测试0
         * picture : baidu.com
         * birthday : 2006-06-06
         * sex : 男
         * registerTime : 2018-05-14 11:38:21
         * constellation : 双子座
         * state : 1
         * ipAddr : 127.0.0.1
         * balance : 0.0
         * userId : NHPEV5lZ
         * hxPassword : W9b9E6gQ
         * remark :
         * lon : 0.0
         * lat : 0.0
         * distance : -1.0
         * simpleAddress :
         * token : 766142657032B0BA91AF26479668FCC7
         * lastActiveTime : 2018-05-14 11:38:21
         * lastLoginTime : 2018-05-14 11:38:21
         */

        private String telephone;
        private String nickName;
        private String picture;
        private String birthday;
        private String sex;
        private String registerTime;
        private String constellation;
        private int state;
        private String ipAddr;
        private double balance;
        private String userId;
        private String hxPassword;
        private String remark;
        private double lon;
        private double lat;
        private double distance;
        private String simpleAddress;
        private String token;
        private String lastActiveTime;
        private String lastLoginTime;

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

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
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
