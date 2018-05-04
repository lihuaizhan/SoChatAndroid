package com.neishenmo.sochat.sochatandroid.bean;

/**
 * Created by Administrator on 2018-05-03.
 */

public class MyMessage {

    /**
     * code : 200
     * msg : 获取我得页面信息成功
     * dataMap : {"balance":null,"nickName":"有何不可","countRedPacket":0,"telephone":"17319229663","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg","countThumbsUp":0}
     */

    private int code;
    private String msg;
    private DataMapBean dataMap;

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

    public DataMapBean getDataMap() {
        return dataMap;
    }

    public void setDataMap(DataMapBean dataMap) {
        this.dataMap = dataMap;
    }

    public static class DataMapBean {
        /**
         * balance : null
         * nickName : 有何不可
         * countRedPacket : 0
         * telephone : 17319229663
         * picture : https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg
         * countThumbsUp : 0
         */

        private Object balance;
        private String nickName;
        private int countRedPacket;
        private String telephone;
        private String picture;
        private int countThumbsUp;

        public Object getBalance() {
            return balance;
        }

        public void setBalance(Object balance) {
            this.balance = balance;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getCountRedPacket() {
            return countRedPacket;
        }

        public void setCountRedPacket(int countRedPacket) {
            this.countRedPacket = countRedPacket;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public int getCountThumbsUp() {
            return countThumbsUp;
        }

        public void setCountThumbsUp(int countThumbsUp) {
            this.countThumbsUp = countThumbsUp;
        }
    }
}
