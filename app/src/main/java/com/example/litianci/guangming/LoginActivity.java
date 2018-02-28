package com.example.litianci.guangming;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.litianci.guangming.bean.LoginResult;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.SharedPreferencesUtils;
import com.example.litianci.guangming.utils.SystemStatusManager;
import com.example.litianci.guangming.utils.VolleyUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends Activity implements View.OnClickListener {


    @Bind(R.id.et_user)
    EditText etUser;
    @Bind(R.id.ll_user)
    LinearLayout llUser;
    @Bind(R.id.ll_center)
    LinearLayout llCenter;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.ll_password)
    LinearLayout llPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.activity_login)
    RelativeLayout activityLogin;
    private LoginResult s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus();
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        SetOnclick();
        if (getIntent().getStringExtra("type") != null && getIntent().getStringExtra("type").equals("修改")) {
            etUser.setText(User.sid);
            etPassword.setText(getIntent().getStringExtra("pwd"));
            Login();
        } else if (getIntent().getStringExtra("type") != null && getIntent().getStringExtra("type").equals("注销")) {
            etUser.setText("");
            etPassword.setText("");
        } else {

        }

//        Login();
    }

    public void SetOnclick() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Login();
    }

    public void Login() {
        if (etPassword.getText().toString().length() < 6) {
            Toast.makeText(LoginActivity.this, "密码不能小于6位！", Toast.LENGTH_SHORT).show();
        } else {
            Map<String, String> params = new HashMap<String, String>();
            params.put(Globals.WS_POST_KEY, "{\"Ac\": \"Login\",\"Para\": {\"Mb\": \"" + etUser.getText().toString().trim()
                    + "\",\"Pwd\": \"" + etPassword.getText().toString().trim() + "\",\"Cid\":\"" + User.Cid + "\",\"PhType\":\"" + "0" + "\"}}");

            new VolleyUtil() {

                @Override
                public <T> boolean analysisData(String response) {
                    s3 = GsonUtils.json2bean(response, LoginResult.class);
                    Log.i("wwwwwww", response);
                    if (s3 == null || !(s3.getStu() == 1)) {
                        Toast.makeText(LoginActivity.this, Globals.SER_ERROR,
                                Toast.LENGTH_SHORT).show();

                    } else {
                        if (s3.getRst().getScd() .equals("1")) {
                            Toast.makeText(LoginActivity.this, s3.getRst().getMsg(),
                                    Toast.LENGTH_SHORT).show();
                            User.sid = etUser.getText().toString();
                            User.pwd = etPassword.getText().toString();
                            User.name = s3.getRst().getN();
                            User.IconPath = s3.getRst().getPh();
                            User.depname = s3.getRst().getDept();
                            User.ISKY = s3.getRst().getISKY();
                            User.isLogin = true;
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


                            SharedPreferencesUtils.saveString(LoginActivity.this,
                                    Globals.USER_JJMM, "1");
                            SharedPreferencesUtils.saveString(LoginActivity.this,
                                    Globals.USER_PHONE, s3.getRst().getSid());
                            SharedPreferencesUtils.saveString(LoginActivity.this,
                                    Globals.USER_PASSWORD, etPassword.getText().toString().trim());
                            SharedPreferencesUtils.saveString(LoginActivity.this,
                                    Globals.C_id, User.Cid);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();


                        } else {
                            Toast.makeText(LoginActivity.this, s3.getRst().getMsg(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                    return false;
                }
            }.volleyStringRequestPost(LoginActivity.this, params, "app?", null);
        }

    }

    /**
     * 设置状态栏背景状态
     */
    private void setTranslucentStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            winParams.flags |= bits;
            win.setAttributes(winParams);
        }
        SystemStatusManager tintManager = new SystemStatusManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(this.getResources().getColor(R.color.colortheme));
    }
}
