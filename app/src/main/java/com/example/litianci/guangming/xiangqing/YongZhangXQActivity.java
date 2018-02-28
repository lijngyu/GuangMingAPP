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
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.bean.YongzhangXQResult;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class YongZhangXQActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_dept)
    TextView tvDept;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.tv_type)
    TextView tvType;
    @Bind(R.id.tv_yzmc)
    TextView tvYzmc;
    @Bind(R.id.tv_reason)
    TextView tvReason;
    @Bind(R.id.tv_bgsspyj)
    TextView tvBgsspyj;
    @Bind(R.id.tv_zgldyj)
    TextView tvZgldyj;
    @Bind(R.id.tv_zryj)
    TextView tvZryj;
    @Bind(R.id.tv_sjyj)
    TextView tvSjyj;
    @Bind(R.id.tv_djgzkspyj)
    TextView tvDjgzkspyj;
    @Bind(R.id.tv_sealtype)
    TextView tvSealtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_yong_zhang_xq);
        ButterKnife.bind(this);
        ivBack.setOnClickListener(this);
        getRequest();
    }


    public void getRequest() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"SealD\",\"Para\": {\"Id\": \"" + getIntent().getStringExtra("id") + "\",\"Sid\": \"" + User.sid + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                YongzhangXQResult s3 = GsonUtils.json2bean(response, YongzhangXQResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(YongZhangXQActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    tvDept.setText("申请部门：" + s3.getRst().getDept());
                    tvName.setText("申请人：" + s3.getRst().getPerson());
                    tvTime.setText("申请日期：" + s3.getRst().getTime());
                    tvYzmc.setText("印章名称：" + s3.getRst().getSealName());
                    tvBgsspyj.setText("办公室审批意见：" + s3.getRst().getBgs());
                    tvReason.setText("用章原因：" + s3.getRst().getReason());
                    if (s3.getRst().getDjgzk().equals("djgzkyj")) {
                       if (s3.getRst().getSealType().equals("工委章")){
                           tvDjgzkspyj.setText("党建工作科审批意见：" + "同意");
                       }else {
                           tvDjgzkspyj.setText("党建工作科审批意见：" + "");
                       }
                    }else {
                        tvDjgzkspyj.setText("党建工作科审批意见：" + s3.getRst().getDjgzk());
                    }


                    tvZgldyj.setText("主管领导意见：" + s3.getRst().getPointleader());
                    tvZryj.setText("主任意见：" + s3.getRst().getDirector());
                    tvSjyj.setText("书记意见：" + s3.getRst().getDyak());
                    switch (s3.getRst().getSealType()) {
                        case "0": {
                            tvSealtype.setText("印章类型：办事处章");
                        }
                        break;
                        case "1": {
                            tvSealtype.setText("印章类型：工委章");
                        }
                        break;
                        default:
                            break;
                    }

                    switch (s3.getRst().getType()) {
                        case "0": {
                            tvType.setText("类别：日常办公");
                        }
                        break;
                        case "1": {
                            tvType.setText("类别：重大事项");
                        }
                        break;
                        default:
                            break;
                    }

                }
                return false;
            }
        }.volleyStringRequestPost(YongZhangXQActivity.this, params, "app?", null);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
