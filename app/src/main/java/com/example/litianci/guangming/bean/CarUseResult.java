package com.example.litianci.guangming.bean;

import java.util.List;

/**
 * Created by litianci on 2017/12/20.
 */

public class CarUseResult {

    /**
     * Rst : {"Msg":"请求成功！","List":[{"Applyer":"王明宇","Safeguardscope":"","Lianxidianhua":"15028606000","Departtime":"2017-12-12 00:00:00","Bgsleaderopinion":"樊雨松：已阅。2017-12-01 13:21:30。","Bgsleaderideadate":"","Licensenub":"京GXX090","Vehicleincident":"ababafadf","Governoropinion":"","Repaytime":"","Id":"9","Exleaderideadate":"","Isreturn":"未还","Destination":"dfdfd","Deptname":"办公室"}]}
     * Id : 9
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
         * List : [{"Applyer":"王明宇","Safeguardscope":"","Lianxidianhua":"15028606000","Departtime":"2017-12-12 00:00:00","Bgsleaderopinion":"樊雨松：已阅。2017-12-01 13:21:30。","Bgsleaderideadate":"","Licensenub":"京GXX090","Vehicleincident":"ababafadf","Governoropinion":"","Repaytime":"","Id":"9","Exleaderideadate":"","Isreturn":"未还","Destination":"dfdfd","Deptname":"办公室"}]
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
             * Applyer : 王明宇
             * Safeguardscope :
             * Lianxidianhua : 15028606000
             * Departtime : 2017-12-12 00:00:00
             * Bgsleaderopinion : 樊雨松：已阅。2017-12-01 13:21:30。
             * Bgsleaderideadate :
             * Licensenub : 京GXX090
             * Vehicleincident : ababafadf
             * Governoropinion :
             * Repaytime :
             * Id : 9
             * Exleaderideadate :
             * Isreturn : 未还
             * Destination : dfdfd
             * Deptname : 办公室
             */

            private String Applyer;
            private String Safeguardscope;
            private String Lianxidianhua;
            private String Departtime;
            private String Bgsleaderopinion;
            private String Bgsleaderideadate;
            private String Licensenub;
            private String Vehicleincident;
            private String Governoropinion;
            private String Repaytime;
            private String Id;
            private String Exleaderideadate;
            private String Isreturn;
            private String Destination;
            private String Deptname;

            public String getApplyer() {
                return Applyer;
            }

            public void setApplyer(String Applyer) {
                this.Applyer = Applyer;
            }

            public String getSafeguardscope() {
                return Safeguardscope;
            }

            public void setSafeguardscope(String Safeguardscope) {
                this.Safeguardscope = Safeguardscope;
            }

            public String getLianxidianhua() {
                return Lianxidianhua;
            }

            public void setLianxidianhua(String Lianxidianhua) {
                this.Lianxidianhua = Lianxidianhua;
            }

            public String getDeparttime() {
                return Departtime;
            }

            public void setDeparttime(String Departtime) {
                this.Departtime = Departtime;
            }

            public String getBgsleaderopinion() {
                return Bgsleaderopinion;
            }

            public void setBgsleaderopinion(String Bgsleaderopinion) {
                this.Bgsleaderopinion = Bgsleaderopinion;
            }

            public String getBgsleaderideadate() {
                return Bgsleaderideadate;
            }

            public void setBgsleaderideadate(String Bgsleaderideadate) {
                this.Bgsleaderideadate = Bgsleaderideadate;
            }

            public String getLicensenub() {
                return Licensenub;
            }

            public void setLicensenub(String Licensenub) {
                this.Licensenub = Licensenub;
            }

            public String getVehicleincident() {
                return Vehicleincident;
            }

            public void setVehicleincident(String Vehicleincident) {
                this.Vehicleincident = Vehicleincident;
            }

            public String getGovernoropinion() {
                return Governoropinion;
            }

            public void setGovernoropinion(String Governoropinion) {
                this.Governoropinion = Governoropinion;
            }

            public String getRepaytime() {
                return Repaytime;
            }

            public void setRepaytime(String Repaytime) {
                this.Repaytime = Repaytime;
            }

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getExleaderideadate() {
                return Exleaderideadate;
            }

            public void setExleaderideadate(String Exleaderideadate) {
                this.Exleaderideadate = Exleaderideadate;
            }

            public String getIsreturn() {
                return Isreturn;
            }

            public void setIsreturn(String Isreturn) {
                this.Isreturn = Isreturn;
            }

            public String getDestination() {
                return Destination;
            }

            public void setDestination(String Destination) {
                this.Destination = Destination;
            }

            public String getDeptname() {
                return Deptname;
            }

            public void setDeptname(String Deptname) {
                this.Deptname = Deptname;
            }
        }
    }
}
