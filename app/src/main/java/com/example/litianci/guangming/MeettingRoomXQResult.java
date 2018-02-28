package com.example.litianci.guangming;

/**
 * Created by litianci on 2017/12/25.
 */

public class MeettingRoomXQResult {

    /**
     * Rst : {"Scheduleer":"李辛","MeetingRoom":"科研楼302","MeetingName":"李辛测试会议申请通知参会人员功能","Sqdeptname":"办公室","Starttime":"2017-12-01 11:00:00","Msg":"请求成功!","Ksfzryj":"","JoinLeader":"姜惠琴,陈志勇","Endtime":"2017-12-01 13:00:00","OutsidePeople":"","MeetingPeople":"李辛,王明宇,李向利,董建文,陈建明,彭立平,李冠群"}
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
         * Scheduleer : 李辛
         * MeetingRoom : 科研楼302
         * MeetingName : 李辛测试会议申请通知参会人员功能
         * Sqdeptname : 办公室
         * Starttime : 2017-12-01 11:00:00
         * Msg : 请求成功!
         * Ksfzryj :
         * JoinLeader : 姜惠琴,陈志勇
         * Endtime : 2017-12-01 13:00:00
         * OutsidePeople :
         * MeetingPeople : 李辛,王明宇,李向利,董建文,陈建明,彭立平,李冠群
         */

        private String Scheduleer;
        private String MeetingRoom;
        private String MeetingName;
        private String Sqdeptname;
        private String Starttime;
        private String Msg;
        private String Ksfzryj;
        private String JoinLeader;
        private String Endtime;
        private String OutsidePeople;
        private String MeetingPeople;

        public String getScheduleer() {
            return Scheduleer;
        }

        public void setScheduleer(String Scheduleer) {
            this.Scheduleer = Scheduleer;
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

        public String getSqdeptname() {
            return Sqdeptname;
        }

        public void setSqdeptname(String Sqdeptname) {
            this.Sqdeptname = Sqdeptname;
        }

        public String getStarttime() {
            return Starttime;
        }

        public void setStarttime(String Starttime) {
            this.Starttime = Starttime;
        }

        public String getMsg() {
            return Msg;
        }

        public void setMsg(String Msg) {
            this.Msg = Msg;
        }

        public String getKsfzryj() {
            return Ksfzryj;
        }

        public void setKsfzryj(String Ksfzryj) {
            this.Ksfzryj = Ksfzryj;
        }

        public String getJoinLeader() {
            return JoinLeader;
        }

        public void setJoinLeader(String JoinLeader) {
            this.JoinLeader = JoinLeader;
        }

        public String getEndtime() {
            return Endtime;
        }

        public void setEndtime(String Endtime) {
            this.Endtime = Endtime;
        }

        public String getOutsidePeople() {
            return OutsidePeople;
        }

        public void setOutsidePeople(String OutsidePeople) {
            this.OutsidePeople = OutsidePeople;
        }

        public String getMeetingPeople() {
            return MeetingPeople;
        }

        public void setMeetingPeople(String MeetingPeople) {
            this.MeetingPeople = MeetingPeople;
        }
    }
}
