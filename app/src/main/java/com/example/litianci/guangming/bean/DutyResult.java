package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/18.
 */

public class DutyResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"Status":"","Member":"许晓倩,武晓彤","Week":"星期六","Time":"2017-12-18白班","Kz":"郑亚男","Bbpeople":"","Leader":"李辛"},{"Status":"","Member":"张文武","Week":"星期六","Time":"2017-12-18夜班","Kz":"刘彬","Bbpeople":"","Leader":"周春燕"},{"Status":"","Member":"杨琳,春雨","Week":"星期日","Time":"2017-12-19白班","Kz":"杨迎宇","Bbpeople":"","Leader":"张雷"},{"Status":"","Member":"马丰亮","Week":"星期日","Time":"2017-12-19夜班","Kz":"许艳庆","Bbpeople":"","Leader":"曾福文"},{"Status":"","Member":"申希龙","Week":"星期一","Time":"2017-12-20","Kz":"赵洪雨","Bbpeople":"","Leader":"湛秀忠"},{"Status":"","Member":"董建文","Week":"星期二","Time":"2017-12-21","Kz":"李向利","Bbpeople":"春雨","Leader":"桓秋利"},{"Status":"","Member":"李昂","Week":"星期三","Time":"2017-12-22","Kz":"史文浩","Bbpeople":"王明宇","Leader":"于洪义"},{"Status":"","Member":"李春光,陈建明","Week":"星期四","Time":"2017-12-23","Kz":"樊雨松","Bbpeople":"郭琦","Leader":"姜惠琴"},{"Status":"","Member":"彭立平","Week":"星期五","Time":"2017-12-24","Kz":"李冠群","Bbpeople":"","Leader":"陈志勇"}]}
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
         * List : [{"Status":"","Member":"许晓倩,武晓彤","Week":"星期六","Time":"2017-12-18白班","Kz":"郑亚男","Bbpeople":"","Leader":"李辛"},{"Status":"","Member":"张文武","Week":"星期六","Time":"2017-12-18夜班","Kz":"刘彬","Bbpeople":"","Leader":"周春燕"},{"Status":"","Member":"杨琳,春雨","Week":"星期日","Time":"2017-12-19白班","Kz":"杨迎宇","Bbpeople":"","Leader":"张雷"},{"Status":"","Member":"马丰亮","Week":"星期日","Time":"2017-12-19夜班","Kz":"许艳庆","Bbpeople":"","Leader":"曾福文"},{"Status":"","Member":"申希龙","Week":"星期一","Time":"2017-12-20","Kz":"赵洪雨","Bbpeople":"","Leader":"湛秀忠"},{"Status":"","Member":"董建文","Week":"星期二","Time":"2017-12-21","Kz":"李向利","Bbpeople":"春雨","Leader":"桓秋利"},{"Status":"","Member":"李昂","Week":"星期三","Time":"2017-12-22","Kz":"史文浩","Bbpeople":"王明宇","Leader":"于洪义"},{"Status":"","Member":"李春光,陈建明","Week":"星期四","Time":"2017-12-23","Kz":"樊雨松","Bbpeople":"郭琦","Leader":"姜惠琴"},{"Status":"","Member":"彭立平","Week":"星期五","Time":"2017-12-24","Kz":"李冠群","Bbpeople":"","Leader":"陈志勇"}]
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
             * Status :
             * Member : 许晓倩,武晓彤
             * Week : 星期六
             * Time : 2017-12-18白班
             * Kz : 郑亚男
             * Bbpeople :
             * Leader : 李辛
             */

            private String Status;
            private String Member;
            private String Week;
            private String Time;
            private String Kz;
            private String Bbpeople;
            private String shiftleadertel;

            public String getShiftleadertel() {
                return shiftleadertel;
            }

            public void setShiftleadertel(String shiftleadertel) {
                this.shiftleadertel = shiftleadertel;
            }

            private String Leader;

            public String getStatus() {
                return Status;
            }

            public void setStatus(String Status) {
                this.Status = Status;
            }

            public String getMember() {
                return Member;
            }

            public void setMember(String Member) {
                this.Member = Member;
            }

            public String getWeek() {
                return Week;
            }

            public void setWeek(String Week) {
                this.Week = Week;
            }

            public String getTime() {
                return Time;
            }

            public void setTime(String Time) {
                this.Time = Time;
            }

            public String getKz() {
                return Kz;
            }

            public void setKz(String Kz) {
                this.Kz = Kz;
            }

            public String getBbpeople() {
                return Bbpeople;
            }

            public void setBbpeople(String Bbpeople) {
                this.Bbpeople = Bbpeople;
            }

            public String getLeader() {
                return Leader;
            }

            public void setLeader(String Leader) {
                this.Leader = Leader;
            }
        }
    }
}
