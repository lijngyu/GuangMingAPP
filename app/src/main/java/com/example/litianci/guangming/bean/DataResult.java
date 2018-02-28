package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/12.
 */

public class DataResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"Name":"王明宇","Time":"2017-12-12 14:23:21","Theme":"测试接口资料传送111","Dept":"办公室","Id":"8,1","AttachNum":0}]}
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
         * List : [{"Name":"王明宇","Time":"2017-12-12 14:23:21","Theme":"测试接口资料传送111","Dept":"办公室","Id":"8,1","AttachNum":0}]
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
             * Name : 王明宇
             * Time : 2017-12-12 14:23:21
             * Theme : 测试接口资料传送111
             * Dept : 办公室
             * Id : 8,1
             * AttachNum : 0
             */

            private String Name;
            private String Time;
            private String Theme;
            private String Dept;
            private String Id;
            private String Read;
            private String NoRead;
            private int AttachNum;

            public String getRead() {
                return Read;
            }

            public void setRead(String read) {
                Read = read;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getTime() {
                return Time;
            }

            public void setTime(String Time) {
                this.Time = Time;
            }

            public String getTheme() {
                return Theme;
            }

            public void setTheme(String Theme) {
                this.Theme = Theme;
            }

            public String getDept() {
                return Dept;
            }

            public void setDept(String Dept) {
                this.Dept = Dept;
            }

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public int getAttachNum() {
                return AttachNum;
            }

            public void setAttachNum(int AttachNum) {
                this.AttachNum = AttachNum;
            }
        }
    }
}
