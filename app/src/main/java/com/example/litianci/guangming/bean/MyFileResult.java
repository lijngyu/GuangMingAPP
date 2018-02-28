package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/27.
 */

public class MyFileResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"Rank":"","IdentifyNum":"130981198201262014","Cjgznx":"1979-12-11","Synj":"50","Photo":"http://218.246.86.253/gmjdbsctest/pic_personnelhead/201712/201712201350722936.jpg","HomePhone":"","Name":"李辛","Birthday":"2017-11-16","DeptName":"办公室","OfficePhone":"","Email":"","QR":"http://218.246.86.253/gmjdbsctest/twodimensioncode/201711/20171127153644.jpg","Mobile":"13611259009","Addr":"dfdfdfdf"}]}
     * Sid : lixin
     * Stu : 1
     */

    private RstBean Rst;
    private String Sid;
    private int Stu;

    public RstBean getRst() {
        return Rst;
    }

    public void setRst(RstBean Rst) {
        this.Rst = Rst;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String Sid) {
        this.Sid = Sid;
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
         * List : [{"Rank":"","IdentifyNum":"130981198201262014","Cjgznx":"1979-12-11","Synj":"50","Photo":"http://218.246.86.253/gmjdbsctest/pic_personnelhead/201712/201712201350722936.jpg","HomePhone":"","Name":"李辛","Birthday":"2017-11-16","DeptName":"办公室","OfficePhone":"","Email":"","QR":"http://218.246.86.253/gmjdbsctest/twodimensioncode/201711/20171127153644.jpg","Mobile":"13611259009","Addr":"dfdfdfdf"}]
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
             * Rank :
             * IdentifyNum : 130981198201262014
             * Cjgznx : 1979-12-11
             * Synj : 50
             * Photo : http://218.246.86.253/gmjdbsctest/pic_personnelhead/201712/201712201350722936.jpg
             * HomePhone :
             * Name : 李辛
             * Birthday : 2017-11-16
             * DeptName : 办公室
             * OfficePhone :
             * Email :
             * QR : http://218.246.86.253/gmjdbsctest/twodimensioncode/201711/20171127153644.jpg
             * Mobile : 13611259009
             * Addr : dfdfdfdf
             */

            private String Rank;
            private String IdentifyNum;
            private String Cjgznx;
            private String Synj;
            private String Photo;
            private String HomePhone;
            private String Name;
            private String Birthday;
            private String DeptName;
            private String OfficePhone;
            private String Email;
            private String QR;
            private String Mobile;
            private String Addr;

            public String getRank() {
                return Rank;
            }

            public void setRank(String Rank) {
                this.Rank = Rank;
            }

            public String getIdentifyNum() {
                return IdentifyNum;
            }

            public void setIdentifyNum(String IdentifyNum) {
                this.IdentifyNum = IdentifyNum;
            }

            public String getCjgznx() {
                return Cjgznx;
            }

            public void setCjgznx(String Cjgznx) {
                this.Cjgznx = Cjgznx;
            }

            public String getSynj() {
                return Synj;
            }

            public void setSynj(String Synj) {
                this.Synj = Synj;
            }

            public String getPhoto() {
                return Photo;
            }

            public void setPhoto(String Photo) {
                this.Photo = Photo;
            }

            public String getHomePhone() {
                return HomePhone;
            }

            public void setHomePhone(String HomePhone) {
                this.HomePhone = HomePhone;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getBirthday() {
                return Birthday;
            }

            public void setBirthday(String Birthday) {
                this.Birthday = Birthday;
            }

            public String getDeptName() {
                return DeptName;
            }

            public void setDeptName(String DeptName) {
                this.DeptName = DeptName;
            }

            public String getOfficePhone() {
                return OfficePhone;
            }

            public void setOfficePhone(String OfficePhone) {
                this.OfficePhone = OfficePhone;
            }

            public String getEmail() {
                return Email;
            }

            public void setEmail(String Email) {
                this.Email = Email;
            }

            public String getQR() {
                return QR;
            }

            public void setQR(String QR) {
                this.QR = QR;
            }

            public String getMobile() {
                return Mobile;
            }

            public void setMobile(String Mobile) {
                this.Mobile = Mobile;
            }

            public String getAddr() {
                return Addr;
            }

            public void setAddr(String Addr) {
                this.Addr = Addr;
            }
        }
    }
}
