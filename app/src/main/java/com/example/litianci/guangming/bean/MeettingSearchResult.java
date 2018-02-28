package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/20.
 */

public class MeettingSearchResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"PubTime":"2017-12-12 13:22:44","Id":"110","Title":"lixin申请会议"},{"PubTime":"2017-12-01 17:40:33","Id":"56","Title":"第N+1次测试会议申请何时添加领导日程"}]}
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
         * List : [{"PubTime":"2017-12-12 13:22:44","Id":"110","Title":"lixin申请会议"},{"PubTime":"2017-12-01 17:40:33","Id":"56","Title":"第N+1次测试会议申请何时添加领导日程"}]
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
             * PubTime : 2017-12-12 13:22:44
             * Id : 110
             * Title : lixin申请会议
             */

            private String PubTime;
            private String Id;
            private String Title;

            public String getPubTime() {
                return PubTime;
            }

            public void setPubTime(String PubTime) {
                this.PubTime = PubTime;
            }

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }
        }
    }
}
