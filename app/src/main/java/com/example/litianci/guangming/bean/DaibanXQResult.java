package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/22.
 */

public class DaibanXQResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"Spna":"李辛","Dn":"车辆使用申请","H5Url":"http://218.246.86.253/gmjdbsctest//WorkflowAction.cmd?$WID=58426","Ds":"","Asna":"王明宇","Fn":"车辆使用申请","Role":"null{ROLECODE=c24},{ROLECODE=bangongsi},{ROLECODE=fzdckkz},{ROLECODE=b41},{ROLECODE=c14},{ROLECODE=c09},{ROLECODE=c01},{ROLECODE=b01},{ROLECODE=c03},{ROLECODE=c21},{ROLECODE=c25},","Dt":"2017-11-21","Is":"0"}]}
     * Sid : lixin
     * Inid : 993
     * Wid : 58426
     * Stu : 1
     */

    private RstBean Rst;
    private String Sid;
    private String Inid;
    private String Wid;
    private int Stu;

    public RstBean getRst() {
        return Rst;
    }

    public void setRst(RstBean Rst) {
        this.Rst = Rst;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String Sid) {
        this.Sid = Sid;
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

    public int getStu() {
        return Stu;
    }

    public void setStu(int Stu) {
        this.Stu = Stu;
    }

    public static class RstBean {
        /**
         * Msg : 请求成功！
         * List : [{"Spna":"李辛","Dn":"车辆使用申请","H5Url":"http://218.246.86.253/gmjdbsctest//WorkflowAction.cmd?$WID=58426","Ds":"","Asna":"王明宇","Fn":"车辆使用申请","Role":"null{ROLECODE=c24},{ROLECODE=bangongsi},{ROLECODE=fzdckkz},{ROLECODE=b41},{ROLECODE=c14},{ROLECODE=c09},{ROLECODE=c01},{ROLECODE=b01},{ROLECODE=c03},{ROLECODE=c21},{ROLECODE=c25},","Dt":"2017-11-21","Is":"0"}]
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
             * Spna : 李辛
             * Dn : 车辆使用申请
             * H5Url : http://218.246.86.253/gmjdbsctest//WorkflowAction.cmd?$WID=58426
             * Ds :
             * Asna : 王明宇
             * Fn : 车辆使用申请
             * Role : null{ROLECODE=c24},{ROLECODE=bangongsi},{ROLECODE=fzdckkz},{ROLECODE=b41},{ROLECODE=c14},{ROLECODE=c09},{ROLECODE=c01},{ROLECODE=b01},{ROLECODE=c03},{ROLECODE=c21},{ROLECODE=c25},
             * Dt : 2017-11-21
             * Is : 0
             */

            private String Spna;
            private String Dn;
            private String H5Url;
            private String Ds;
            private String Asna;
            private String Fn;
            private String Role;
            private String Dt;
            private String Is;

            public String getSpna() {
                return Spna;
            }

            public void setSpna(String Spna) {
                this.Spna = Spna;
            }

            public String getDn() {
                return Dn;
            }

            public void setDn(String Dn) {
                this.Dn = Dn;
            }

            public String getH5Url() {
                return H5Url;
            }

            public void setH5Url(String H5Url) {
                this.H5Url = H5Url;
            }

            public String getDs() {
                return Ds;
            }

            public void setDs(String Ds) {
                this.Ds = Ds;
            }

            public String getAsna() {
                return Asna;
            }

            public void setAsna(String Asna) {
                this.Asna = Asna;
            }

            public String getFn() {
                return Fn;
            }

            public void setFn(String Fn) {
                this.Fn = Fn;
            }

            public String getRole() {
                return Role;
            }

            public void setRole(String Role) {
                this.Role = Role;
            }

            public String getDt() {
                return Dt;
            }

            public void setDt(String Dt) {
                this.Dt = Dt;
            }

            public String getIs() {
                return Is;
            }

            public void setIs(String Is) {
                this.Is = Is;
            }
        }
    }
}
