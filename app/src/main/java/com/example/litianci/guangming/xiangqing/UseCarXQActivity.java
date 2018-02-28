package com.example.litianci.guangming.xiangqing;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litianci.guangming.BaseActivity;
import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.bean.CarUseResult;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UseCarXQActivity extends BaseActivity implements View.OnClickListener {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv1)
    TextView tv1;
    @Bind(R.id.tv2)
    TextView tv2;
    @Bind(R.id.tv3)
    TextView tv3;
    @Bind(R.id.tv4)
    TextView tv4;
    @Bind(R.id.tv5)
    TextView tv5;
    @Bind(R.id.tv6)
    TextView tv6;
    @Bind(R.id.tv7)
    TextView tv7;
    @Bind(R.id.tv8)
    TextView tv8;
    @Bind(R.id.tv9)
    TextView tv9;
    @Bind(R.id.tv10)
    TextView tv10;
    @Bind(R.id.tv11)
    TextView tv11;
    @Bind(R.id.tv12)
    TextView tv12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_use_car_xq);
        ButterKnife.bind(this);
        ivBack.setOnClickListener(this);
        getRequest();
    }

    public void getRequest() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"CarUseDetail\",\"Para\": {\"Id\": \"" + getIntent().getStringExtra("id") + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                CarUseResult s3 = GsonUtils.json2bean(response, CarUseResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(UseCarXQActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    tv1.setText("科室：" +s3.getRst().getList().get(0).getDeptname());
                    tv2.setText("使用人：" + s3.getRst().getList().get(0).getApplyer());
                    tv3.setText("联系电话：" + s3.getRst().getList().get(0).getLianxidianhua());
                    tv4.setText("保障范围：" + s3.getRst().getList().get(0).getSafeguardscope());
                    tv5.setText("用车事由：" + s3.getRst().getList().get(0).getVehicleincident());
                    tv6.setText("目的地：" + s3.getRst().getList().get(0).getDestination());
                    tv7.setText("办公室主管领导意见：" + s3.getRst().getList().get(0).getBgsleaderopinion());
                    tv8.setText("科室主管领导意见：" + s3.getRst().getList().get(0).getGovernoropinion());
                    tv9.setText("车牌号：" + s3.getRst().getList().get(0).getLicensenub());
                    tv10.setText("出车时间：" + s3.getRst().getList().get(0).getDeparttime());
                    tv11.setText("还车时间：" +s3.getRst().getList().get(0).getRepaytime());
                    tv12.setText("是否已还：" +s3.getRst().getList().get(0).getIsreturn());


                }
                return false;
            }
        }.volleyStringRequestPost(UseCarXQActivity.this, params, "app?", null);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
