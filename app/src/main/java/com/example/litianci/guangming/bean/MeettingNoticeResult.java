package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/14.
 */

public class MeettingNoticeResult {

    /**
     * Rst : {"Msg":"请求成功","List":[{"starttime":"2017-12-03 08:00:00","iid":"7","name":"第N+1次测试会议申请何时添加领导日程","state":"1","mid":"7","mroom":""},{"starttime":"2017-12-02 14:00:00","iid":"8","name":"lixin申请会议","state":"1","mid":"9","mroom":""},{"starttime":"2017-12-02 10:00:00","iid":"6","name":"第N次测试会议添加领导日程","state":"0","mid":"6","mroom":""},{"starttime":"2017-12-02 09:00:00","iid":"5","name":"会议添加领导日程","state":"5","mid":"5","mroom":""},{"starttime":"2017-12-02 08:00:00","iid":"4","name":"确定什么时候添加领导日程会议","state":"5","mid":"4","mroom":""},{"starttime":"2017-12-01 16:00:00","iid":"3","name":"王明宇测试修改过的会议申请通知功能","state":"5","mid":"3","mroom":""},{"starttime":"2017-12-01 13:00:00","iid":"1","name":"关于测试日程会议模块会议","state":"3","mid":"1","mroom":""},{"starttime":"2017-12-01 11:00:00","iid":"2","name":"李辛测试会议申请通知参会人员功能","state":"0","mid":"2","mroom":""}]}
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
         * List : [{"starttime":"2017-12-03 08:00:00","iid":"7","name":"第N+1次测试会议申请何时添加领导日程","state":"1","mid":"7","mroom":""},{"starttime":"2017-12-02 14:00:00","iid":"8","name":"lixin申请会议","state":"1","mid":"9","mroom":""},{"starttime":"2017-12-02 10:00:00","iid":"6","name":"第N次测试会议添加领导日程","state":"0","mid":"6","mroom":""},{"starttime":"2017-12-02 09:00:00","iid":"5","name":"会议添加领导日程","state":"5","mid":"5","mroom":""},{"starttime":"2017-12-02 08:00:00","iid":"4","name":"确定什么时候添加领导日程会议","state":"5","mid":"4","mroom":""},{"starttime":"2017-12-01 16:00:00","iid":"3","name":"王明宇测试修改过的会议申请通知功能","state":"5","mid":"3","mroom":""},{"starttime":"2017-12-01 13:00:00","iid":"1","name":"关于测试日程会议模块会议","state":"3","mid":"1","mroom":""},{"starttime":"2017-12-01 11:00:00","iid":"2","name":"李辛测试会议申请通知参会人员功能","state":"0","mid":"2","mroom":""}]
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
             * starttime : 2017-12-03 08:00:00
             * iid : 7
             * name : 第N+1次测试会议申请何时添加领导日程
             * state : 1
             * mid : 7
             * mroom :
             */

            private String starttime;
            private String iid;
            private String name;
            private String state;
            private String mid;
            private String mroom;

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getIid() {
                return iid;
            }

            public void setIid(String iid) {
                this.iid = iid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public String getMroom() {
                return mroom;
            }

            public void setMroom(String mroom) {
                this.mroom = mroom;
            }
        }
    }
}
