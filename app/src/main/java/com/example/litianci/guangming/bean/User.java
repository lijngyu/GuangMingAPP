package com.example.litianci.guangming.bean;

/**
 * 程序账号中的用户信息（数据属于全局使用的方式）
 *
 * @author ZJP
 *         created at 2016/3/14 15:02
 */
public class User {

    /**
     * 用户id
     */
    public static String sid = "";
    /**
     * 密码
     */

    public static String pwd = "";
    public static String name = "用户名";
    public static String Cid = "";
    public static String IconPath = "";
    public static String depname = "";
    /**
     * 用户是不是登录
     */
    public static boolean isLogin;
    /***
     * 模块权限
     * 0 无权限 1 有权限
     */
    public static String ISKY = "0";
    public static String wjcy = "0";
    public static String txl = "0";
    public static String zbap = "0";
    public static String rcap = "0";
    public static String qjcx = "0";
    public static String yzcx = "0";
    public static String czl = "0";
    public static String szl = "0";
    public static String yfs = "0";
    public static String sczl = "0";
    public static String dbgz = "0";
    public static String ybgz = "0";
    public static String scgz = "0";
    public static String hytzfs = "0";
    public static String hytzcx = "0";
    public static String hysydcx = "0";
    public static String hyclgl = "0";
    public static String clxxgl = "0";
    public static String clsyjl = "0";
    public static String hysq = "0";
    public static String tzggfbsq = "0";
    public static String yzsq = "0";
    public static String fwsq = "0";
    public static String qjsq = "0";
    public static String clsysq = "0";
    public static String hbsq = "0";
    public static String gztz = "0";





    /**
     * 添加user用户的信息
     */
    public static void setLoginInfo(String id, String pwd,
                                    String iconPath, String name,String depname,String ISKY) {
        User.sid = id;
        User.pwd = pwd;
        User.IconPath = iconPath;
        User.name = name;
        User.depname = depname;
        User.ISKY = ISKY;
    }
}
