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
     * data : {"amount":15,"vuiList":[{"telephone":"17677777777","nickName":"哈哈哈","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18210705507/15215107340.jpg","visitTime":"2018-04-12 11:21:04"},{"telephone":"17744444444","nickName":"111","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18513105334/15214520280.jpg","visitTime":"2018-04-12 11:11:58"},{"telephone":"17722222222","nickName":"abc","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18655643170/15214463510.jpg","visitTime":"2018-04-12 11:11:53"},{"telephone":"17700000000","nickName":"京津冀","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18513105334/15214520280.jpg","visitTime":"2018-04-12 11:11:50"},{"telephone":"17666666666","nickName":"关乎","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/17691025026/15212807380.jpg","visitTime":"2018-04-12 11:11:13"},{"telephone":"17655555555","nickName":"小明","picture":"baidu.com","visitTime":"2018-04-12 11:11:02"},{"telephone":"17644444444","nickName":"阳阳4","picture":"baidu.com","visitTime":"2018-04-12 11:11:01"},{"telephone":"17633333333","nickName":"测试","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/13811261826/15205042610.jpg","visitTime":"2018-04-12 11:10:59"},{"telephone":"17611111111","nickName":"阳阳2","picture":"baidu.com","visitTime":"2018-04-12 11:10:15"},{"telephone":"17600000000","nickName":"阳阳3","picture":"baidu.com","visitTime":"2018-04-12 11:09:48"}]}
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

    public static class DataBean  implements Serializable {
        /**
         * amount : 15
         * vuiList : [{"telephone":"17677777777","nickName":"哈哈哈","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18210705507/15215107340.jpg","visitTime":"2018-04-12 11:21:04"},{"telephone":"17744444444","nickName":"111","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18513105334/15214520280.jpg","visitTime":"2018-04-12 11:11:58"},{"telephone":"17722222222","nickName":"abc","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18655643170/15214463510.jpg","visitTime":"2018-04-12 11:11:53"},{"telephone":"17700000000","nickName":"京津冀","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18513105334/15214520280.jpg","visitTime":"2018-04-12 11:11:50"},{"telephone":"17666666666","nickName":"关乎","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/17691025026/15212807380.jpg","visitTime":"2018-04-12 11:11:13"},{"telephone":"17655555555","nickName":"小明","picture":"baidu.com","visitTime":"2018-04-12 11:11:02"},{"telephone":"17644444444","nickName":"阳阳4","picture":"baidu.com","visitTime":"2018-04-12 11:11:01"},{"telephone":"17633333333","nickName":"测试","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/13811261826/15205042610.jpg","visitTime":"2018-04-12 11:10:59"},{"telephone":"17611111111","nickName":"阳阳2","picture":"baidu.com","visitTime":"2018-04-12 11:10:15"},{"telephone":"17600000000","nickName":"阳阳3","picture":"baidu.com","visitTime":"2018-04-12 11:09:48"}]
         */

        private int amount;
        private List<VuiListBean> vuiList;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public List<VuiListBean> getVuiList() {
            return vuiList;
        }

        public void setVuiList(List<VuiListBean> vuiList) {
            this.vuiList = vuiList;
        }

        public static class VuiListBean  implements Serializable  {
            /**
             * telephone : 17677777777
             * nickName : 哈哈哈
             * picture : https://neishenme.oss-cn-beijing.aliyuncs.com/18210705507/15215107340.jpg
             * visitTime : 2018-04-12 11:21:04
             */

            private String telephone;
            private String nickName;
            private String picture;
            private String visitTime;

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

            public String getVisitTime() {
                return visitTime;
            }

            public void setVisitTime(String visitTime) {
                this.visitTime = visitTime;
            }
        }
    }
}
