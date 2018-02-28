package com.example.litianci.guangming;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;


import com.example.litianci.guangming.bean.LoginResult;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.PermissionUtil;
import com.example.litianci.guangming.utils.SharedPreferencesUtils;
import com.example.litianci.guangming.utils.VolleyUtil;

import java.util.HashMap;
import java.util.Map;

import cn.org.bjca.signet.sdk.SignetSDKInstance;


/**
 * 进入程序的时候必须进入加载页面
 * 程序的欢迎的页面如果用户已经登录的情况下不需要登录直接进入社区界面
 *
 * @author ZJP
 *         created at 2016/2/29、 9:15
 */
public class SplashScreenActivity extends BaseActivity {
    //获取本地的轻量级的存储对象
    private SharedPreferences myPrefer;
    //欢迎页面的展示时间
    private final int SPLASH_DISPLAY_LENGHT = 1500;
    //获得的社区id ，和登录的标示符
    private String sqid, Sid;
    //    private UpdateVersionService updateVersionService;
    private String singid;
    private String dataca = "";
    private SignetSDKInstance signetInstance;
    private String cert = "";
    private String singdata = "";
    private LoginResult s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        myPrefer = getSharedPreferences(Globals.SPLASH_USERTYPE, Activity.MODE_PRIVATE);


        //开启一个线程将本地保存的数据 登录
        new Handler().postDelayed(new Runnable() {
            public void run() {
                //创建的如果本地没有存在数据的情况下跳转到登录的界面上 否则直接使用的本地的数据登录app
                if ("".equals(SharedPreferencesUtils.getString(SplashScreenActivity.this, Globals.USER_PHONE, ""))
                        && "".equals(SharedPreferencesUtils.getString(SplashScreenActivity.this, Globals.USER_PASSWORD, ""))) {


                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    User.isLogin = false;
                    startActivity(intent);
                    SplashScreenActivity.this.finish();
                    Log.i("zhangjianpeng", "本地没有数据");


                } else {
                    //有账号登录(旧版本)
                    if (SharedPreferencesUtils.getString(SplashScreenActivity.this, Globals.C_id, null) == null) {
                        //改版之后
                        Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                        User.isLogin = false;
                        startActivity(intent);
                        SplashScreenActivity.this.finish();
                    } else {
                        PermissionUtil.getInstance().request(SplashScreenActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA, android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION}, 10,
                                new PermissionUtil.PermissionResultCallBack() {
                                    @Override
                                    public void onPermissionGranted() {
                                        Log.i("zhang", "当所有权限的申请被用户同意之后,该方法会被调用");
                                        // 当所有权限的申请被用户同意之后,该方法会被调用
                                    }

                                    @Override
                                    public void onPermissionDenied(String... permissions) {
                                        Log.i("zhang", "当权限申请中的某一个或多个权限,被用户曾经否定了,并确认了不再提醒时,也就是权限的申请窗口不能再弹出时,该方法将会被调用,该方法会被调用");
                                        // 当权限申请中的某一个或多个权限,被用户曾经否定了,并确认了不再提醒时,也就是权限的申请窗口不能再弹出时,该方法将会被调用
                                    }

                                    @Override
                                    public void onRationalShow(String... permissions) {
                                        Log.i("zhang", "当权限申请中的某一个或多个权限,被用户否定了,但没有确认不再提醒时,也就是权限窗口申请时,但被否定了之后,该方法将会被调用.");
                                        // 当权限申请中的某一个或多个权限,被用户否定了,但没有确认不再提醒时,也就是权限窗口申请时,但被否定了之后,该方法将会被调用.
                                    }
                                });
//                        signetInstance = SignetSDKInstance.getInstance("905b5f7c586747fab20fdfa041c63842");
//                        User.msspid = SharedPreferencesUtils.getString(SplashScreenActivity.this, Globals.USER_MSSPId, "");
//                        getSingid();
                        initLogin();

                    }

                }
            }
        }, SPLASH_DISPLAY_LENGHT);

    }
    public void initLogin(){

            Map<String, String> params = new HashMap<String, String>();
            params.put(Globals.WS_POST_KEY, "{\"Ac\": \"Login\",\"Para\": {\"Mb\": \"" + SharedPreferencesUtils.getString(
                    SplashScreenActivity.this, Globals.USER_PHONE, null)
                    + "\",\"Pwd\": \"" + SharedPreferencesUtils.getString(
                    SplashScreenActivity.this, Globals.USER_PASSWORD, null) + "\",\"Cid\":\"" + User.Cid + "\",\"PhType\":\"" + "0" + "\"}}");

            new VolleyUtil() {

                @Override
                public <T> boolean analysisData(String response) {
                    s3 = GsonUtils.json2bean(response, LoginResult.class);
                    Log.i("wwwwwww", response);
                    if (s3 == null || !(s3.getStu() == 1)) {
                        Toast.makeText(SplashScreenActivity.this, Globals.SER_ERROR,
                                Toast.LENGTH_SHORT).show();

                    } else {
                        if (s3.getRst().getScd() .equals("1")) {
                            Toast.makeText(SplashScreenActivity.this, s3.getRst().getMsg(),
                                    Toast.LENGTH_SHORT).show();
                            User.sid = SharedPreferencesUtils.getString(
                                    SplashScreenActivity.this, Globals.USER_PHONE, null);
                            User.pwd = SharedPreferencesUtils.getString(
                                    SplashScreenActivity.this, Globals.USER_PASSWORD, null);
                            User.name = s3.getRst().getN();
                            User.IconPath = s3.getRst().getPh();
                            User.depname = s3.getRst().getDept();
                            User.ISKY = s3.getRst().getISKY();
                            User.wjcy=s3.getRst().getWJCY();
                            User.txl=s3.getRst().getTXL();
                            User.zbap=s3.getRst().getZBAP();
                            User.rcap=s3.getRst().getRCAP();
                            User.qjcx=s3.getRst().getQJCX();
                            User.yzcx=s3.getRst().getYZCX();
                            User.czl=s3.getRst().getCZL();
                            User.szl=s3.getRst().getSZL();
                            User.yfs=s3.getRst().getYFS();
                            User.sczl=s3.getRst().getSCZL();
                            User.dbgz=s3.getRst().getDBGZ();
                            User.ybgz=s3.getRst().getYBGZ();
                            User.scgz="1";
                            User.hytzfs=s3.getRst().getHYTZFS();
                            User.hytzcx=s3.getRst().getHYTZCX();
                            User.hysydcx=s3.getRst().getHYSYDCX();
                            User.hyclgl=s3.getRst().getHYCLGL();
                            User.clxxgl=s3.getRst().getCLXXGL();
                            User.clsyjl=s3.getRst().getCLSYJL();
                            User.hysq=s3.getRst().getHYSQ();
                            User.tzggfbsq=s3.getRst().getTZGGFBSQ();
                            User.yzsq=s3.getRst().getYZSQ();
                            User.fwsq=s3.getRst().getFWSQ();
                            User.qjsq=s3.getRst().getQJSQ();
                            User.clsysq=s3.getRst().getCLSYSQ();
                            User.hbsq=s3.getRst().getHBSQ();
                            User.gztz=s3.getRst().getGZTZ();

                            User.isLogin = true;

                            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();


                        } else {
                            Toast.makeText(SplashScreenActivity.this, s3.getRst().getMsg(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                            User.isLogin = false;
                            startActivity(intent);
                            SplashScreenActivity.this.finish();
                        }
                    }
                    return false;
                }
            }.volleyStringRequestPost(SplashScreenActivity.this, params, "app?", null);
        }



}