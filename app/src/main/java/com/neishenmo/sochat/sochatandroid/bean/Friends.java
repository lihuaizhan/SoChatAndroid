package com.neishenmo.sochat.sochatandroid.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018-04-26.
 */

public class Friends  implements Serializable {

    /**
     * code : 200
     * msg : 获取成功
     * data : {"amount":8,"fuiList":[{"telephone":"17600000000","nickName":"阳阳3","picture":"baidu.com","frTime":"2018-04-12 14:41:03"},{"telephone":"17622222222","nickName":"哈哈大笑","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg","frTime":"2018-04-12 14:40:59"},{"telephone":"17711111111","nickName":"Gghhh","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18514702732/15205779580.jpg","frTime":"2018-04-12 14:40:51"},{"telephone":"17733333333","nickName":"123","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18513105334/15214520280.jpg","frTime":"2018-04-11 15:01:49"},{"telephone":"17633333333","nickName":"测试","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/13811261826/15205042610.jpg","frTime":"2018-04-11 14:40:57"},{"telephone":"17700000000","nickName":"京津冀","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18513105334/15214520280.jpg","frTime":"2018-04-11 14:40:53"},{"telephone":"17611111111","nickName":"阳阳2","picture":"baidu.com","frTime":"2018-04-10 14:41:01"},{"telephone":"17655555555","nickName":"小明","picture":"baidu.com","frTime":"2018-04-04 14:40:30"}]}
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

    public static class DataBean implements Serializable {
        /**
         * amount : 8
         * fuiList : [{"telephone":"17600000000","nickName":"阳阳3","picture":"baidu.com","frTime":"2018-04-12 14:41:03"},{"telephone":"17622222222","nickName":"哈哈大笑","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg","frTime":"2018-04-12 14:40:59"},{"telephone":"17711111111","nickName":"Gghhh","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18514702732/15205779580.jpg","frTime":"2018-04-12 14:40:51"},{"telephone":"17733333333","nickName":"123","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18513105334/15214520280.jpg","frTime":"2018-04-11 15:01:49"},{"telephone":"17633333333","nickName":"测试","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/13811261826/15205042610.jpg","frTime":"2018-04-11 14:40:57"},{"telephone":"17700000000","nickName":"京津冀","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/18513105334/15214520280.jpg","frTime":"2018-04-11 14:40:53"},{"telephone":"17611111111","nickName":"阳阳2","picture":"baidu.com","frTime":"2018-04-10 14:41:01"},{"telephone":"17655555555","nickName":"小明","picture":"baidu.com","frTime":"2018-04-04 14:40:30"}]
         */

        private int amount;
        private List<FuiListBean> fuiList;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public List<FuiListBean> getFuiList() {
            return fuiList;
        }

        public void setFuiList(List<FuiListBean> fuiList) {
            this.fuiList = fuiList;
        }

        public static class FuiListBean  implements Serializable {
            /**
             * telephone : 17600000000
             * nickName : 阳阳3
             * picture : baidu.com
             * frTime : 2018-04-12 14:41:03
             */

            private String telephone;
            private String nickName;
            private String picture;
            private String frTime;

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

            public String getFrTime() {
                return frTime;
            }

            public void setFrTime(String frTime) {
                this.frTime = frTime;
            }
        }
    }
}
