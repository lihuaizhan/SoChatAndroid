package com.neishenmo.sochat.sochatandroid.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018-04-25.
 */

public class Visitor  implements Serializable {


    /**
     * code : 200
     * msg : 获取成功
     * data : {"vuiAmount":7,"vuiOnlineAmount":4,"vuiList":[{"telephone":"13910730911","nickName":"Quenti","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526570742-72D3B7DA-FC35-4C3E-87CF-9292A4C14637.jpg","birthday":"1997-02-01","sex":"男","constellation":"水瓶座","userId":"hx20180517114617387002","visitTime":"2018-05-17 11:46:36","lon":0,"lat":0,"distance":-1,"lastActiveTime":"2018-05-18 11:48:39","isOnline":1},{"telephone":"17611398776","nickName":"123","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526529105-70329CEB-FF17-4018-9DDA-2B54808C2E18.jpg","birthday":"1995-12-05","sex":"男","constellation":"射手座","userId":"hx20180517115145121003","visitTime":"2018-05-17 17:49:44","lon":0,"lat":0,"distance":-1,"lastActiveTime":null,"isOnline":0},{"telephone":"18710291300","nickName":"Hao","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526530930-F9A8BC2F-72A7-4660-8F65-49C5BDC42407.jpg","birthday":"1994-11-05","sex":"男","constellation":"天蝎座","userId":"hx20180517122210506006","visitTime":"2018-05-17 18:55:31","lon":0,"lat":0,"distance":-1,"lastActiveTime":"2018-05-18 11:51:54","isOnline":1},{"telephone":"18300000009","nickName":"%E4%BD%A0%E4%BD%A0%E4%BD%A0","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526552287-5DA6950A-19C1-46BB-8B9E-55C9B62CB22B.jpg","birthday":"1996-01-01","sex":"男","constellation":"摩羯座","userId":"hx20180517181807861009","visitTime":"2018-05-17 18:31:02","lon":0,"lat":0,"distance":-1,"lastActiveTime":null,"isOnline":0},{"telephone":"18300000001","nickName":"%E6%B5%8B%E8%AF%95%E4%B8%80","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526528190-5B9269FA-BB84-4805-A5DC-D049105D6D9F.jpg","birthday":"1995-01-01","sex":"男","constellation":"摩羯座","userId":"hx20180517113630481000","visitTime":"2018-05-17 19:05:22","lon":0,"lat":0,"distance":-1,"lastActiveTime":null,"isOnline":0},{"telephone":"18300000007","nickName":"%E5%95%A6%E5%95%A6%E9%98%9F","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526556430-77CE1DC8-7242-4E57-85CC-CB861BDDBC8E.jpg","birthday":"1994-01-01","sex":"男","constellation":"摩羯座","userId":"hx20180517192709993010","visitTime":"2018-05-17 20:38:05","lon":0,"lat":0,"distance":-1,"lastActiveTime":null,"isOnline":0},{"telephone":"18300000010","nickName":"Eleven","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526608279-2296C004-F60D-4C26-B6F5-37E232A9132B.jpg","birthday":"2004-05-01","sex":"男","constellation":"金牛座","userId":"hx20180518095119758013","visitTime":"2018-05-18 10:53:55","lon":0,"lat":0,"distance":-1,"lastActiveTime":"2018-05-18 12:19:24","isOnline":1}]}
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
         * vuiAmount : 7
         * vuiOnlineAmount : 4
         * vuiList : [{"telephone":"13910730911","nickName":"Quenti","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526570742-72D3B7DA-FC35-4C3E-87CF-9292A4C14637.jpg","birthday":"1997-02-01","sex":"男","constellation":"水瓶座","userId":"hx20180517114617387002","visitTime":"2018-05-17 11:46:36","lon":0,"lat":0,"distance":-1,"lastActiveTime":"2018-05-18 11:48:39","isOnline":1},{"telephone":"17611398776","nickName":"123","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526529105-70329CEB-FF17-4018-9DDA-2B54808C2E18.jpg","birthday":"1995-12-05","sex":"男","constellation":"射手座","userId":"hx20180517115145121003","visitTime":"2018-05-17 17:49:44","lon":0,"lat":0,"distance":-1,"lastActiveTime":null,"isOnline":0},{"telephone":"18710291300","nickName":"Hao","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526530930-F9A8BC2F-72A7-4660-8F65-49C5BDC42407.jpg","birthday":"1994-11-05","sex":"男","constellation":"天蝎座","userId":"hx20180517122210506006","visitTime":"2018-05-17 18:55:31","lon":0,"lat":0,"distance":-1,"lastActiveTime":"2018-05-18 11:51:54","isOnline":1},{"telephone":"18300000009","nickName":"%E4%BD%A0%E4%BD%A0%E4%BD%A0","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526552287-5DA6950A-19C1-46BB-8B9E-55C9B62CB22B.jpg","birthday":"1996-01-01","sex":"男","constellation":"摩羯座","userId":"hx20180517181807861009","visitTime":"2018-05-17 18:31:02","lon":0,"lat":0,"distance":-1,"lastActiveTime":null,"isOnline":0},{"telephone":"18300000001","nickName":"%E6%B5%8B%E8%AF%95%E4%B8%80","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526528190-5B9269FA-BB84-4805-A5DC-D049105D6D9F.jpg","birthday":"1995-01-01","sex":"男","constellation":"摩羯座","userId":"hx20180517113630481000","visitTime":"2018-05-17 19:05:22","lon":0,"lat":0,"distance":-1,"lastActiveTime":null,"isOnline":0},{"telephone":"18300000007","nickName":"%E5%95%A6%E5%95%A6%E9%98%9F","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526556430-77CE1DC8-7242-4E57-85CC-CB861BDDBC8E.jpg","birthday":"1994-01-01","sex":"男","constellation":"摩羯座","userId":"hx20180517192709993010","visitTime":"2018-05-17 20:38:05","lon":0,"lat":0,"distance":-1,"lastActiveTime":null,"isOnline":0},{"telephone":"18300000010","nickName":"Eleven","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/1526608279-2296C004-F60D-4C26-B6F5-37E232A9132B.jpg","birthday":"2004-05-01","sex":"男","constellation":"金牛座","userId":"hx20180518095119758013","visitTime":"2018-05-18 10:53:55","lon":0,"lat":0,"distance":-1,"lastActiveTime":"2018-05-18 12:19:24","isOnline":1}]
         */

