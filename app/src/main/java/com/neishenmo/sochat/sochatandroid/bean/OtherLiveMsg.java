package com.neishenmo.sochat.sochatandroid.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018-05-07.
 */

public class OtherLiveMsg implements Serializable{

    /**
     * code : 200
     * msg : 获取动态列表成功
     * data : {"pageNo":1,"bList":[{"behaviorId":177,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:47"},{"behaviorId":178,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:47"},{"behaviorId":179,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:47"},{"behaviorId":171,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:46"},{"behaviorId":172,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:46"},{"behaviorId":173,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:46"},{"behaviorId":174,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:46"},{"behaviorId":175,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:46"},{"behaviorId":176,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:46"},{"behaviorId":170,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:45"}]}
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

    public static class DataBean implements Serializable{
        /**
         * pageNo : 1
         * bList : [{"behaviorId":177,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:47"},{"behaviorId":178,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:47"},{"behaviorId":179,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:47"},{"behaviorId":171,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:46"},{"behaviorId":172,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:46"},{"behaviorId":173,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:46"},{"behaviorId":174,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:46"},{"behaviorId":175,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:46"},{"behaviorId":176,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:46"},{"behaviorId":170,"type":1,"content":"{\"amount\":\"1\",\"telephone\":\"17611427239\",\"picture\":\"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12\"}","telephone":"18515280383","telephoned":"","behaviorTime":"2018-05-07 14:28:45"}]
         */

        private int pageNo;
        private List<BListBean> bList;

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public List<BListBean> getBList() {
            return bList;
        }

        public void setBList(List<BListBean> bList) {
            this.bList = bList;
        }

        public static class BListBean implements Serializable{
            /**
             * behaviorId : 177
             * type : 1
             * content : {"amount":"1","telephone":"17611427239","picture":"https://neishenme.oss-cn-beijing.aliyuncs.com/09458C2721E87C96D6F19714A85FBE6E2018-05-03 17:55:12"}
             * telephone : 18515280383
             * telephoned :
             * behaviorTime : 2018-05-07 14:28:47
             */

            private int behaviorId;
            private int type;
            private String content;
            private String telephone;
            private String telephoned;
            private String behaviorTime;

            public int getBehaviorId() {
                return behaviorId;
            }

            public void setBehaviorId(int behaviorId) {
                this.behaviorId = behaviorId;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public String getTelephoned() {
                return telephoned;
            }

            public void setTelephoned(String telephoned) {
                this.telephoned = telephoned;
            }

            public String getBehaviorTime() {
                return behaviorTime;
            }

            public void setBehaviorTime(String behaviorTime) {
                this.behaviorTime = behaviorTime;
            }
        }
    }
}
