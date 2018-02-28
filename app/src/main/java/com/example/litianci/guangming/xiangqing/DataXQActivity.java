package com.example.litianci.guangming.xiangqing;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litianci.guangming.BaseActivity;
import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.adapter.CommonAdapter;
import com.example.litianci.guangming.adapter.ViewHolder;
import com.example.litianci.guangming.bean.ReceiveDataXQResult;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;
import com.example.litianci.guangming.utils.XiaZaiUtil;
import com.example.litianci.guangming.views.ListViewForScrollView;
import com.example.litianci.guangming.views.MasterLayout;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DataXQActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_dept)
    TextView tvDept;
    @Bind(R.id.tv_sender)
    TextView tvSender;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.fujian_list)
    ListViewForScrollView fujianList;
    private List<ReceiveDataXQResult.RstBean.AttachmentBean> fileList;
    private CommonAdapter<ReceiveDataXQResult.RstBean.AttachmentBean> fileAdapter;
    ReceiveDataXQResult result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_data_xq);
        ButterKnife.bind(this);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getRequest();

    }

    public void getRequest() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \""+getIntent().getStringExtra("ac")+"\",\"Para\": {\"Id\": \"" + getIntent().getStringExtra("id") + "\",\"Sid\": \"" + User.sid + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                result = GsonUtils.json2bean(response, ReceiveDataXQResult.class);
                if (result == null || (result.getStu() != 1)) {
                    Toast.makeText(DataXQActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    tvContent.setText(result.getRst().getBody());
                    tvSender.setText(result.getRst().getName());
                    tvTitle.setText(result.getRst().getTheme());
                    tvTime.setText(result.getRst().getTime());
                    if (getIntent().getStringExtra("ac").equals("YfsDY")){
                        tvDept.setText("收件人");
                    }else {
                        tvDept.setText(result.getRst().getDept());
                    }


                    fileList = result.getRst().getAttachment();
                    Log.i("zhang______________", "附件个数: " + fileList.size());
                    fileAdapter = new CommonAdapter<ReceiveDataXQResult.RstBean.AttachmentBean>(DataXQActivity.this, fileList, R.layout.wjcy_xia_zai_item) {
                        @Override
                        public void convert(ViewHolder holder, ReceiveDataXQResult.RstBean.AttachmentBean ceshi) {
                            //添加文字
                            holder.setText(R.id.xiazai_item_dx, ceshi.getAttachName());
                            AppUtil.wenjianDivision("", ceshi.getAttachName(), ceshi.getAttachUrl());

                            final String filename = AppUtil.wenjianDivision("", ceshi.getAttachName(), ceshi.getAttachUrl());
                            Log.i("zhang______", "我的文件名字" + filename);
                            Log.i("zhang______________", "下载地址: " + ceshi.getAttachUrl());

                            if (AppUtil.fileIsExists(Environment.getExternalStorageDirectory() + "/zhtzwj/" + filename)) {
                                ImageButton imagebutton = holder.<ImageButton>getView(R.id.xiazai_iamge_button);
                                MasterLayout masterLayout = holder.<MasterLayout>getView(R.id.xiazai_zx);
                                TextView textView = holder.<TextView>getView(R.id.xiazai_sudu);
                                masterLayout.setVisibility(View.GONE);
                                imagebutton.setVisibility(View.VISIBLE);
                                imagebutton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = AppUtil.getFileIntent(new File(Environment.getExternalStorageDirectory() + "/zhtzwj/" + filename));
                                        DataXQActivity.this.startActivity(intent);
                                    }
                                });
                                textView.setVisibility(View.GONE);
//                            Log.i("zhang", "有文件");

                            } else {
                                ImageButton imagebutton = holder.<ImageButton>getView(R.id.xiazai_iamge_button);
                                MasterLayout masterLayout = holder.<MasterLayout>getView(R.id.xiazai_zx);
                                TextView textView = holder.<TextView>getView(R.id.xiazai_sudu);
                                masterLayout.setVisibility(View.VISIBLE);
                                imagebutton.setVisibility(View.GONE);
                                textView.setVisibility(View.VISIBLE);
                                Log.i("zhang", "没有文件");
                            }

                            //下载动画效果的帮助类  完成动态下载的效果
                            XiaZaiUtil xiaZaiUtil = new XiaZaiUtil(holder.<ImageButton>getView(R.id.xiazai_iamge_button), DataXQActivity.this, ceshi.getAttachUrl(), holder.<MasterLayout>getView(R.id.xiazai_zx), holder.<TextView>getView(R.id.xiazai_sudu), filename, "");
//                        Log.i("zhang", ceshi.getFt());

                            String ft = ceshi.getAttachName();
                            if (ft.contains("doc") || ft.contains("docx")) {
                                holder.setImageResource(R.id.xiazai_item_tp, R.mipmap.word);

                            } else if (ft.contains("xls") || ft.contains("xlsx")) {
                                holder.setImageResource(R.id.xiazai_item_tp, R.mipmap.excel);
                            } else if (ft.contains("png")) {
                                holder.setImageResource(R.id.xiazai_item_tp, R.mipmap.png);
                            } else if (ft.contains("txt")) {
                                holder.setImageResource(R.id.xiazai_item_tp, R.mipmap.txt);
                            } else if (ft.contains("pdf")) {
                                holder.setImageResource(R.id.xiazai_item_tp, R.mipmap.pdf);
                            } else if (ft.contains("ppt") || ft.contains("pptx")) {
                                holder.setImageResource(R.id.xiazai_item_tp, R.mipmap.ppt);
                            }
                        }
                    };
                    fujianList.setAdapter(fileAdapter);


                }
                return false;
            }
        }.volleyStringRequestPost(DataXQActivity.this, params, "app?", null);
    }
}
