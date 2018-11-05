package com.neishenmo.sochat.sochatandroid.bean;

/**
 * Created by Administrator on 2018-04-25.
 */

public class Perfect {


    /**
     * code : 200
     * msg : 完善信息成功
     * data : {"userId":4,"telephone":"17319229663","nickName":"有何不可","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg","birthday":"2006-06-06","sex":"男","registerTime":"2018-04-27 14:08:09","constellation":"双子座","state":0,"ipAddr":"","hxPassword":"EM7770Hg","remark":"","lon":0,"lat":0,"simpleAddress":"","token":"198EB70C9A81DDF0B0EF2DACB3B60C40","lastActiveTime":"2018-04-27 14:26:02"}
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
         * userId : 4
         * telephone : 17319229663
         * nickName : 有何不可
         * picture : https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg
         * birthday : 2006-06-06
         * sex : 男
         * registerTime : 2018-04-27 14:08:09
         * constellation : 双子座
         * state : 0
         * ipAddr :
         * hxPassword : EM7770Hg
         * remark :
         * lon : 0
         * lat : 0
         * simpleAddress :
         * token : 198EB70C9A81DDF0B0EF2DACB3B60C40
         * lastActiveTime : 2018-04-27 14:26:02
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
