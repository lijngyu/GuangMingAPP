package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/11/30.
 */

public class FileCirculationResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"Time":"2017-10-25 00:00:00","State":"1","FasongTime":"2017-10-30 16:46:44","Days":"","Request":"2017-11-02","Id":"14","Unit":"顺义天竺办公室","Title":"李辛文件传阅test1"},{"Time":"2017-10-23 00:00:00","State":"1","FasongTime":"2017-10-25 09:59:15","Days":"","Request":"2017-11-08","Id":"12","Unit":"11111","Title":"111111111"}]}
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
         * List : [{"Time":"2017-10-25 00:00:00","State":"1","FasongTime":"2017-10-30 16:46:44","Days":"","Request":"2017-11-02","Id":"14","Unit":"顺义天竺办公室","Title":"李辛文件传阅test1"},{"Time":"2017-10-23 00:00:00","State":"1","FasongTime":"2017-10-25 09:59:15","Days":"","Request":"2017-11-08","Id":"12","Unit":"11111","Title":"111111111"}]
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
             * Time : 2017-10-25 00:00:00
             * State : 1
             * FasongTime : 2017-10-30 16:46:44
             * Days :
             * Request : 2017-11-02
             * Id : 14
             * Unit : 顺义天竺办公室
             * Title : 李辛文件传阅test1
             */

            private String Time;
            private String State;
            private String FasongTime;
            private String Days;
            private String Request;
            private String Id;
            private String Unit;
            private String Title;

            public String getTime() {
                return Time;
            }

            public void setTime(String Time) {
                this.Time = Time;
            }

            public String getState() {
                return State;
            }

            public void setState(String State) {
                this.State = State;
            }

            public String getFasongTime() {
                return FasongTime;
            }

            public void setFasongTime(String FasongTime) {
                this.FasongTime = FasongTime;
            }

            public String getDays() {
                return Days;
            }

            public void setDays(String Days) {
                this.Days = Days;
            }

            public String getRequest() {
                return Request;
            }

            public void setRequest(String Request) {
                this.Request = Request;
            }

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getUnit() {
                return Unit;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
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
