package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/19.
 */

public class ReceiveDataXQResult {


    /**
     * Rst : {"Name":"李辛","Body":"测试详情2017.12.19","Attachment":[{"AttachName":"值班表.docx","AttachUrl":"http://192.168.1.110/gmjdbsctest/EmailFujian/201712/20171219193602.docx"},{"AttachName":"值班表.docx","AttachUrl":"http://192.168.1.110/gmjdbsctest/EmailFujian/201712/20171219193602.docx"}],"Time":"2017-12-19 19:34:55","Theme":"测试详情","Dept":"办公室","Msg":"请求成功!"}
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
         * Name : 李辛
         * Body : 测试详情2017.12.19
         * Attachment : [{"AttachName":"值班表.docx","AttachUrl":"http://192.168.1.110/gmjdbsctest/EmailFujian/201712/20171219193602.docx"},{"AttachName":"值班表.docx","AttachUrl":"http://192.168.1.110/gmjdbsctest/EmailFujian/201712/20171219193602.docx"}]
         * Time : 2017-12-19 19:34:55
         * Theme : 测试详情
         * Dept : 办公室
         * Msg : 请求成功!
         */

        private String Name;
        private String Body;
        private String Time;
        private String Theme;
        private String Dept;
        private String Msg;
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

        public String getDept() {
            return Dept;
        }

        public void setDept(String Dept) {
            this.Dept = Dept;
        }

        public String getMsg() {
            return Msg;
        }

        public void setMsg(String Msg) {
            this.Msg = Msg;
        }

        public List<AttachmentBean> getAttachment() {
            return Attachment;
        }

        public void setAttachment(List<AttachmentBean> Attachment) {
            this.Attachment = Attachment;
        }

        public static class AttachmentBean {
            /**
             * AttachName : 值班表.docx
             * AttachUrl : http://192.168.1.110/gmjdbsctest/EmailFujian/201712/20171219193602.docx
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
