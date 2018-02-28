package com.example.litianci.guangming.my;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.litianci.guangming.BaseActivity;
import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.LoginActivity;
import com.example.litianci.guangming.MainActivity;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.bean.CarManageResult;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EditPwdActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.et_user2)
    EditText etUser2;
    @Bind(R.id.et_user)
    EditText etUser;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_edit_pwd);
        ButterKnife.bind(this);
        ivBack.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    public void bianji() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"ChangePwd\",\"Para\": {\"Sid\": \"" + User.sid + "\",\"Old\": \"" + etUser2.getText().toString().trim() + "\",\"New\": \"" + etUser.getText().toString().trim() + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                CarManageResult s3 = GsonUtils.json2bean(response, CarManageResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(EditPwdActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditPwdActivity.this, s3.getRst().getMsg(),
                            Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent = new Intent(EditPwdActivity.this, LoginActivity.class);
                    intent.putExtra("type", "修改");
                    intent.putExtra("user", etUser.getText().toString().trim());
                    intent.putExtra("pwd", etPassword.getText().toString().trim());
                    startActivity(intent);
                }
                return false;
            }
        }.volleyStringRequestPost(EditPwdActivity.this, params, "app?", null);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back: {
                finish();
            }
            break;
            case R.id.btn_login: {
                if (!etPassword.getText().toString().trim().equals(etUser.getText().toString().trim())) {
                    Toast.makeText(EditPwdActivity.this, "两次新密码前后不一致",
                            Toast.LENGTH_SHORT).show();
                } else {
                    bianji();
                }


            }
            break;
            default:
                break;
        }
    }
}
