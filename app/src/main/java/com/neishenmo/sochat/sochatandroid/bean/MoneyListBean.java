package com.neishenmo.sochat.sochatandroid.bean;

import java.util.List;

/**
 * Created by Administrator on 2018\5\3 0003.
 */

public class MoneyListBean {

    /**
     * code : 200
     * msg : 获取红包列表成功
     * dataMap : {"redPacketList":[{"redPacketId":4,"telephone":"17600000000","nickName":"阳阳3","picture":"baidu.com","price":0.1,"time":"2018-06-08 16:26:18","type":1},{"redPacketId":3,"telephone":"17600000000","nickName":"阳阳3","picture":"baidu.com","price":0.1,"time":"2018-04-28 18:15:22","type":0},{"redPacketId":2,"telephone":"17600000000","nickName":"阳阳3","picture":"baidu.com","price":0.5,"time":"2018-04-28 17:40:57","type":0},{"redPacketId":1,"telephone":"17600000000","nickName":"阳阳3","picture":"baidu.com","price":0.01,"time":"2018-04-28 17:35:31","type":0}],"countRedPacket":4}
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
         * redPacketList : [{"redPacketId":4,"telephone":"17600000000","nickName":"阳阳3","picture":"baidu.com","price":0.1,"time":"2018-06-08 16:26:18","type":1},{"redPacketId":3,"telephone":"17600000000","nickName":"阳阳3","picture":"baidu.com","price":0.1,"time":"2018-04-28 18:15:22","type":0},{"redPacketId":2,"telephone":"17600000000","nickName":"阳阳3","picture":"baidu.com","price":0.5,"time":"2018-04-28 17:40:57","type":0},{"redPacketId":1,"telephone":"17600000000","nickName":"阳阳3","picture":"baidu.com","price":0.01,"time":"2018-04-28 17:35:31","type":0}]
         * countRedPacket : 4
         */

        private int countRedPacket;
        private List<RedPacketListBean> redPacketList;

        public int getCountRedPacket() {
            return countRedPacket;
        }

        public void setCountRedPacket(int countRedPacket) {
            this.countRedPacket = countRedPacket;
        }

        public List<RedPacketListBean> getRedPacketList() {
            return redPacketList;
        }

        public void setRedPacketList(List<RedPacketListBean> redPacketList) {
            this.redPacketList = redPacketList;
        }

        public static class RedPacketListBean {
            /**
             * redPacketId : 4
             * telephone : 17600000000
             * nickName : 阳阳3
             * picture : baidu.com
             * price : 0.1
             * time : 2018-06-08 16:26:18
             * type : 1
             */

            private int redPacketId;
            private String telephone;
            private String nickName;
            private String picture;
            private double price;
            private String time;
            private int type;

            public int getRedPacketId() {
                return redPacketId;
            }

            public void setRedPacketId(int redPacketId) {
                this.redPacketId = redPacketId;
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

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
