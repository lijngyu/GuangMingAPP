package com.example.litianci.guangming.bean;

/**
 * Created by litianci on 2018/2/22.
 */

public class VersionResult {

    /**
     * Rst : {"Msg":"请求成功","List":{"url":"http://218.246.86.253:90/gmjdbsctest/apk/gmjd.apk","version":"1.1"}}
     * Stu : 1
     */

    private RstBean Rst;
    private String Stu;

    public RstBean getRst() {
        return Rst;
    }

    public void setRst(RstBean Rst) {
        this.Rst = Rst;
    }

    public String getStu() {
        return Stu;
    }

    public void setStu(String Stu) {
        this.Stu = Stu;
    }

    public static class RstBean {
        /**
         * Msg : 请求成功
         * List : {"url":"http://218.246.86.253:90/gmjdbsctest/apk/gmjd.apk","version":"1.1"}
         */

        private String Msg;
        private ListBean List;

        public String getMsg() {
            return Msg;
        }

        public void setMsg(String Msg) {
            this.Msg = Msg;
        }

        public ListBean getList() {
            return List;
        }

        public void setList(ListBean List) {
            this.List = List;
        }

        public static class ListBean {
            /**
             * url : http://218.246.86.253:90/gmjdbsctest/apk/gmjd.apk
             * version : 1.1
             */

            private String url;
            private String version;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }
        }
    }
}
