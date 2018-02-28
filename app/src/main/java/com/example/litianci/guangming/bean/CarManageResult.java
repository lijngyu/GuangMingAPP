package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/20.
 */

public class CarManageResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"Yancheriqi":"321","Examiner":"123","Motorcycletype":"123","Baoxiandaoqiriqi":"123","Id":"1","Licensenub":"123","Isreturn":"未还","Remark":"312","Fanwei":"123"}]}
     * Id : 1
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
         * Msg : 请求成功！
         * List : [{"Yancheriqi":"321","Examiner":"123","Motorcycletype":"123","Baoxiandaoqiriqi":"123","Id":"1","Licensenub":"123","Isreturn":"未还","Remark":"312","Fanwei":"123"}]
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
             * Yancheriqi : 321
             * Examiner : 123
             * Motorcycletype : 123
             * Baoxiandaoqiriqi : 123
             * Id : 1
             * Licensenub : 123
             * Isreturn : 未还
             * Remark : 312
             * Fanwei : 123
             */

            private String Yancheriqi;
            private String Examiner;
            private String Motorcycletype;
            private String Baoxiandaoqiriqi;
            private String Id;
            private String Licensenub;
            private String Isreturn;
            private String Remark;
            private String Fanwei;

            public String getYancheriqi() {
                return Yancheriqi;
            }

            public void setYancheriqi(String Yancheriqi) {
                this.Yancheriqi = Yancheriqi;
            }

            public String getExaminer() {
                return Examiner;
            }

            public void setExaminer(String Examiner) {
                this.Examiner = Examiner;
            }

            public String getMotorcycletype() {
                return Motorcycletype;
            }

            public void setMotorcycletype(String Motorcycletype) {
                this.Motorcycletype = Motorcycletype;
            }

            public String getBaoxiandaoqiriqi() {
                return Baoxiandaoqiriqi;
            }

            public void setBaoxiandaoqiriqi(String Baoxiandaoqiriqi) {
                this.Baoxiandaoqiriqi = Baoxiandaoqiriqi;
            }

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getLicensenub() {
                return Licensenub;
            }

            public void setLicensenub(String Licensenub) {
                this.Licensenub = Licensenub;
            }

            public String getIsreturn() {
                return Isreturn;
            }

            public void setIsreturn(String Isreturn) {
                this.Isreturn = Isreturn;
            }

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
            }

            public String getFanwei() {
                return Fanwei;
            }

            public void setFanwei(String Fanwei) {
                this.Fanwei = Fanwei;
            }
        }
    }
}