        private int vuiAmount;
        private int vuiOnlineAmount;
        private List<VuiListBean> vuiList;

        public int getVuiAmount() {
            return vuiAmount;
        }

        public void setVuiAmount(int vuiAmount) {
            this.vuiAmount = vuiAmount;
        }

        public int getVuiOnlineAmount() {
            return vuiOnlineAmount;
        }

        public void setVuiOnlineAmount(int vuiOnlineAmount) {
            this.vuiOnlineAmount = vuiOnlineAmount;
        }

        public List<VuiListBean> getVuiList() {
            return vuiList;
        }

        public void setVuiList(List<VuiListBean> vuiList) {
            this.vuiList = vuiList;
        }

        public static class VuiListBean {
            /**
             * telephone : 13910730911
             * nickName : Quenti
             * picture : https://neishenme.oss-cn-beijing.aliyuncs.com/1526570742-72D3B7DA-FC35-4C3E-87CF-9292A4C14637.jpg
             * birthday : 1997-02-01
             * sex : 男
             * constellation : 水瓶座
             * userId : hx20180517114617387002
             * visitTime : 2018-05-17 11:46:36
             * lon : 0
             * lat : 0
             * distance : -1
             * lastActiveTime : 2018-05-18 11:48:39
             * isOnline : 1
             */

            private String telephone;
            private String nickName;
            private String picture;
            private String birthday;
            private String sex;
            private String constellation;
            private String userId;
            private String visitTime;
            private int lon;
            private int lat;
            private int distance;
            private String lastActiveTime;
            private int isOnline;

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

            public String getConstellation() {
                return constellation;
            }

            public void setConstellation(String constellation) {
                this.constellation = constellation;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getVisitTime() {
                return visitTime;
            }

            public void setVisitTime(String visitTime) {
                this.visitTime = visitTime;
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

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public String getLastActiveTime() {
                return lastActiveTime;
            }

            public void setLastActiveTime(String lastActiveTime) {
                this.lastActiveTime = lastActiveTime;
            }

            public int getIsOnline() {
                return isOnline;
            }

            public void setIsOnline(int isOnline) {
                this.isOnline = isOnline;
            }
        }
    }
}
