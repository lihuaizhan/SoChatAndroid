package com.neishenmo.sochat.sochatandroid.bean;

/**
 * Created by Administrator on 2018-05-22.
 */

public class BaseData {

    /**
     * code : 200
     * msg : 获取成功
     * data : {"otherUserInfo":{"telephone":"11100000047","nickName":"冬天开出牵牛花","picture":"http://img5.duitang.com/uploads/item/201611/18/20161118090311_Cw2dU.jpeg","birthday":"1995-01-05","sex":"女","constellation":"摩羯座","distance":6712759,"thumbsUpNum":20,"redPacketNum":0}}
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
         * otherUserInfo : {"telephone":"11100000047","nickName":"冬天开出牵牛花","picture":"http://img5.duitang.com/uploads/item/201611/18/20161118090311_Cw2dU.jpeg","birthday":"1995-01-05","sex":"女","constellation":"摩羯座","distance":6712759,"thumbsUpNum":20,"redPacketNum":0}
         */

        private OtherUserInfoBean otherUserInfo;

        public OtherUserInfoBean getOtherUserInfo() {
            return otherUserInfo;
        }

        public void setOtherUserInfo(OtherUserInfoBean otherUserInfo) {
            this.otherUserInfo = otherUserInfo;
        }

        public static class OtherUserInfoBean {
            /**
             * telephone : 11100000047
             * nickName : 冬天开出牵牛花
             * picture : http://img5.duitang.com/uploads/item/201611/18/20161118090311_Cw2dU.jpeg
             * birthday : 1995-01-05
             * sex : 女
             * constellation : 摩羯座
             * distance : 6712759
             * thumbsUpNum : 20
             * redPacketNum : 0
             */

            private String telephone;
            private String nickName;
            private String picture;
            private String birthday;
            private String sex;
            private String constellation;
            private int distance;
            private int thumbsUpNum;
            private int redPacketNum;

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

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getThumbsUpNum() {
                return thumbsUpNum;
            }

            public void setThumbsUpNum(int thumbsUpNum) {
                this.thumbsUpNum = thumbsUpNum;
            }

            public int getRedPacketNum() {
                return redPacketNum;
            }

            public void setRedPacketNum(int redPacketNum) {
                this.redPacketNum = redPacketNum;
            }
        }
    }
}
