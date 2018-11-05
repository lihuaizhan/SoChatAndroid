package com.neishenmo.sochat.sochatandroid.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018-04-26.
 */

public class Like  implements Serializable {

    /**
     * code : 200
     * msg : 获取成功
     * data : {"amount":5,"tuuiList":[{"telephone":"17611111111","nickName":"阳阳2","picture":"baidu.com","amount":5,"tuTime":"2018-04-12 12:02:03"},{"telephone":"17622222222","nickName":"哈哈大笑","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg","amount":9,"tuTime":"2018-04-11 11:54:12"},{"telephone":"17633333333","nickName":"测试","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/13811261826/15205042610.jpg","amount":10,"tuTime":"2018-04-12 11:54:33"},{"telephone":"17644444444","nickName":"阳阳4","picture":"baidu.com","amount":99,"tuTime":"2018-04-12 11:54:57"},{"telephone":"17655555555","nickName":"小明","picture":"baidu.com","amount":13,"tuTime":"2018-04-11 11:55:11"}]}
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

    public static class DataBean  implements Serializable  {
        /**
         * amount : 5
         * tuuiList : [{"telephone":"17611111111","nickName":"阳阳2","picture":"baidu.com","amount":5,"tuTime":"2018-04-12 12:02:03"},{"telephone":"17622222222","nickName":"哈哈大笑","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/17311368776/15216003370.jpg","amount":9,"tuTime":"2018-04-11 11:54:12"},{"telephone":"17633333333","nickName":"测试","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/13811261826/15205042610.jpg","amount":10,"tuTime":"2018-04-12 11:54:33"},{"telephone":"17644444444","nickName":"阳阳4","picture":"baidu.com","amount":99,"tuTime":"2018-04-12 11:54:57"},{"telephone":"17655555555","nickName":"小明","picture":"baidu.com","amount":13,"tuTime":"2018-04-11 11:55:11"}]
         */

        private int amount;
        private List<TuuiListBean> tuuiList;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public List<TuuiListBean> getTuuiList() {
            return tuuiList;
        }

        public void setTuuiList(List<TuuiListBean> tuuiList) {
            this.tuuiList = tuuiList;
        }

        public static class TuuiListBean  implements Serializable  {
            /**
             * telephone : 17611111111
             * nickName : 阳阳2
             * picture : baidu.com
             * amount : 5
             * tuTime : 2018-04-12 12:02:03
             */

            private String telephone;
            private String nickName;
            private String picture;
            private int amount;
            private String tuTime;

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
