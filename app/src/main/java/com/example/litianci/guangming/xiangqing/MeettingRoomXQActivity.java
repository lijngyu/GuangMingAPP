package com.example.litianci.guangming.xiangqing;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litianci.guangming.BaseActivity;
import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.MeettingRoomXQResult;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MeettingRoomXQActivity extends BaseActivity implements View.OnClickListener {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_dept)
    TextView tvDept;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_meettingname)
    TextView tvMeettingname;
    @Bind(R.id.tv_room)
    TextView tvRoom;
    @Bind(R.id.tv_start)
    TextView tvStart;
    @Bind(R.id.tv_end)
    TextView tvEnd;
    @Bind(R.id.tv_chld)
    TextView tvChld;
    @Bind(R.id.tv_chry)
    TextView tvChry;
    @Bind(R.id.tv_wlry)
    TextView tvWlry;
    @Bind(R.id.tv_ksfzryj)
    TextView tvKsfzryj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_meetting_room_xq);
        ButterKnife.bind(this);
        ivBack.setOnClickListener(this);
        getRequest();
    }

    public void getRequest() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"HyydD\",\"Para\": {\"Id\": \"" + getIntent().getStringExtra("id") + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                MeettingRoomXQResult s3 = GsonUtils.json2bean(response, MeettingRoomXQResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(MeettingRoomXQActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    tvDept.setText("申请部门：" + s3.getRst().getSqdeptname());
                    tvName.setText("申请人：" + s3.getRst().getScheduleer());
                    tvMeettingname.setText("会议名称：" + s3.getRst().getMeetingName());
                    tvStart.setText("开始时间：" + s3.getRst().getStarttime());
                    tvRoom.setText("会议室：" + s3.getRst().getMeetingRoom());
                    tvEnd.setText("结束时间：" + s3.getRst().getEndtime());
                    tvKsfzryj.setText("科室负责人意见：" + s3.getRst().getKsfzryj());
                    tvChld.setText("参会领导：" + s3.getRst().getJoinLeader());
                    tvChry.setText("参会人员：" + s3.getRst().getMeetingPeople());
                    tvWlry.setText("外来人员：" + s3.getRst().getOutsidePeople());



                }
                return false;
            }
        }.volleyStringRequestPost(MeettingRoomXQActivity.this, params, "app?", null);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
