package com.neishenmo.sochat.sochatandroid.bean;

import java.util.List;

/**
 * Created by Administrator on 2018\5\2 0002.
 */

public class LoveListBean {

    /**
     * code : 200
     * msg : 获取喜欢列表成功
     * dataMap : {"thumbsUpList":[{"telephone":"17600000000","picture":"baidu.com","nickName":"阳阳3","amount":6,"tuTime":"2018-05-02 16:42:25"},{"telephone":"17600000000","picture":"baidu.com","nickName":"阳阳3","amount":9,"tuTime":"2018-05-02 16:42:31"},{"telephone":"17600000000","picture":"baidu.com","nickName":"阳阳3","amount":10,"tuTime":"2018-05-02 16:42:45"},{"telephone":"17600000000","picture":"baidu.com","nickName":"阳阳3","amount":5,"tuTime":"2018-05-02 16:43:13"}],"countThumbsUp":30}
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
         * thumbsUpList : [{"telephone":"17600000000","picture":"baidu.com","nickName":"阳阳3","amount":6,"tuTime":"2018-05-02 16:42:25"},{"telephone":"17600000000","picture":"baidu.com","nickName":"阳阳3","amount":9,"tuTime":"2018-05-02 16:42:31"},{"telephone":"17600000000","picture":"baidu.com","nickName":"阳阳3","amount":10,"tuTime":"2018-05-02 16:42:45"},{"telephone":"17600000000","picture":"baidu.com","nickName":"阳阳3","amount":5,"tuTime":"2018-05-02 16:43:13"}]
         * countThumbsUp : 30
         */

        private int countThumbsUp;
        private List<ThumbsUpListBean> thumbsUpList;

        public int getCountThumbsUp() {
            return countThumbsUp;
        }

        public void setCountThumbsUp(int countThumbsUp) {
            this.countThumbsUp = countThumbsUp;
        }

        public List<ThumbsUpListBean> getThumbsUpList() {
            return thumbsUpList;
        }

        public void setThumbsUpList(List<ThumbsUpListBean> thumbsUpList) {
            this.thumbsUpList = thumbsUpList;
        }

        public static class ThumbsUpListBean {
            /**
             * telephone : 17600000000
             * picture : baidu.com
             * nickName : 阳阳3
             * amount : 6
             * tuTime : 2018-05-02 16:42:25
             */

            private String telephone;
            private String picture;
            private String nickName;
            private int amount;
            private String tuTime;

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

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getTuTime() {
                return tuTime;
            }

            public void setTuTime(String tuTime) {
                this.tuTime = tuTime;
            }
        }
    }
}
