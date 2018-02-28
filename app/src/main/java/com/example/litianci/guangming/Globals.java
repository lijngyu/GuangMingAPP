package com.example.litianci.guangming;

import android.content.Context;

/**
 * 全局变量类  静态常量
 */

public class Globals {

    public static int maxDisplaySize, screenWidth, screenHeight, thumbnailMaxVal, thumbnailMinVal;
    public static Context context; // 数据上下文
    public static final String SPLASH_USERTYPE = "USERTYPE";
    public static final String USER_PHONE = "userPhoene";
    public static final String USER_PASSWORD = "userpassword";
    public static final String USER_YD = "userdl";


    public static final String C_id = "cid";
    public static final String LOG_TAG = "RESPONSE";
    public static final String USER_JJMM = "jjmm";

    public static final String QJBS = "gwgl";

    //  /*开发环境*/
//    public static final String MY_URL = "http://192.168.1.110/gmjdbsc/";
    public static final String MY_URL = "http://218.246.86.253:90/gmjdbsctest/";
    public static  String WS_URI_POTO = MY_URL+"UserPhoto";
    public static final String VERSION_XML = MY_URL+"SoftUpdate/Update.xml";

    /**
     * 公文管理的list（详情）
     */
    public static final String LIDS = "lids";

    /**
     * 标识符
     */
    public static final String BSF = "bsf";

    /**
     * log日志
     */
    public static final String LOG_I = "_______log______";
    public static final String WS_POST_KEY = "id";
    public static final String SER_ERROR = "服务器端发生异常，请稍后重试!";
}
