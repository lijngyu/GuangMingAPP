package com.example.litianci.guangming.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litianci.guangming.BaseActivity;
import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.adapter.CommonAdapter;
import com.example.litianci.guangming.adapter.ViewHolder;
import com.example.litianci.guangming.bean.CarManageResult;
import com.example.litianci.guangming.bean.FileCirculationResult;
import com.example.litianci.guangming.bean.FileCirculationXQResult;
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

public class FileCirculationXQActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.text_title)
    TextView textTitle;
    @Bind(R.id.tv_enddate)
    TextView tvEnddate;
    @Bind(R.id.tv_days)
    TextView tvDays;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_laiwencom)
    TextView tvLaiwencom;
    @Bind(R.id.tv_docuNo)
    TextView tvDocuNo;
    @Bind(R.id.tv_laiwentime)
    TextView tvLaiwentime;
    @Bind(R.id.tv_docudescription)
    TextView tvDocudescription;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.tv_remark)
    TextView tvRemark;
    @Bind(R.id.gw_xiangqing_list)
    ListViewForScrollView gwXiangqingList;
    @Bind(R.id.lv_record)
    ListViewForScrollView lvRecord;
    @Bind(R.id.tv_readedperson)
    TextView tvReadedperson;
    @Bind(R.id.zhoujianren_text)
    TextView zhoujianrenText;
    @Bind(R.id.iamge_tianjia)
    ImageView iamgeTianjia;
    @Bind(R.id.ll_recipients)
    LinearLayout llRecipients;
    @Bind(R.id.tv_yiyue)
    TextView tvYiyue;
    @Bind(R.id.tv_agree)
    TextView tvAgree;
    @Bind(R.id.tv_show)
    TextView tvShow;
    @Bind(R.id.ksps_la)
    LinearLayout kspsLa;
    @Bind(R.id.add_content)
    EditText addContent;
    @Bind(R.id.qnps_la)
    LinearLayout qnpsLa;
    @Bind(R.id.bt_send)
    Button btSend;
    @Bind(R.id.bt_back)
    Button btBack;
    @Bind(R.id.an_la)
    LinearLayout anLa;

    private String wid = "";
    private FileCirculationResult wjcyMap;
    private List<FileCirculationXQResult.RstBean.AttachBean> fileList;
    private CommonAdapter<FileCirculationXQResult.RstBean.AttachBean> fileAdapter;
    private List<FileCirculationXQResult.RstBean.PishilistBean> recordList;
    private CommonAdapter<FileCirculationXQResult.RstBean.PishilistBean> recordAdapter;
    private List<FileCirculationXQResult.RstBean.PishilistBean.ListcontentBean> detailsList;
    private CommonAdapter<FileCirculationXQResult.RstBean.PishilistBean.ListcontentBean> detailAdapter;
    private Bundle bundle2;
    private String strFromAct2;
    private String ryid = "";
    private String xxwid;
    private String xxinid;
    private String isXuanzhong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_file_circulation_xq);
        ButterKnife.bind(this);
        textTitle.requestFocus();
        ivBack.setOnClickListener(this);

        tvAgree.setOnClickListener(this);
        tvYiyue.setOnClickListener(this);
        btSend.setOnClickListener(this);
        btBack.setOnClickListener(this);
        iamgeTianjia.setOnClickListener(this);

        getRequest();


    }

    public void getRequest() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"WjcyD\",\"Para\": {\"Id\": \"" + getIntent().getStringExtra("id") + "\",\"Sid\": \"" + User.sid + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                FileCirculationXQResult details = GsonUtils.json2bean(response, FileCirculationXQResult.class);
                Log.i("wwwwwww", response);
                if (details == null || !(details.getStu() == 1)) {
                    Toast.makeText(FileCirculationXQActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    tvTitle.setText("文件标题：" + details.getRst().getTitle());
                    tvEnddate.setText("时限要求：" + details.getRst().getRequest());
                    tvDocuNo.setText("文件编号：" + details.getRst().getWenhao());
                    tvLaiwencom.setText("来文单位：" + details.getRst().getUnit());
                    tvLaiwentime.setText("来文时间：" + details.getRst().getTime());

                    tvDocudescription.setText(details.getRst().getSketch());
                    tvRemark.setText(details.getRst().getBeizhu());
                    tvReadedperson.setText(details.getRst().getYichuanyue());
//                    addContent.setText(details.getRst().get);

                    if (getIntent().getStringExtra("state").equals("1")) {

                        if (User.ISKY.equals("0")) {
                            llRecipients.setVisibility(View.GONE);
                            kspsLa.setVisibility(View.GONE);
                            qnpsLa.setVisibility(View.GONE);
                            btSend.setVisibility(View.GONE);
                        }
                    } else {

                        llRecipients.setVisibility(View.GONE);
                        kspsLa.setVisibility(View.GONE);
                        qnpsLa.setVisibility(View.GONE);
                        btSend.setVisibility(View.GONE);
                    }

                    if (details.getDays().contains("剩余")) {
                        tvDays.setText(details.getDays());
                        if (Integer.parseInt(details.getDays()) < 3) {
                            tvDays.setBackgroundResource(R.mipmap.yellow);
                        }

                    } else {
                        tvDays.setText(details.getDays());
                        tvDays.setBackgroundResource(R.mipmap.timebgred);

                    }


                    /**
                     * 附件列表
                     */

                    fileList = details.getRst().getAttach();
                    fileAdapter = new CommonAdapter<FileCirculationXQResult.RstBean.AttachBean>(FileCirculationXQActivity.this, fileList, R.layout.wjcy_xia_zai_item) {
                        @Override
                        public void convert(ViewHolder holder, FileCirculationXQResult.RstBean.AttachBean ceshi) {
                            //添加文字
                            holder.setText(R.id.xiazai_item_dx, ceshi.getAttachName());
                            AppUtil.wenjianDivision("", ceshi.getAttachName(), ceshi.getAttachUrl());

                            final String filename = AppUtil.wenjianDivision("", ceshi.getAttachName(), ceshi.getAttachUrl());
                            Log.i("zhang______", "我的文件名字" + filename);
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
                                        FileCirculationXQActivity.this.startActivity(intent);
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
                            XiaZaiUtil xiaZaiUtil = new XiaZaiUtil(holder.<ImageButton>getView(R.id.xiazai_iamge_button), FileCirculationXQActivity.this, ceshi.getAttachUrl(), holder.<MasterLayout>getView(R.id.xiazai_zx), holder.<TextView>getView(R.id.xiazai_sudu), filename, "");
//                        Log.i("zhang", ceshi.getFt());

                            String ft = ceshi.getAttachName();
                            if (ft.equals("doc") || ft.equals("docx")) {
                                holder.setImageResource(R.id.xiazai_item_tp, R.mipmap.word);

                            } else if (ft.equals("xls") || ft.equals("xlsx")) {
                                holder.setImageResource(R.id.xiazai_item_tp, R.mipmap.excel);
                            } else if (ft.equals("png")) {
                                holder.setImageResource(R.id.xiazai_item_tp, R.mipmap.png);
                            } else if (ft.equals("txt")) {
                                holder.setImageResource(R.id.xiazai_item_tp, R.mipmap.txt);
                            } else if (ft.equals("pdf")) {
                                holder.setImageResource(R.id.xiazai_item_tp, R.mipmap.pdf);
                            } else if (ft.equals("ppt") || ft.equals("pptx")) {
                                holder.setImageResource(R.id.xiazai_item_tp, R.mipmap.ppt);
                            }
                        }
                    };
                    //给list添加数据
                    gwXiangqingList.setAdapter(fileAdapter);
                    /**********************************************************************************************/
                    recordList = details.getRst().getPishilist();
                    if (recordList == null) {
                        lvRecord.setVisibility(View.GONE);
                    } else {
                        recordAdapter = new CommonAdapter<FileCirculationXQResult.RstBean.PishilistBean>(FileCirculationXQActivity.this, recordList, R.layout.item_list_record) {
                            @Override
                            public void convert(ViewHolder holder, FileCirculationXQResult.RstBean.PishilistBean ceshi) {
                                if (ceshi.getFasongname().length() == 2) {
                                    holder.setText(R.id.tv_name, ceshi.getFasongname().substring(0, 1) + "  " + ceshi.getFasongname().substring(1) + "：");
                                } else {
                                    holder.setText(R.id.tv_name, ceshi.getFasongname() + "：");
                                }
                                ListViewForScrollView lv_detail = holder.getView(R.id.lv_recorddetail);
                                detailsList = ceshi.getListcontent();
                                detailAdapter = new CommonAdapter<FileCirculationXQResult.RstBean.PishilistBean.ListcontentBean>(FileCirculationXQActivity.this, detailsList, R.layout.item_list_detail) {
                                    @Override
                                    public void convert(ViewHolder holder, FileCirculationXQResult.RstBean.PishilistBean.ListcontentBean ceshi) {
                                        TextView textView = (TextView) holder.getView(R.id.tv_cotent);
                                        textView.setText(Html.fromHtml(ceshi.getContent()));

                                        holder.setText(R.id.tv_time, ceshi.getTime());
                                    }
                                };
                                lv_detail.setAdapter(detailAdapter);


                            }
                        };

                        lvRecord.setAdapter(recordAdapter);
                    }

                }
                return false;
            }
        }.volleyStringRequestPost(FileCirculationXQActivity.this, params, "app?", null);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_agree: {
                addContent.setText("同意    " + tvShow.getText().toString().trim());
            }
            break;
            case R.id.tv_yiyue: {
                addContent.setText("已阅    " + tvShow.getText().toString().trim());
            }
            break;
              /*添加发送人*/
            case R.id.iamge_tianjia:
                Intent intent1 = new Intent();
                intent1.putExtra("bzf", "WjcySelPeople");
                intent1.setClass(FileCirculationXQActivity.this, SelectPersonActivity.class);
                startActivityForResult(intent1, 0);
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_back:
                finish();
                break;
            case R.id.bt_send:
                if (addContent.getText().toString().trim().equals("")) {
                    Toast.makeText(FileCirculationXQActivity.this, "批注不能为空。", Toast.LENGTH_SHORT).show();
                } else {
                    fsRequest();
                }
                break;
            default:
                break;
        }
    }

    /*获得返回的文件路径和名字*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (0 == requestCode && resultCode == 2) {
            if (!(data == null)) {
//                bundle2 = data.getBundleExtra("bundle2");
                strFromAct2 = data.getStringExtra("strResult");
                ryid = data.getStringExtra("strResult2");
                zhoujianrenText.setText(strFromAct2);
            }
        }
    }

    //发送请求接口
    public void fsRequest() {
        if (ryid == null) {
            Toast.makeText(this, "请选择传阅人员", Toast.LENGTH_LONG).show();
        } else {
            Map<String, String> params = new HashMap<String, String>();
            params.put(Globals.WS_POST_KEY, "{\"Ac\": \"SendWjcy\",\"Para\": {\"Sid\": \"" + User.sid + "\",\"Id\": \"" + getIntent().getStringExtra("id") + "\",\"Content\": \"" + addContent.getText().toString().trim() + "\",\"NewPeople\": \"" + ryid + "\",\"Yichuanyue\": \"" + tvReadedperson.getText().toString().trim() + "\"}}");

            new VolleyUtil() {

                @Override
                public <T> boolean analysisData(String response) {
                    CarManageResult s3 = GsonUtils.json2bean(response, CarManageResult.class);
                    Log.i("wwwwwww", response);
                    if (s3 == null || !(s3.getStu() == 1)) {
                        Toast.makeText(FileCirculationXQActivity.this, Globals.SER_ERROR,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(FileCirculationXQActivity.this, s3.getRst().getMsg(),
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    return false;
                }
            }.volleyStringRequestPost(FileCirculationXQActivity.this, params, "app?", null);
        }


    }
}
