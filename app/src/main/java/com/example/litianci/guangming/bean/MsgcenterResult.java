package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/15.
 */

public class MsgcenterResult {


    /**
     * Rst : {"Msg":"请求成功！","List":[{"Sendcode":"fanyusong","Typename":"待办工作","Time":"15:12:38","Isread":"已读","Date":"2017-12-27","Rid":"","Inid":"1677","Wid":"59581","Messagetype":"4","Title":"测试流程监控"},{"Sendcode":"lixin","Typename":"资料传送","Time":"14:23:31","Isread":"已读","Date":"2017-12-26","Rid":"7","Inid":"","Wid":"","Messagetype":"1","Title":"测试未读状态"},{"Sendcode":"lixin","Typename":"资料传送","Time":"14:19:20","Isread":"已读","Date":"2017-12-26","Rid":"6","Inid":"","Wid":"","Messagetype":"1","Title":"ceshi未读状态"},{"Sendcode":"lixin","Typename":"资料传送","Time":"19:36:12","Isread":"已读","Date":"2017-12-19","Rid":"5","Inid":"","Wid":"","Messagetype":"1","Title":"测试详情"},{"Sendcode":"wangmingyu","Typename":"待办工作","Time":"10:53:16","Isread":"已读","Date":"2017-12-14","Rid":"","Inid":"1502","Wid":"59408","Messagetype":"4","Title":"用章申请"},{"Sendcode":"jianghuiqin","Typename":"待办工作","Time":"10:52:51","Isread":"已读","Date":"2017-12-14","Rid":"","Inid":"1502","Wid":"59406","Messagetype":"4","Title":"用章申请"},{"Sendcode":"wangmingyu","Typename":"资料传送","Time":"14:23:37","Isread":"已读","Date":"2017-12-12","Rid":"1","Inid":"","Wid":"","Messagetype":"1","Title":"测试接口资料传送111"},{"Sendcode":"lixin","Typename":"待办工作","Time":"16:54:25","Isread":"已读","Date":"2017-12-03","Rid":"","Inid":"1497","Wid":"59375","Messagetype":"4","Title":"工作通知"},{"Sendcode":"lixin","Typename":"待办工作","Time":"16:54:05","Isread":"已读","Date":"2017-12-03","Rid":"","Inid":"1496","Wid":"59370","Messagetype":"4","Title":"工作通知"},{"Sendcode":"lixin","Typename":"待办工作","Time":"16:51:51","Isread":"已读","Date":"2017-12-03","Rid":"","Inid":"1495","Wid":"59362","Messagetype":"4","Title":"工作通知"}]}
     * Page : 1
     * Sid : lixin
     * Stu : 1
     */

    private RstBean Rst;
    private String Page;
    private String Sid;
    private int Stu;

    public RstBean getRst() {
        return Rst;
    }

    public void setRst(RstBean Rst) {
        this.Rst = Rst;
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
         * List : [{"Sendcode":"fanyusong","Typename":"待办工作","Time":"15:12:38","Isread":"已读","Date":"2017-12-27","Rid":"","Inid":"1677","Wid":"59581","Messagetype":"4","Title":"测试流程监控"},{"Sendcode":"lixin","Typename":"资料传送","Time":"14:23:31","Isread":"已读","Date":"2017-12-26","Rid":"7","Inid":"","Wid":"","Messagetype":"1","Title":"测试未读状态"},{"Sendcode":"lixin","Typename":"资料传送","Time":"14:19:20","Isread":"已读","Date":"2017-12-26","Rid":"6","Inid":"","Wid":"","Messagetype":"1","Title":"ceshi未读状态"},{"Sendcode":"lixin","Typename":"资料传送","Time":"19:36:12","Isread":"已读","Date":"2017-12-19","Rid":"5","Inid":"","Wid":"","Messagetype":"1","Title":"测试详情"},{"Sendcode":"wangmingyu","Typename":"待办工作","Time":"10:53:16","Isread":"已读","Date":"2017-12-14","Rid":"","Inid":"1502","Wid":"59408","Messagetype":"4","Title":"用章申请"},{"Sendcode":"jianghuiqin","Typename":"待办工作","Time":"10:52:51","Isread":"已读","Date":"2017-12-14","Rid":"","Inid":"1502","Wid":"59406","Messagetype":"4","Title":"用章申请"},{"Sendcode":"wangmingyu","Typename":"资料传送","Time":"14:23:37","Isread":"已读","Date":"2017-12-12","Rid":"1","Inid":"","Wid":"","Messagetype":"1","Title":"测试接口资料传送111"},{"Sendcode":"lixin","Typename":"待办工作","Time":"16:54:25","Isread":"已读","Date":"2017-12-03","Rid":"","Inid":"1497","Wid":"59375","Messagetype":"4","Title":"工作通知"},{"Sendcode":"lixin","Typename":"待办工作","Time":"16:54:05","Isread":"已读","Date":"2017-12-03","Rid":"","Inid":"1496","Wid":"59370","Messagetype":"4","Title":"工作通知"},{"Sendcode":"lixin","Typename":"待办工作","Time":"16:51:51","Isread":"已读","Date":"2017-12-03","Rid":"","Inid":"1495","Wid":"59362","Messagetype":"4","Title":"工作通知"}]
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
             * Sendcode : fanyusong
             * Typename : 待办工作
             * Time : 15:12:38
             * Isread : 已读
             * Date : 2017-12-27
             * Rid :
             * Inid : 1677
             * Wid : 59581
             * Messagetype : 4
             * Title : 测试流程监控
             */

            private String Sendcode;
            private String Typename;
            private String Time;
            private String Isread;
            private String Date;
            private String Rid;
            private String Inid;
            private String Wid;
            private String Messagetype;
            private String Title;

            public String getSendcode() {
                return Sendcode;
            }

            public void setSendcode(String Sendcode) {
                this.Sendcode = Sendcode;
            }

            public String getTypename() {
                return Typename;
            }

            public void setTypename(String Typename) {
                this.Typename = Typename;
            }

            public String getTime() {
                return Time;
            }

            public void setTime(String Time) {
                this.Time = Time;
            }

            public String getIsread() {
                return Isread;
            }

            public void setIsread(String Isread) {
                this.Isread = Isread;
            }

            public String getDate() {
                return Date;
            }

            public void setDate(String Date) {
                this.Date = Date;
            }

            public String getRid() {
                return Rid;
            }

            public void setRid(String Rid) {
                this.Rid = Rid;
            }

            public String getInid() {
                return Inid;
            }

            public void setInid(String Inid) {
                this.Inid = Inid;
            }

            public String getWid() {
                return Wid;
            }

            public void setWid(String Wid) {
                this.Wid = Wid;
            }

            public String getMessagetype() {
                return Messagetype;
            }

            public void setMessagetype(String Messagetype) {
                this.Messagetype = Messagetype;
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
