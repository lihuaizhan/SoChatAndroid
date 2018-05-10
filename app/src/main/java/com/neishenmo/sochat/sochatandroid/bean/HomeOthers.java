package com.neishenmo.sochat.sochatandroid.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018-05-04.
 */

public class HomeOthers implements Serializable{

    /**
     * code : 200
     * msg : 获取成功
     * data : {"onlineUserList":[{"userId":31,"telephone":"18710291300","nickName":"Hao","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1525310735-9A7C37E4-ACAC-4B00-8484-2D85170E1386.jpg","birthday":"1994-11-05","sex":"男","registerTime":"2018-05-03 09:24:48","constellation":"天蝎座","state":1,"ipAddr":"","balance":0,"hxPassword":"","remark":"","lon":116.300688,"lat":39.983142,"distance":-1,"simpleAddress":"","token":"","lastActiveTime":"2018-05-04 14:54:10","lastLoginTime":"2018-05-04 13:11:39"},{"userId":26,"telephone":"18310972403","nickName":"开发测试","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1525253418-841AA140-7A8C-4E31-B67E-5FEEFA77BE79.jpg","birthday":"1986-01-01","sex":"男","registerTime":"2018-05-02 17:28:02","constellation":"摩羯座","state":1,"ipAddr":"","balance":0,"hxPassword":"","remark":"","lon":116.300712,"lat":39.98316,"distance":-1,"simpleAddress":"","token":"","lastActiveTime":"2018-05-04 14:47:35","lastLoginTime":"2018-05-04 11:14:13"},{"userId":34,"telephone":"15601216629","nickName":"啊呀伊","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/405A56FEDF35A9221097DAE2316BC17E1525413259064","birthday":"2016年1月1日","sex":"男","registerTime":"2018-05-04 12:01:17","constellation":"未知","state":1,"ipAddr":"","balance":0,"hxPassword":"","remark":"","lon":0,"lat":0,"distance":-1,"simpleAddress":"","token":"","lastActiveTime":"2018-05-04 13:55:53","lastLoginTime":"2018-05-04 13:55:53"},{"userId":31,"telephone":"18710291300","nickName":"Hao","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1525310735-9A7C37E4-ACAC-4B00-8484-2D85170E1386.jpg","birthday":"1994-11-05","sex":"男","registerTime":"2018-05-03 09:24:48","constellation":"天蝎座","state":1,"ipAddr":"","balance":0,"hxPassword":"","remark":"","lon":114.158177,"lat":22.284681,"distance":-1,"simpleAddress":"","token":"","lastActiveTime":"2018-05-04 13:07:59","lastLoginTime":"2018-05-04 09:51:57"}]}
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

    public static class DataBean implements Serializable{
        private List<OnlineUserListBean> onlineUserList;

        public List<OnlineUserListBean> getOnlineUserList() {
            return onlineUserList;
        }

        public void setOnlineUserList(List<OnlineUserListBean> onlineUserList) {
            this.onlineUserList = onlineUserList;
        }

        public static class OnlineUserListBean implements Serializable {
            /**
             * userId : 31
             * telephone : 18710291300
             * nickName : Hao
             * picture : https://neishenme.oss-cn-beijing.aliyuncs.com/1525310735-9A7C37E4-ACAC-4B00-8484-2D85170E1386.jpg
             * birthday : 1994-11-05
             * sex : 男
             * registerTime : 2018-05-03 09:24:48
             * constellation : 天蝎座
             * state : 1
             * ipAddr :
             * balance : 0
             * hxPassword :
             * remark :
             * lon : 116.300688
             * lat : 39.983142
             * distance : -1
             * simpleAddress :
             * token :
             * lastActiveTime : 2018-05-04 14:54:10
             * lastLoginTime : 2018-05-04 13:11:39
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
            private double balance;
            private String hxPassword;
            private String remark;
            private double lon;
            private double lat;
            private int distance;
            private String simpleAddress;
            private String token;
            private String lastActiveTime;
            private String lastLoginTime;

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

            public double getBalance() {
                return balance;
            }

            public void setBalance(double balance) {
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

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
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
}
