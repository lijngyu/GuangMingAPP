package com.example.litianci.guangming.home;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litianci.guangming.BaseActivity;
import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.bean.CarManageResult;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;
import com.example.litianci.guangming.views.ListViewForScrollView;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SendDataActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_addperson)
    TextView tvAddperson;
    @Bind(R.id.et_theme)
    EditText etTheme;
    @Bind(R.id.et_content)
    EditText etContent;
    @Bind(R.id.tv_addfj)
    TextView tvAddfj;
    @Bind(R.id.sq_list)
    ListViewForScrollView sqList;
    @Bind(R.id.btn_send)
    Button btnSend;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    private Bundle bundle2;
    /**
     * 收件人
     */
    private String strFromAct2 = "";
    /**
     * 收件人对应id
     */
    private String ryid = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_send_data);
        ButterKnife.bind(this);
        ivBack.setOnClickListener(this);
        tvAddfj.setOnClickListener(this);
        tvAddperson.setOnClickListener(this);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back: {
                finish();
            }
            break;
            case R.id.tv_addfj: {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                try {
                    startActivityForResult(Intent.createChooser(intent, "请选择一个要上传的文件"),
                            1);
                } catch (ActivityNotFoundException ex) {
                    // Potentially direct the user to the Market with a Dialog
                    Toast.makeText(this, "请安装文件管理器", Toast.LENGTH_SHORT)
                            .show();
                }
            }
            break;
            case R.id.tv_addperson: {
                Intent intent1 = new Intent();
                intent1.putExtra("bzf", "CZLXR");
                intent1.setClass(SendDataActivity.this, SelectPersonActivity.class);
                startActivityForResult(intent1, 0);
            }
            break;
            case R.id.btn_send: {
                bianji();
            }
            break;

            default:
                break;
        }
    }

    public void bianji() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"CZL\",\"Para\": {\"Code\": \"" + User.sid + "\",\"Theme\": \"" + etTheme.getText().toString().trim() + "\",\"Body\": \"" + etContent.getText().toString().trim() + "\",\"Recipient\": \"" + ryid + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                CarManageResult s3 = GsonUtils.json2bean(response, CarManageResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(SendDataActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SendDataActivity.this, s3.getRst().getMsg(),
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
                return false;
            }
        }.volleyStringRequestPost(SendDataActivity.this, params, "app?", null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (0 == requestCode && resultCode == 2) {
            if (!(data == null)) {
//                bundle2 = data.getBundleExtra("bundle2");
                strFromAct2 = data.getStringExtra("strResult");
                ryid = data.getStringExtra("strResult2");
                tvName.setText(strFromAct2);
                Log.i("数据格式",ryid);
            }
        }
    }
}
