package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/6.
 */

public class NoticeResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"PubTime":"2017-12-04 09:03:01","Id":"109","Title":"验车通知","PubDept":"办公室"},{"PubTime":"2017-12-03 09:02:21","Id":"103","Title":"验车通知","PubDept":"办公室"},{"PubTime":"2017-12-02 18:54:16","Id":"102","Title":"销假提醒","PubDept":"办公室"},{"PubTime":"2017-12-02 09:02:16","Id":"101","Title":"验车通知","PubDept":"办公室"},{"PubTime":"2017-12-01 19:45:22","Id":"100","Title":"lixin申请会议","PubDept":"办公室"},{"PubTime":"2017-12-01 18:53:47","Id":"99","Title":"销假提醒","PubDept":"办公室"},{"PubTime":"2017-12-01 18:52:47","Id":"98","Title":"销假提醒","PubDept":"办公室"},{"PubTime":"2017-12-01 18:51:47","Id":"97","Title":"销假提醒","PubDept":"办公室"},{"PubTime":"2017-12-01 18:50:47","Id":"96","Title":"销假提醒","PubDept":"办公室"},{"PubTime":"2017-12-01 18:49:47","Id":"95","Title":"销假提醒","PubDept":"办公室"}]}
     * Search :
     * Page : 1
     * Sid : lixin
     * Stu : 1
     */

    private RstBean Rst;
    private String Search;
    private String Page;
    private String Sid;
    private int Stu;

    public RstBean getRst() {
        return Rst;
    }

    public void setRst(RstBean Rst) {
        this.Rst = Rst;
    }

    public String getSearch() {
        return Search;
    }

    public void setSearch(String Search) {
        this.Search = Search;
    }

    public String getPage() {
        return Page;
    }

    public void setPage(String Page) {
        this.Page = Page;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String Sid) {
        this.Sid = Sid;
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
         * List : [{"PubTime":"2017-12-04 09:03:01","Id":"109","Title":"验车通知","PubDept":"办公室"},{"PubTime":"2017-12-03 09:02:21","Id":"103","Title":"验车通知","PubDept":"办公室"},{"PubTime":"2017-12-02 18:54:16","Id":"102","Title":"销假提醒","PubDept":"办公室"},{"PubTime":"2017-12-02 09:02:16","Id":"101","Title":"验车通知","PubDept":"办公室"},{"PubTime":"2017-12-01 19:45:22","Id":"100","Title":"lixin申请会议","PubDept":"办公室"},{"PubTime":"2017-12-01 18:53:47","Id":"99","Title":"销假提醒","PubDept":"办公室"},{"PubTime":"2017-12-01 18:52:47","Id":"98","Title":"销假提醒","PubDept":"办公室"},{"PubTime":"2017-12-01 18:51:47","Id":"97","Title":"销假提醒","PubDept":"办公室"},{"PubTime":"2017-12-01 18:50:47","Id":"96","Title":"销假提醒","PubDept":"办公室"},{"PubTime":"2017-12-01 18:49:47","Id":"95","Title":"销假提醒","PubDept":"办公室"}]
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
             * PubTime : 2017-12-04 09:03:01
             * Id : 109
             * Title : 验车通知
             * PubDept : 办公室
             */

            private String PubTime;
            private String Id;
            private String Title;
            private String PubDept;

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

            public String getPubDept() {
                return PubDept;
            }

            public void setPubDept(String PubDept) {
                this.PubDept = PubDept;
            }
        }
    }
}
