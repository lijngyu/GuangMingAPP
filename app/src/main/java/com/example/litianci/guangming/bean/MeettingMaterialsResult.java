package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/20.
 */

public class MeettingMaterialsResult {

    /**
     * Rst : {"Msg":"请求成功","List":[{"id":"11","md":"第N+1次测试会议申请何时添加领导日程","state":"1","mrn":"科研楼302","mid":"7","st":"2017-12-03 08:00:00","type":""},{"id":"8","md":"第N+1次测试会议申请何时添加领导日程","state":"1","mrn":"科研楼302","mid":"7","st":"2017-12-03 08:00:00","type":"1"},{"id":"7","md":"第N次测试会议添加领导日程","state":"1","mrn":"顺义3楼会议室","mid":"6","st":"2017-12-02 10:00:00","type":"2"},{"id":"6","md":"第N次测试会议添加领导日程","state":"1","mrn":"顺义3楼会议室","mid":"6","st":"2017-12-02 10:00:00","type":"1"},{"id":"2","md":"关于测试日程会议模块会议","state":"1","mrn":"顺义3楼会议室","mid":"1","st":"2017-12-01 13:00:00","type":"2"},{"id":"1","md":"关于测试日程会议模块会议","state":"3","mrn":"顺义3楼会议室","mid":"1","st":"2017-12-01 13:00:00","type":"1"},{"id":"5","md":"关于测试日程会议模块会议","state":"1","mrn":"顺义3楼会议室","mid":"1","st":"2017-12-01 13:00:00","type":""},{"id":"4","md":"李辛测试会议申请通知参会人员功能","state":"1","mrn":"科研楼302","mid":"2","st":"2017-12-01 11:00:00","type":"2"},{"id":"3","md":"李辛测试会议申请通知参会人员功能","state":"1","mrn":"科研楼302","mid":"2","st":"2017-12-01 11:00:00","type":"1"}]}
     * Stu : 1
     */

    private RstBean Rst;
    private String Stu;

    public RstBean getRst() {
        return Rst;
    }

    public void setRst(RstBean Rst) {
        this.Rst = Rst;
    }

    public String getStu() {
        return Stu;
    }

    public void setStu(String Stu) {
        this.Stu = Stu;
    }

    public static class RstBean {
        /**
         * Msg : 请求成功
         * List : [{"id":"11","md":"第N+1次测试会议申请何时添加领导日程","state":"1","mrn":"科研楼302","mid":"7","st":"2017-12-03 08:00:00","type":""},{"id":"8","md":"第N+1次测试会议申请何时添加领导日程","state":"1","mrn":"科研楼302","mid":"7","st":"2017-12-03 08:00:00","type":"1"},{"id":"7","md":"第N次测试会议添加领导日程","state":"1","mrn":"顺义3楼会议室","mid":"6","st":"2017-12-02 10:00:00","type":"2"},{"id":"6","md":"第N次测试会议添加领导日程","state":"1","mrn":"顺义3楼会议室","mid":"6","st":"2017-12-02 10:00:00","type":"1"},{"id":"2","md":"关于测试日程会议模块会议","state":"1","mrn":"顺义3楼会议室","mid":"1","st":"2017-12-01 13:00:00","type":"2"},{"id":"1","md":"关于测试日程会议模块会议","state":"3","mrn":"顺义3楼会议室","mid":"1","st":"2017-12-01 13:00:00","type":"1"},{"id":"5","md":"关于测试日程会议模块会议","state":"1","mrn":"顺义3楼会议室","mid":"1","st":"2017-12-01 13:00:00","type":""},{"id":"4","md":"李辛测试会议申请通知参会人员功能","state":"1","mrn":"科研楼302","mid":"2","st":"2017-12-01 11:00:00","type":"2"},{"id":"3","md":"李辛测试会议申请通知参会人员功能","state":"1","mrn":"科研楼302","mid":"2","st":"2017-12-01 11:00:00","type":"1"}]
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
             * id : 11
             * md : 第N+1次测试会议申请何时添加领导日程
             * state : 1
             * mrn : 科研楼302
             * mid : 7
             * st : 2017-12-03 08:00:00
             * type :
             */

            private String id;
            private String md;
            private String state;
            private String mrn;
            private String mid;
            private String st;
            private String type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMd() {
                return md;
            }

            public void setMd(String md) {
                this.md = md;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getMrn() {
                return mrn;
            }

            public void setMrn(String mrn) {
                this.mrn = mrn;
            }

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public String getSt() {
                return st;
            }

            public void setSt(String st) {
                this.st = st;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
