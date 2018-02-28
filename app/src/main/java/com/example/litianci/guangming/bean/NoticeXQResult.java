package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/6.
 */

public class NoticeXQResult {

    /**
     * Rst : {"AttList":[{"Url":"http://218.246.86.253/gmjdbsc/FileFujian/201711/20171130133937.docx","FileName":"请假需知.docx"},{"Url":"http://218.246.86.253/gmjdbsc/EmailFujian/201711/20171122151659.docx","FileName":"请假需知.docx"}],"Msg":"请求成功！","List":[{"Name":"李辛","PubTime":"2017-11-30 13:42:15","Details":"一、会议主题：<\/strong><\/br>       测试外出会议通知1111<\/br>二、会议地点：<\/strong><\/br>       光华创业园10号楼<\/br>三、开会时间：<\/strong><\/br>       2017-11-30 15:00:00<\/br>四、会议内容：<\/strong><\/br>       测试外出会议通知模块1111","Title":"测试外出会议通知1111"}]}
     * Id : 4
     * Stu : 1
     */

    private RstBean Rst;
    private String Id;
    private int Stu;

    public RstBean getRst() {
        return Rst;
    }

    public void setRst(RstBean Rst) {
        this.Rst = Rst;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getStu() {
        return Stu;
    }

    public void setStu(int Stu) {
        this.Stu = Stu;
    }

    public static class RstBean {
        /**
         * AttList : [{"Url":"http://218.246.86.253/gmjdbsc/FileFujian/201711/20171130133937.docx","FileName":"请假需知.docx"},{"Url":"http://218.246.86.253/gmjdbsc/EmailFujian/201711/20171122151659.docx","FileName":"请假需知.docx"}]
         * Msg : 请求成功！
         * List : [{"Name":"李辛","PubTime":"2017-11-30 13:42:15","Details":"一、会议主题：<\/strong><\/br>       测试外出会议通知1111<\/br>二、会议地点：<\/strong><\/br>       光华创业园10号楼<\/br>三、开会时间：<\/strong><\/br>       2017-11-30 15:00:00<\/br>四、会议内容：<\/strong><\/br>       测试外出会议通知模块1111","Title":"测试外出会议通知1111"}]
         */

        private String Msg;
        private java.util.List<AttListBean> AttList;
        private java.util.List<ListBean> List;

        public String getMsg() {
            return Msg;
        }

        public void setMsg(String Msg) {
            this.Msg = Msg;
        }

        public List<AttListBean> getAttList() {
            return AttList;
        }

        public void setAttList(List<AttListBean> AttList) {
            this.AttList = AttList;
        }

        public List<ListBean> getList() {
            return List;
        }

        public void setList(List<ListBean> List) {
            this.List = List;
        }

        public static class AttListBean {
            /**
             * Url : http://218.246.86.253/gmjdbsc/FileFujian/201711/20171130133937.docx
             * FileName : 请假需知.docx
             */

            private String Url;
            private String FileName;

            public String getUrl() {
                return Url;
            }

            public void setUrl(String Url) {
                this.Url = Url;
            }

            public String getFileName() {
                return FileName;
            }

            public void setFileName(String FileName) {
                this.FileName = FileName;
            }
        }

        public static class ListBean {
            /**
             * Name : 李辛
             * PubTime : 2017-11-30 13:42:15
             * Details : 一、会议主题：</strong></br>       测试外出会议通知1111</br>二、会议地点：</strong></br>       光华创业园10号楼</br>三、开会时间：</strong></br>       2017-11-30 15:00:00</br>四、会议内容：</strong></br>       测试外出会议通知模块1111
             * Title : 测试外出会议通知1111
             */

            private String Name;
            private String PubTime;
            private String Details;
            private String Title;

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getPubTime() {
                return PubTime;
            }

            public void setPubTime(String PubTime) {
                this.PubTime = PubTime;
            }

            public String getDetails() {
                return Details;
            }

            public void setDetails(String Details) {
                this.Details = Details;
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
