package com.example.litianci.guangming.notice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litianci.guangming.BaseActivity;
import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.adapter.CommonAdapter;
import com.example.litianci.guangming.adapter.ViewHolder;
import com.example.litianci.guangming.bean.NoticeXQResult;
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

public class NoticeXQActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_content)
    WebView tvContent;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.tv_sender)
    TextView tvSender;
    @Bind(R.id.fujian_list)
    ListViewForScrollView fujianList;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    private List<NoticeXQResult.RstBean.AttListBean> fileList;
    private CommonAdapter<NoticeXQResult.RstBean.AttListBean> fileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_notice_xq);
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
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"NoticeD\",\"Para\": {\"Id\": \"" + getIntent().getStringExtra("id") + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                NoticeXQResult s3 = GsonUtils.json2bean(response, NoticeXQResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(NoticeXQActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    tvContent.loadDataWithBaseURL(null, s3.getRst().getList().get(0).getDetails(), "text/html", "UTF-8", null);
                    tvSender.setText(s3.getRst().getList().get(0).getName());
                    tvTitle.setText(s3.getRst().getList().get(0).getTitle());
                    tvTime.setText(s3.getRst().getList().get(0).getPubTime());
/**
 * 附件列表
 */

                    fileList = s3.getRst().getAttList();
                    Log.i("zhang______________", "附件个数: " + fileList.size());
                    fileAdapter = new CommonAdapter<NoticeXQResult.RstBean.AttListBean>(NoticeXQActivity.this, fileList, R.layout.wjcy_xia_zai_item) {
                        @Override
                        public void convert(ViewHolder holder, NoticeXQResult.RstBean.AttListBean ceshi) {
                            //添加文字
                            holder.setText(R.id.xiazai_item_dx, ceshi.getFileName());
                            AppUtil.wenjianDivision("", ceshi.getFileName(), ceshi.getUrl());

                            final String filename = AppUtil.wenjianDivision("", ceshi.getFileName(), ceshi.getUrl());
                            Log.i("zhang______", "我的文件名字" + filename);
                            Log.i("zhang______________", "下载地址: " + ceshi.getUrl());

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
                                        NoticeXQActivity.this.startActivity(intent);
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
                            XiaZaiUtil xiaZaiUtil = new XiaZaiUtil(holder.<ImageButton>getView(R.id.xiazai_iamge_button), NoticeXQActivity.this, ceshi.getUrl(), holder.<MasterLayout>getView(R.id.xiazai_zx), holder.<TextView>getView(R.id.xiazai_sudu), filename, "");
//                        Log.i("zhang", ceshi.getFt());

                            String ft = ceshi.getFileName();
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
        }.volleyStringRequestPost(NoticeXQActivity.this, params, "app?", null);
    }
}
