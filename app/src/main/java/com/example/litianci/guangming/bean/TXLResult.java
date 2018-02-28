package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/1.
 */

public class TXLResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"Name":"李辛","Dept":"办公室","Officephone":"","Mobile":"13611259009","Photo":"http://218.246.86.253/gmjdbsc/personphoto/201710/20171022133300.png","Code":"lixin","Pk":"1"},{"Name":"王明宇","Dept":"办公室","Officephone":"","Mobile":"13716167783","Photo":"","Code":"wangmingyu","Pk":"2"},{"Name":"李向利","Dept":"办公室","Officephone":"","Mobile":"15116976708","Photo":"","Code":"lixiangli","Pk":"3"},{"Name":"董建文","Dept":"办公室","Officephone":"","Mobile":"13521850358","Photo":"","Code":"dongjianwen","Pk":"4"},{"Name":"陈建明","Dept":"办公室","Officephone":"","Mobile":"13811310035","Photo":"","Code":"chenjianming","Pk":"5"},{"Name":"彭立平","Dept":"办公室","Officephone":"","Mobile":"13910538239","Photo":"","Code":"pengliping","Pk":"6"},{"Name":"李冠群","Dept":"办公室","Officephone":"","Mobile":"13521996639","Photo":"","Code":"liguanqun","Pk":"7"},{"Name":"常征","Dept":"社区服务中心","Officephone":"","Mobile":"13716333950","Photo":"","Code":"changzheng","Pk":"11"},{"Name":"赵润琦","Dept":"社区服务中心","Officephone":"","Mobile":"18813009982","Photo":"","Code":"zhaorunqi","Pk":"12"}]}
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
         * List : [{"Name":"李辛","Dept":"办公室","Officephone":"","Mobile":"13611259009","Photo":"http://218.246.86.253/gmjdbsc/personphoto/201710/20171022133300.png","Code":"lixin","Pk":"1"},{"Name":"王明宇","Dept":"办公室","Officephone":"","Mobile":"13716167783","Photo":"","Code":"wangmingyu","Pk":"2"},{"Name":"李向利","Dept":"办公室","Officephone":"","Mobile":"15116976708","Photo":"","Code":"lixiangli","Pk":"3"},{"Name":"董建文","Dept":"办公室","Officephone":"","Mobile":"13521850358","Photo":"","Code":"dongjianwen","Pk":"4"},{"Name":"陈建明","Dept":"办公室","Officephone":"","Mobile":"13811310035","Photo":"","Code":"chenjianming","Pk":"5"},{"Name":"彭立平","Dept":"办公室","Officephone":"","Mobile":"13910538239","Photo":"","Code":"pengliping","Pk":"6"},{"Name":"李冠群","Dept":"办公室","Officephone":"","Mobile":"13521996639","Photo":"","Code":"liguanqun","Pk":"7"},{"Name":"常征","Dept":"社区服务中心","Officephone":"","Mobile":"13716333950","Photo":"","Code":"changzheng","Pk":"11"},{"Name":"赵润琦","Dept":"社区服务中心","Officephone":"","Mobile":"18813009982","Photo":"","Code":"zhaorunqi","Pk":"12"}]
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
             * Name : 李辛
             * Dept : 办公室
             * Officephone :
             * Mobile : 13611259009
             * Photo : http://218.246.86.253/gmjdbsc/personphoto/201710/20171022133300.png
             * Code : lixin
             * Pk : 1
             */

            private String Name;
            private String Dept;
            private String Officephone;
            private String Mobile;
            private String Photo;
            private String Code;
            private String Pk;

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getDept() {
                return Dept;
            }

            public void setDept(String Dept) {
                this.Dept = Dept;
            }

            public String getOfficephone() {
                return Officephone;
            }

            public void setOfficephone(String Officephone) {
                this.Officephone = Officephone;
            }

            public String getMobile() {
                return Mobile;
            }

            public void setMobile(String Mobile) {
                this.Mobile = Mobile;
            }

            public String getPhoto() {
                return Photo;
            }

            public void setPhoto(String Photo) {
                this.Photo = Photo;
            }

            public String getCode() {
                return Code;
            }

            public void setCode(String Code) {
                this.Code = Code;
            }

            public String getPk() {
                return Pk;
            }

            public void setPk(String Pk) {
                this.Pk = Pk;
            }
        }
    }
}
