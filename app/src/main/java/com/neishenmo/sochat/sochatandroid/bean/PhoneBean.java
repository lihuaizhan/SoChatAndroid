package com.neishenmo.sochat.sochatandroid.bean;

/**
 * 小果冻
 * 手机号发送验证码
 * Created by Administrator on 2018\4\28 0028.
 */

public class PhoneBean {

    /**
     * code : 200
     * msg : 验证码发送成功
     * data : {"msgType":0}
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
         * msgType : 0
         */

        private int msgType;

        public int getMsgType() {
            return msgType;
        }

        public void setMsgType(int msgType) {
            this.msgType = msgType;
        }
    }
}
