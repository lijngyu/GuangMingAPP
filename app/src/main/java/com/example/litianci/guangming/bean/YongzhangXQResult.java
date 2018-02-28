package com.example.litianci.guangming.bean;

/**
 * Created by litianci on 2017/12/21.
 */

public class YongzhangXQResult {

    /**
     * Rst : {"SealName":"dfdff","Dept":"办公室","Type":"0","Djgzk":"djgzkyj","SealType":"0","Time":"2017-11-18","Pointleader":"同意--樊雨松: 2017-11-17 17:16:54。","Msg":"请求成功!","Id":"1","Dyak":"","Bgs":"","Person":"李辛","Director":"","Reason":"dfdf"}
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
         * SealName : dfdff
         * Dept : 办公室
         * Type : 0
         * Djgzk : djgzkyj
         * SealType : 0
         * Time : 2017-11-18
         * Pointleader : 同意--樊雨松: 2017-11-17 17:16:54。
         * Msg : 请求成功!
         * Id : 1
         * Dyak :
         * Bgs :
         * Person : 李辛
         * Director :
         * Reason : dfdf
         */

        private String SealName;
        private String Dept;
        private String Type;
        private String Djgzk;
        private String SealType;
        private String Time;
        private String Pointleader;
        private String Msg;
        private String Id;
        private String Dyak;
        private String Bgs;
        private String Person;
        private String Director;
        private String Reason;

        public String getSealName() {
            return SealName;
        }

        public void setSealName(String SealName) {
            this.SealName = SealName;
        }

        public String getDept() {
            return Dept;
        }

        public void setDept(String Dept) {
            this.Dept = Dept;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getDjgzk() {
            return Djgzk;
        }

        public void setDjgzk(String Djgzk) {
            this.Djgzk = Djgzk;
        }

        public String getSealType() {
            return SealType;
        }

        public void setSealType(String SealType) {
            this.SealType = SealType;
        }

        public String getTime() {
            return Time;
        }

        public void setTime(String Time) {
            this.Time = Time;
        }

        public String getPointleader() {
            return Pointleader;
        }

        public void setPointleader(String Pointleader) {
            this.Pointleader = Pointleader;
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

        public String getDyak() {
            return Dyak;
        }

        public void setDyak(String Dyak) {
            this.Dyak = Dyak;
        }

        public String getBgs() {
            return Bgs;
        }

        public void setBgs(String Bgs) {
            this.Bgs = Bgs;
        }

        public String getPerson() {
            return Person;
        }

        public void setPerson(String Person) {
            this.Person = Person;
        }

        public String getDirector() {
            return Director;
        }

        public void setDirector(String Director) {
            this.Director = Director;
        }

        public String getReason() {
            return Reason;
        }

        public void setReason(String Reason) {
            this.Reason = Reason;
        }
    }
}
