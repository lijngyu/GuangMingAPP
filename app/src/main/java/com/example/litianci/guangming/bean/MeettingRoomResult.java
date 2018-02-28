package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/20.
 */

public class MeettingRoomResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"Scheduleer":"李辛","State":"5","MeetingRoom":"科研楼302","MeetingName":"李辛测试会议申请通知参会人员功能","Starttime":"2017-12-01 11:00:00","Id":"2","Endtime":"2017-12-01 13:00:00"},{"Scheduleer":"李辛","State":"5","MeetingRoom":"顺义3楼会议室","MeetingName":"关于测试日程会议模块会议","Starttime":"2017-12-01 13:00:00","Id":"1","Endtime":"2017-12-01 14:00:00"},{"Scheduleer":"王明宇","State":"0","MeetingRoom":"顺义3楼会议室","MeetingName":"王明宇测试修改过的会议申请通知功能","Starttime":"2017-12-01 16:00:00","Id":"3","Endtime":"2017-12-01 17:00:00"},{"Scheduleer":"李辛","State":"0","MeetingRoom":"顺义3楼会议室","MeetingName":"确定什么时候添加领导日程会议","Starttime":"2017-12-02 08:00:00","Id":"4","Endtime":"2017-12-02 09:00:00"},{"Scheduleer":"李辛","State":"0","MeetingRoom":"科研楼302","MeetingName":"会议添加领导日程","Starttime":"2017-12-02 09:00:00","Id":"5","Endtime":"2017-12-02 10:00:00"},{"Scheduleer":"王明宇","State":"5","MeetingRoom":"顺义3楼会议室","MeetingName":"第N次测试会议添加领导日程","Starttime":"2017-12-02 10:00:00","Id":"6","Endtime":"2017-12-02 11:00:00"},{"Scheduleer":"李辛","State":"5","MeetingRoom":"科研楼302","MeetingName":"lixin申请会议","Starttime":"2017-12-02 14:00:00","Id":"9","Endtime":"2017-12-02 16:00:00"},{"Scheduleer":"李辛","State":"5","MeetingRoom":"科研楼302","MeetingName":"第N+1次测试会议申请何时添加领导日程","Starttime":"2017-12-03 08:00:00","Id":"7","Endtime":"2017-12-03 09:00:00"}]}
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
         * List : [{"Scheduleer":"李辛","State":"5","MeetingRoom":"科研楼302","MeetingName":"李辛测试会议申请通知参会人员功能","Starttime":"2017-12-01 11:00:00","Id":"2","Endtime":"2017-12-01 13:00:00"},{"Scheduleer":"李辛","State":"5","MeetingRoom":"顺义3楼会议室","MeetingName":"关于测试日程会议模块会议","Starttime":"2017-12-01 13:00:00","Id":"1","Endtime":"2017-12-01 14:00:00"},{"Scheduleer":"王明宇","State":"0","MeetingRoom":"顺义3楼会议室","MeetingName":"王明宇测试修改过的会议申请通知功能","Starttime":"2017-12-01 16:00:00","Id":"3","Endtime":"2017-12-01 17:00:00"},{"Scheduleer":"李辛","State":"0","MeetingRoom":"顺义3楼会议室","MeetingName":"确定什么时候添加领导日程会议","Starttime":"2017-12-02 08:00:00","Id":"4","Endtime":"2017-12-02 09:00:00"},{"Scheduleer":"李辛","State":"0","MeetingRoom":"科研楼302","MeetingName":"会议添加领导日程","Starttime":"2017-12-02 09:00:00","Id":"5","Endtime":"2017-12-02 10:00:00"},{"Scheduleer":"王明宇","State":"5","MeetingRoom":"顺义3楼会议室","MeetingName":"第N次测试会议添加领导日程","Starttime":"2017-12-02 10:00:00","Id":"6","Endtime":"2017-12-02 11:00:00"},{"Scheduleer":"李辛","State":"5","MeetingRoom":"科研楼302","MeetingName":"lixin申请会议","Starttime":"2017-12-02 14:00:00","Id":"9","Endtime":"2017-12-02 16:00:00"},{"Scheduleer":"李辛","State":"5","MeetingRoom":"科研楼302","MeetingName":"第N+1次测试会议申请何时添加领导日程","Starttime":"2017-12-03 08:00:00","Id":"7","Endtime":"2017-12-03 09:00:00"}]
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
             * Scheduleer : 李辛
             * State : 5
             * MeetingRoom : 科研楼302
             * MeetingName : 李辛测试会议申请通知参会人员功能
             * Starttime : 2017-12-01 11:00:00
             * Id : 2
             * Endtime : 2017-12-01 13:00:00
             */

            private String Scheduleer;
            private String State;
            private String MeetingRoom;
            private String MeetingName;
            private String Starttime;
            private String Id;
            private String Endtime;

            public String getScheduleer() {
                return Scheduleer;
            }

            public void setScheduleer(String Scheduleer) {
                this.Scheduleer = Scheduleer;
            }

            public String getState() {
                return State;
            }

            public void setState(String State) {
                this.State = State;
            }

            public String getMeetingRoom() {
                return MeetingRoom;
            }

            public void setMeetingRoom(String MeetingRoom) {
                this.MeetingRoom = MeetingRoom;
            }

            public String getMeetingName() {
                return MeetingName;
            }

            public void setMeetingName(String MeetingName) {
                this.MeetingName = MeetingName;
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

            public String getEndtime() {
                return Endtime;
            }

            public void setEndtime(String Endtime) {
                this.Endtime = Endtime;
            }
        }
    }
}
