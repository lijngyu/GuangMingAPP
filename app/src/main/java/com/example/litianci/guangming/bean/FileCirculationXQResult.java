package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/28.
 */

public class FileCirculationXQResult {


    /**
     * Rst : {"Time":"2017-11-21 03:00:00","Beizhu":"文件传阅测试444","Days":"超时25天","Yichuanyue":"刘京琪，左朝晖，姜惠琴，陈志勇，王瑞雪，杨迎宇","Attach":[{"AttachName":"1119.txt","AttachUrl":"http://218.246.86.253/gmjdbsctest//documentcircu/201711/20171127114752.txt"}],"Request":"2017-12-11","Msg":"请求成功！","Sketch":"文件传阅测试444","Unit":"文件传阅测试444","Title":"文件传阅测试444","Wenhao":"文件传阅测试444","Pishilist":[{"fasongname":"姜惠琴","listcontent":[{"content":"已阅 请刘京琪办理。 ","time":"2017-11-27 11:48:43"}]},{"fasongname":"陈志勇","listcontent":[{"content":"同意 请左朝晖办理。 ","time":"2017-11-27 11:51:09"}]},{"fasongname":"刘京琪","listcontent":[{"content":"已阅 请王瑞雪办理。 ","time":"2017-11-27 11:49:30"}]},{"fasongname":"王瑞雪","listcontent":[{"content":"已阅 请杨迎宇办理。 ","time":"2017-11-27 11:49:56"}]},{"fasongname":"杨迎宇","listcontent":[{"content":"已阅 ","time":"2017-11-27 11:50:09"}]}]}
     * time : 2017-11-21 03:00:00
     * days : 超时25天
     * request : 2017-12-11
     * Stu : 1
     */

    private RstBean Rst;
    private String time;
    private String days;
    private String request;
    private int Stu;

    public RstBean getRst() {
        return Rst;
    }

    public void setRst(RstBean Rst) {
        this.Rst = Rst;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public int getStu() {
        return Stu;
    }

    public void setStu(int Stu) {
        this.Stu = Stu;
    }

    public static class RstBean {
        /**
         * Time : 2017-11-21 03:00:00
         * Beizhu : 文件传阅测试444
         * Days : 超时25天
         * Yichuanyue : 刘京琪，左朝晖，姜惠琴，陈志勇，王瑞雪，杨迎宇
         * Attach : [{"AttachName":"1119.txt","AttachUrl":"http://218.246.86.253/gmjdbsctest//documentcircu/201711/20171127114752.txt"}]
         * Request : 2017-12-11
         * Msg : 请求成功！
         * Sketch : 文件传阅测试444
         * Unit : 文件传阅测试444
         * Title : 文件传阅测试444
         * Wenhao : 文件传阅测试444
         * Pishilist : [{"fasongname":"姜惠琴","listcontent":[{"content":"已阅 请刘京琪办理。 ","time":"2017-11-27 11:48:43"}]},{"fasongname":"陈志勇","listcontent":[{"content":"同意 请左朝晖办理。 ","time":"2017-11-27 11:51:09"}]},{"fasongname":"刘京琪","listcontent":[{"content":"已阅 请王瑞雪办理。 ","time":"2017-11-27 11:49:30"}]},{"fasongname":"王瑞雪","listcontent":[{"content":"已阅 请杨迎宇办理。 ","time":"2017-11-27 11:49:56"}]},{"fasongname":"杨迎宇","listcontent":[{"content":"已阅 ","time":"2017-11-27 11:50:09"}]}]
         */

        private String Time;
        private String Beizhu;
        private String Days;
        private String Yichuanyue;
        private String Request;
        private String Msg;
        private String Sketch;
        private String Unit;
        private String Title;
        private String Wenhao;
        private List<AttachBean> Attach;
        private List<PishilistBean> Pishilist;

        public String getTime() {
            return Time;
        }

        public void setTime(String Time) {
            this.Time = Time;
        }

        public String getBeizhu() {
            return Beizhu;
        }

        public void setBeizhu(String Beizhu) {
            this.Beizhu = Beizhu;
        }

        public String getDays() {
            return Days;
        }

        public void setDays(String Days) {
            this.Days = Days;
        }

        public String getYichuanyue() {
            return Yichuanyue;
        }

        public void setYichuanyue(String Yichuanyue) {
            this.Yichuanyue = Yichuanyue;
        }

        public String getRequest() {
            return Request;
        }

        public void setRequest(String Request) {
            this.Request = Request;
        }

        public String getMsg() {
            return Msg;
        }

        public void setMsg(String Msg) {
            this.Msg = Msg;
        }

        public String getSketch() {
            return Sketch;
        }

        public void setSketch(String Sketch) {
            this.Sketch = Sketch;
        }

        public String getUnit() {
            return Unit;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getWenhao() {
            return Wenhao;
        }

        public void setWenhao(String Wenhao) {
            this.Wenhao = Wenhao;
        }

        public List<AttachBean> getAttach() {
            return Attach;
        }

        public void setAttach(List<AttachBean> Attach) {
            this.Attach = Attach;
        }

        public List<PishilistBean> getPishilist() {
            return Pishilist;
        }

        public void setPishilist(List<PishilistBean> Pishilist) {
            this.Pishilist = Pishilist;
        }

        public static class AttachBean {
            /**
             * AttachName : 1119.txt
             * AttachUrl : http://218.246.86.253/gmjdbsctest//documentcircu/201711/20171127114752.txt
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

        public static class PishilistBean {
            /**
             * fasongname : 姜惠琴
             * listcontent : [{"content":"已阅 请刘京琪办理。 ","time":"2017-11-27 11:48:43"}]
             */

            private String fasongname;
            private List<ListcontentBean> listcontent;

            public String getFasongname() {
                return fasongname;
            }

            public void setFasongname(String fasongname) {
                this.fasongname = fasongname;
            }

            public List<ListcontentBean> getListcontent() {
                return listcontent;
            }

            public void setListcontent(List<ListcontentBean> listcontent) {
                this.listcontent = listcontent;
            }

            public static class ListcontentBean {
                /**
                 * content : 已阅 请刘京琪办理。
                 * time : 2017-11-27 11:48:43
                 */

                private String content;
                private String time;

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }
            }
        }
    }
}
