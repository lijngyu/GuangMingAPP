package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/11/30.
 */

public class YongzhangResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"SealName":"王瑞雪用章申请test1","Time":"2017-11-08","Dept":"社区建设科","Id":"15","SealType":"0","Person":"王瑞雪"},{"SealName":"刘丽云测试社区用章申请","Time":"2017-11-08","Dept":"东兴一区","Id":"13","SealType":"1","Person":"刘利云"},{"SealName":"1111111","Time":"2017-11-07","Dept":"党建工作科","Id":"14","SealType":"1","Person":"刘京琪"},{"SealName":"理想里测试返回按钮111","Time":"2017-11-06","Dept":"办公室","Id":"11","SealType":"0","Person":"李向利"},{"SealName":"00000000000000000","Time":"2017-11-05","Dept":"办公室","Id":"9","SealType":"0","Person":"王明宇"},{"SealName":"777777","Time":"2017-11-04","Dept":"办公室","Id":"8","SealType":"1","Person":"王明宇"},{"SealName":"王明玉测试申请返回按钮bug","Time":"2017-11-03","Dept":"办公室","Id":"10","SealType":"0","Person":"王明宇"},{"SealName":"天竺","Time":"2017-11-01","Dept":"办公室","Id":"6","SealType":"0","Person":"李辛"},{"SealName":"测试印章申请11111111","Time":"2017-10-25","Dept":"党建工作科","Id":"2","SealType":"1","Person":"杨琳"}]}
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
         * List : [{"SealName":"王瑞雪用章申请test1","Time":"2017-11-08","Dept":"社区建设科","Id":"15","SealType":"0","Person":"王瑞雪"},{"SealName":"刘丽云测试社区用章申请","Time":"2017-11-08","Dept":"东兴一区","Id":"13","SealType":"1","Person":"刘利云"},{"SealName":"1111111","Time":"2017-11-07","Dept":"党建工作科","Id":"14","SealType":"1","Person":"刘京琪"},{"SealName":"理想里测试返回按钮111","Time":"2017-11-06","Dept":"办公室","Id":"11","SealType":"0","Person":"李向利"},{"SealName":"00000000000000000","Time":"2017-11-05","Dept":"办公室","Id":"9","SealType":"0","Person":"王明宇"},{"SealName":"777777","Time":"2017-11-04","Dept":"办公室","Id":"8","SealType":"1","Person":"王明宇"},{"SealName":"王明玉测试申请返回按钮bug","Time":"2017-11-03","Dept":"办公室","Id":"10","SealType":"0","Person":"王明宇"},{"SealName":"天竺","Time":"2017-11-01","Dept":"办公室","Id":"6","SealType":"0","Person":"李辛"},{"SealName":"测试印章申请11111111","Time":"2017-10-25","Dept":"党建工作科","Id":"2","SealType":"1","Person":"杨琳"}]
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
             * SealName : 王瑞雪用章申请test1
             * Time : 2017-11-08
             * Dept : 社区建设科
             * Id : 15
             * SealType : 0
             * Person : 王瑞雪
             */

            private String SealName;
            private String Time;
            private String Dept;
            private String Id;
            private String SealType;
            private String Person;

            public String getSealName() {
                return SealName;
            }

            public void setSealName(String SealName) {
                this.SealName = SealName;
            }

            public String getTime() {
                return Time;
            }

            public void setTime(String Time) {
                this.Time = Time;
            }

            public String getDept() {
                return Dept;
            }

            public void setDept(String Dept) {
                this.Dept = Dept;
            }

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getSealType() {
                return SealType;
            }

            public void setSealType(String SealType) {
                this.SealType = SealType;
            }

            public String getPerson() {
                return Person;
            }

            public void setPerson(String Person) {
                this.Person = Person;
            }
        }
    }
}
