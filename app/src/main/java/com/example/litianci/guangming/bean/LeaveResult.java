package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/11/30.
 */

public class LeaveResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"Njdays":"4","Type":"0","Username":"李辛","Id":"26","Applyday":"2017-12-03","Deptname":"办公室"},{"Njdays":"2","Type":"2","Username":"陈志勇","Id":"21","Applyday":"2017-12-01","Deptname":"街道领导"},{"Njdays":"14","Type":"1","Username":"樊雨松","Id":"16","Applyday":"2017-12-01","Deptname":"街道领导"},{"Njdays":"11","Type":"1","Username":"王明宇","Id":"9","Applyday":"2017-11-30","Deptname":"办公室"},{"Njdays":"1","Type":"1","Username":"黄大山","Id":"11","Applyday":"2017-11-30","Deptname":"街道领导"},{"Njdays":"2","Type":"0","Username":"张文武","Id":"15","Applyday":"2017-11-30","Deptname":"食堂"},{"Njdays":"1","Type":"1","Username":"王明宇","Id":"8","Applyday":"2017-11-30","Deptname":"办公室"},{"Njdays":"2","Type":"1","Username":"王明宇","Id":"6","Applyday":"2017-11-22","Deptname":"办公室"},{"Njdays":"3","Type":"0","Username":"李辛","Id":"1","Applyday":"2017-11-17","Deptname":"办公室"}]}
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
         * List : [{"Njdays":"4","Type":"0","Username":"李辛","Id":"26","Applyday":"2017-12-03","Deptname":"办公室"},{"Njdays":"2","Type":"2","Username":"陈志勇","Id":"21","Applyday":"2017-12-01","Deptname":"街道领导"},{"Njdays":"14","Type":"1","Username":"樊雨松","Id":"16","Applyday":"2017-12-01","Deptname":"街道领导"},{"Njdays":"11","Type":"1","Username":"王明宇","Id":"9","Applyday":"2017-11-30","Deptname":"办公室"},{"Njdays":"1","Type":"1","Username":"黄大山","Id":"11","Applyday":"2017-11-30","Deptname":"街道领导"},{"Njdays":"2","Type":"0","Username":"张文武","Id":"15","Applyday":"2017-11-30","Deptname":"食堂"},{"Njdays":"1","Type":"1","Username":"王明宇","Id":"8","Applyday":"2017-11-30","Deptname":"办公室"},{"Njdays":"2","Type":"1","Username":"王明宇","Id":"6","Applyday":"2017-11-22","Deptname":"办公室"},{"Njdays":"3","Type":"0","Username":"李辛","Id":"1","Applyday":"2017-11-17","Deptname":"办公室"}]
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
             * Njdays : 4
             * Type : 0
             * Username : 李辛
             * Id : 26
             * Applyday : 2017-12-03
             * Deptname : 办公室
             */

            private String Njdays;
            private String Type;
            private String Username;
            private String Id;
            private String Applyday;
            private String Deptname;

            public String getNjdays() {
                return Njdays;
            }

            public void setNjdays(String Njdays) {
                this.Njdays = Njdays;
            }

            public String getType() {
                return Type;
            }

            public void setType(String Type) {
                this.Type = Type;
            }

            public String getUsername() {
                return Username;
            }

            public void setUsername(String Username) {
                this.Username = Username;
            }

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getApplyday() {
                return Applyday;
            }

            public void setApplyday(String Applyday) {
                this.Applyday = Applyday;
            }

            public String getDeptname() {
                return Deptname;
            }

            public void setDeptname(String Deptname) {
                this.Deptname = Deptname;
            }
        }
    }
}
