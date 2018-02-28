package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/26.
 */

public class LCGZResult {


    /**
     * Rst : {"Msg":"请求成功！","List":[{"time":"2017-12-03 16:54:11","nodename":"开始","actionname":"李辛","comments":""},{"time":"2017-12-03 16:54:11","nodename":"开始","actionname":"李辛","comments":""}]}
     * Stu : 1
     */

    private RstBean Rst;
    private int Stu;

    public RstBean getRst() {
        return Rst;
    }

    public void setRst(RstBean Rst) {
        this.Rst = Rst;
    }

    public int getStu() {
        return Stu;
    }

    public void setStu(int Stu) {
        this.Stu = Stu;
    }

    public static class RstBean {
        /**
         * Msg : 请求成功！
         * List : [{"time":"2017-12-03 16:54:11","nodename":"开始","actionname":"李辛","comments":""},{"time":"2017-12-03 16:54:11","nodename":"开始","actionname":"李辛","comments":""}]
         */

        private String Msg;
        private java.util.List<ListBean> List;

        public String getMsg() {
            return Msg;
        }

        public void setMsg(String Msg) {
            this.Msg = Msg;
        }

        public List<ListBean> getList() {
            return List;
        }

        public void setList(List<ListBean> List) {
            this.List = List;
        }

        public static class ListBean {
            /**
             * time : 2017-12-03 16:54:11
             * nodename : 开始
             * actionname : 李辛
             * comments :
             */

            private String time;
            private String nodename;
            private String actionname;
            private String comments;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getNodename() {
                return nodename;
            }

            public void setNodename(String nodename) {
                this.nodename = nodename;
            }

            public String getActionname() {
                return actionname;
            }

            public void setActionname(String actionname) {
                this.actionname = actionname;
            }

            public String getComments() {
                return comments;
            }

            public void setComments(String comments) {
                this.comments = comments;
            }
        }
    }
}
