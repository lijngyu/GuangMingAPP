package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/13.
 */

public class DataXQResult {

    /**
     * Rst : {"Name":"李辛;","Body":"测试","Attachment":[{"AttachName":"","AttachUrl":""}],"Time":"2017-12-12 14:23:16","Theme":"测试接口资料传送111","Read":"","Msg":"请求成功!","NoRead":"李辛"}
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
         * Name : 李辛;
         * Body : 测试
         * Attachment : [{"AttachName":"","AttachUrl":""}]
         * Time : 2017-12-12 14:23:16
         * Theme : 测试接口资料传送111
         * Read :
         * Msg : 请求成功!
         * NoRead : 李辛
         */

        private String Name;
        private String Body;
        private String Time;
        private String Theme;
        private String Read;
        private String Msg;
        private String NoRead;
        private String Dept;
        private List<AttachmentBean> Attachment;


        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getBody() {
            return Body;
        }

        public void setBody(String Body) {
            this.Body = Body;
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

        public String getRead() {
            return Read;
        }

        public void setRead(String Read) {
            this.Read = Read;
        }

        public String getMsg() {
            return Msg;
        }

        public void setMsg(String Msg) {
            this.Msg = Msg;
        }

        public String getNoRead() {
            return NoRead;
        }

        public void setNoRead(String NoRead) {
            this.NoRead = NoRead;
        }

        public String getDept() {
            return Dept;
        }

        public void setDept(String dept) {
            Dept = dept;
        }

        public List<AttachmentBean> getAttachment() {
            return Attachment;
        }

        public void setAttachment(List<AttachmentBean> Attachment) {
            this.Attachment = Attachment;
        }

        public static class AttachmentBean {
            /**
             * AttachName :
             * AttachUrl :
             */

            private String AttachName;
            private String AttachUrl;

            public String getAttachName() {
                return AttachName;
            }

            public void setAttachName(String AttachName) {
                this.AttachName = AttachName;
            }

            public String getAttachUrl() {
                return AttachUrl;
            }

            public void setAttachUrl(String AttachUrl) {
                this.AttachUrl = AttachUrl;
            }
        }
    }
}
