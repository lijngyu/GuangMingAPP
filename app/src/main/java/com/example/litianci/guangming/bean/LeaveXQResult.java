package com.example.litianci.guangming.bean;

/**
 * Created by litianci on 2017/12/21.
 */

public class LeaveXQResult {

    /**
     * Rst : {"DirectorIdea":"","Count":"2017-11-30","OfficeIdea":"","Type":"1","DyakIdea":"","Applyday":"2017-11-30","Njdays":"1","Username":"王明宇","Msg":"请求成功!","Id":"8","LeaderIdea":"樊雨松：已阅。2017-11-30 09:55:41。","Cause":"ddfdfd","Deptname":"办公室"}
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
         * DirectorIdea :
         * Count : 2017-11-30
         * OfficeIdea :
         * Type : 1
         * DyakIdea :
         * Applyday : 2017-11-30
         * Njdays : 1
         * Username : 王明宇
         * Msg : 请求成功!
         * Id : 8
         * LeaderIdea : 樊雨松：已阅。2017-11-30 09:55:41。
         * Cause : ddfdfd
         * Deptname : 办公室
         */

        private String DirectorIdea;
        private String Count;
        private String OfficeIdea;
        private String Type;
        private String DyakIdea;
        private String Applyday;
        private String Njdays;
        private String Username;
        private String Msg;
        private String Id;
        private String LeaderIdea;
        private String Cause;
        private String Deptname;

        public String getDirectorIdea() {
            return DirectorIdea;
        }

        public void setDirectorIdea(String DirectorIdea) {
            this.DirectorIdea = DirectorIdea;
        }

        public String getCount() {
            return Count;
        }

        public void setCount(String Count) {
            this.Count = Count;
        }

        public String getOfficeIdea() {
            return OfficeIdea;
        }

        public void setOfficeIdea(String OfficeIdea) {
            this.OfficeIdea = OfficeIdea;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getDyakIdea() {
            return DyakIdea;
        }

        public void setDyakIdea(String DyakIdea) {
            this.DyakIdea = DyakIdea;
        }

        public String getApplyday() {
            return Applyday;
        }

        public void setApplyday(String Applyday) {
            this.Applyday = Applyday;
        }

        public String getNjdays() {
            return Njdays;
        }

        public void setNjdays(String Njdays) {
            this.Njdays = Njdays;
        }

        public String getUsername() {
            return Username;
        }

        public void setUsername(String Username) {
            this.Username = Username;
        }

        public String getMsg() {
            return Msg;
        }

        public void setMsg(String Msg) {
            this.Msg = Msg;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getLeaderIdea() {
            return LeaderIdea;
        }

        public void setLeaderIdea(String LeaderIdea) {
            this.LeaderIdea = LeaderIdea;
        }

        public String getCause() {
            return Cause;
        }

        public void setCause(String Cause) {
            this.Cause = Cause;
        }

        public String getDeptname() {
            return Deptname;
        }

        public void setDeptname(String Deptname) {
            this.Deptname = Deptname;
        }
    }
}
