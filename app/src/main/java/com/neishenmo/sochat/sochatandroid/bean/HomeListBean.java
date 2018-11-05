package com.neishenmo.sochat.sochatandroid.bean;

import java.util.List;

/**
 * Created by Administrator on 2018\5\2 0002.
 */

public class HomeListBean {

    /**
     * code : 200
     * msg : 获取在线用户成功（临时用户）
     * data : {"onlineUserList":[{"telephone":"17611398777","nickName":"阳阳4","picture":"baidu.com","birthday":"2006-06-06","sex":"男","registerTime":"2018-03-20 09:53:50","constellation":"双子座","state":1,"ipAddr":"","password":"","remark":"","lon":0,"lat":0,"simpleAddress":"","token":"","lastActiveTime":"2018-04-11 14:44:33","distance":50}]}
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
        private List<OnlineUserListBean> onlineUserList;

        public List<OnlineUserListBean> getOnlineUserList() {
            return onlineUserList;
        }

        public void setOnlineUserList(List<OnlineUserListBean> onlineUserList) {
            this.onlineUserList = onlineUserList;
        }

        public static class OnlineUserListBean {
            /**
             * telephone : 17611398777
             * nickName : 阳阳4
             * picture : baidu.com
             * birthday : 2006-06-06
             * sex : 男
             * registerTime : 2018-03-20 09:53:50
             * constellation : 双子座
             * state : 1
             * ipAddr :
             * password :
             * remark :
             * lon : 0
             * lat : 0
             * simpleAddress :
             * token :
             * lastActiveTime : 2018-04-11 14:44:33
             * distance : 50
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
            private String password;
            private String remark;
            private int lon;
            private int lat;
            private String simpleAddress;
            private String token;
            private String lastActiveTime;
            private int distance;

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

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
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

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }
        }
    }
}
