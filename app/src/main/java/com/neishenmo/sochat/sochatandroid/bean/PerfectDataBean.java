package com.neishenmo.sochat.sochatandroid.bean;

/**
 * Created by Administrator on 2018\4\28 0028.
 */

public class PerfectDataBean {

    /**
     * code : 200
     * msg : 完善信息成功
     * data : {"userId":2,"telephone":"17611398776","nickName":"阳阳","picture":"baidu.com","birthday":"2006-06-06","sex":"男","registerTime":"2018-04-27 13:25:49","constellation":"双子座","state":0,"ipAddr":"","hxPassword":"KJ73Vz0d","remark":"","lon":0,"lat":0,"simpleAddress":"","token":"B0BAFA29F5E138B2F1BFB1C70A7AB662","lastActiveTime":"2018-04-27 13:26:05"}
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
         * userId : 2
         * telephone : 17611398776
         * nickName : 阳阳
         * picture : baidu.com
         * birthday : 2006-06-06
         * sex : 男
         * registerTime : 2018-04-27 13:25:49
         * constellation : 双子座
         * state : 0
         * ipAddr :
         * hxPassword : KJ73Vz0d
         * remark :
         * lon : 0
         * lat : 0
         * simpleAddress :
         * token : B0BAFA29F5E138B2F1BFB1C70A7AB662
         * lastActiveTime : 2018-04-27 13:26:05
         */

        private int userId;
        private String telephone;
        private String nickName;
        private String picture;
        private String birthday;
        private String sex;
        private String registerTime;
        private String constellation;
        private int state;
        private String ipAddr;
        private String hxPassword;
        private String remark;
        private int lon;
        private int lat;
        private String simpleAddress;
        private String token;
        private String lastActiveTime;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
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

        public int getLon() {
            return lon;
        }

        public void setLon(int lon) {
            this.lon = lon;
        }

        public int getLat() {
            return lat;
        }

        public void setLat(int lat) {
            this.lat = lat;
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
    }
}
