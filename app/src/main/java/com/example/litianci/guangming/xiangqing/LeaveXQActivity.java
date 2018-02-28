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
import com.example.litianci.guangming.bean.LeaveXQResult;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LeaveXQActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_dept)
    TextView tvDept;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_type)
    TextView tvType;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.tv_start)
    TextView tvStart;
    @Bind(R.id.tv_days)
    TextView tvDays;
    @Bind(R.id.tv_reason)
    TextView tvReason;
    @Bind(R.id.tv_ksfzryj)
    TextView tvKsfzryj;
    @Bind(R.id.tv_zgfzyj)
    TextView tvZgfzyj;
    @Bind(R.id.tv_zryj)
    TextView tvZryj;
    @Bind(R.id.tv_sjyj)
    TextView tvSjyj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_leave_xq);
        ButterKnife.bind(this);
        ivBack.setOnClickListener(this);
        getRequest();
    }

    public void getRequest() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"LeaveD\",\"Para\": {\"Id\": \"" + getIntent().getStringExtra("id") + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                LeaveXQResult s3 = GsonUtils.json2bean(response, LeaveXQResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(LeaveXQActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    tvDept.setText("申请部门：" + s3.getRst().getDeptname());
                    tvName.setText("申请人：" + s3.getRst().getUsername());
                    tvTime.setText("申请日期：" + s3.getRst().getApplyday());
                    tvStart.setText("开始日期：" + s3.getRst().getCount());
                    tvDays.setText("请假天数：" + s3.getRst().getNjdays());
                    tvReason.setText("请假原因：" + s3.getRst().getCause());
                    tvKsfzryj.setText("科室负责人意见：" + s3.getRst().getOfficeIdea());
                    tvZgfzyj.setText("主管副职意见：" + s3.getRst().getLeaderIdea());
                    tvZryj.setText("主任意见：" + s3.getRst().getDirectorIdea());
                    tvSjyj.setText("书记意见：" + s3.getRst().getDyakIdea());
                    switch (s3.getRst().getType()) {
                        case "0": {
                            tvType.setText("请假类型：年假");
                        }
                        break;
                        case "1": {
                            tvType.setText("请假类型：事假");
                        }
                        break;
                        case "2": {
                            tvType.setText("请假类型：病假");
                        }
                        break;
                        case "3": {
                            tvType.setText("请假类型：婚假");
                        }
                        break;
                        case "4": {
                            tvType.setText("请假类型：产假");
                        }
                        break;
                        case "5": {
                            tvType.setText("请假类型：丧假");
                        }
                        break;
                        default:
                            break;
                    }

                }
                return false;
            }
        }.volleyStringRequestPost(LeaveXQActivity.this, params, "app?", null);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
