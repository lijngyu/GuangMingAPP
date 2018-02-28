package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/20.
 */

public class DaibanResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"Actorname":"姜惠琴","Flowname":"请假申请","Assignername":"陈志勇","Iscollect":"未收藏","Starttime":"2017-11-30 09:40:36","Id":"59030","Instanceid":"1374","Title":"请假申请"},{"Actorname":"陈志勇","Flowname":"请假申请","Assignername":"陈志勇","Iscollect":"未收藏","Starttime":"2017-11-30 09:39:15","Id":"59027","Instanceid":"1373","Title":"请假申请"},{"Actorname":"姜惠琴","Flowname":"用章申请","Assignername":"陈志勇","Iscollect":"未收藏","Starttime":"2017-11-20 17:36:17","Id":"58153","Instanceid":"889","Title":"用章申请"},{"Actorname":"李辛","Flowname":"发文申请","Assignername":"陈志勇","Iscollect":"未收藏","Starttime":"2017-11-17 09:11:18","Id":"58071","Instanceid":"869","Title":"发文测试1"}]}
     * Search : 陈志勇
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
         * List : [{"Actorname":"姜惠琴","Flowname":"请假申请","Assignername":"陈志勇","Iscollect":"未收藏","Starttime":"2017-11-30 09:40:36","Id":"59030","Instanceid":"1374","Title":"请假申请"},{"Actorname":"陈志勇","Flowname":"请假申请","Assignername":"陈志勇","Iscollect":"未收藏","Starttime":"2017-11-30 09:39:15","Id":"59027","Instanceid":"1373","Title":"请假申请"},{"Actorname":"姜惠琴","Flowname":"用章申请","Assignername":"陈志勇","Iscollect":"未收藏","Starttime":"2017-11-20 17:36:17","Id":"58153","Instanceid":"889","Title":"用章申请"},{"Actorname":"李辛","Flowname":"发文申请","Assignername":"陈志勇","Iscollect":"未收藏","Starttime":"2017-11-17 09:11:18","Id":"58071","Instanceid":"869","Title":"发文测试1"}]
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
             * Actorname : 姜惠琴
             * Flowname : 请假申请
             * Assignername : 陈志勇
             * Iscollect : 未收藏
             * Starttime : 2017-11-30 09:40:36
             * Id : 59030
             * Instanceid : 1374
             * Title : 请假申请
             */

            private String Actorname;
            private String Flowname;
            private String Assignername;
            private String Iscollect;
            private String Starttime;
            private String Id;
            private String Wid;
            private String Instanceid;

            public String getWid() {
                return Wid;
            }

            public void setWid(String wid) {
                Wid = wid;
            }

            private String Title;

            public String getActorname() {
                return Actorname;
            }

            public void setActorname(String Actorname) {
                this.Actorname = Actorname;
            }

            public String getFlowname() {
                return Flowname;
            }

            public void setFlowname(String Flowname) {
                this.Flowname = Flowname;
            }

            public String getAssignername() {
                return Assignername;
            }

            public void setAssignername(String Assignername) {
                this.Assignername = Assignername;
            }

            public String getIscollect() {
                return Iscollect;
            }

            public void setIscollect(String Iscollect) {
                this.Iscollect = Iscollect;
            }

            public String getStarttime() {
                return Starttime;
            }

            public void setStarttime(String Starttime) {
                this.Starttime = Starttime;
            }

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getInstanceid() {
                return Instanceid;
            }

            public void setInstanceid(String Instanceid) {
                this.Instanceid = Instanceid;
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
