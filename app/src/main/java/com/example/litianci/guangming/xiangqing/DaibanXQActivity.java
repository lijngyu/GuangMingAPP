package com.example.litianci.guangming.xiangqing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litianci.guangming.BaseActivity;
import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.adapter.CommonAdapter;
import com.example.litianci.guangming.adapter.ViewHolder;
import com.example.litianci.guangming.bean.DaibanXQResult;
import com.example.litianci.guangming.bean.LCGZResult;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.home.SelectPersonActivity;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;
import com.example.litianci.guangming.views.ListViewForScrollView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DaibanXQActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.image)
    TextView image;
    @Bind(R.id.tv_sender)
    TextView tvSender;
    @Bind(R.id.tv_receiver)
    TextView tvReceiver;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.tv_gzxq)
    TextView tvGzxq;
    @Bind(R.id.tv_gzxq2)
    TextView tvGzxq2;
    @Bind(R.id.ll_gzxq)
    LinearLayout llGzxq;
    @Bind(R.id.tv_lvgz)
    TextView tvLvgz;
    @Bind(R.id.tv_lvgz2)
    TextView tvLvgz2;
    @Bind(R.id.ll_lcgz)
    LinearLayout llLcgz;
    @Bind(R.id.webview)
    WebView webview;
    @Bind(R.id.list)
    ListViewForScrollView list;
    @Bind(R.id.tv_theme)
    TextView tvTheme;
    private List<LCGZResult.RstBean.ListBean> listDate;
    /**
     * 服务器返回的使用list显示的待办的流程跟踪信息
     */
    private CommonAdapter<LCGZResult.RstBean.ListBean> resultAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_daiban_xq);
        ButterKnife.bind(this);
        if (getIntent().getStringExtra("type").equals("待办工作")) {
            tvTitle.setText("待办工作详情");
            image.setText("待办");
            image.setBackgroundResource(R.drawable.chaoshi_bg);
        } else if (getIntent().getStringExtra("type").equals("已办工作")) {
            tvTitle.setText("已办工作详情");
            image.setText("已办");
            image.setBackgroundResource(R.drawable.yiban_bg);
        } else if (getIntent().getStringExtra("type").equals("收藏工作")) {
            tvTitle.setText("收藏工作详情");
            image.setText("收藏");
            image.setBackgroundResource(R.drawable.shoucang_bg);
        }


        ivBack.setOnClickListener(this);
        llGzxq.setOnClickListener(this);
        llLcgz.setOnClickListener(this);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i("zhang", "点击链接" + url);
                if (url.equals(Globals.MY_URL + "navigator.jsp")) {
                    Log.i("zhang", "进入返回");
                    setResult(1);
                    finish();
                }
                if (url.equals(Globals.MY_URL + "login.jsp")) {
                    Log.i("zhang", "进入返回");
                    finish();
                }

                view.loadUrl(url);
                return true;
            }
        });


        webview.setWebChromeClient(new WebChromeClient());
        //支持javascript
        webview.getSettings().setJavaScriptEnabled(true);
        // 设置可以支持缩放
        webview.getSettings().setSupportZoom(true);
        // 设置出现缩放工具
        webview.getSettings().setBuiltInZoomControls(true);
        //扩大比例的缩放
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setDomStorageEnabled(true);
        //自适应屏幕
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        final String s = Globals.MY_URL + "login.cmd" + "?usercode=" + User.sid + "&pwd=" + User.pwd;
        webview.loadUrl(s);
//
        getRequest();
        getLCGZRequest();
    }

    public void getRequest() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"DBXQ\",\"Para\":{\"Wid\":\"" + getIntent().getStringExtra("id") + "\",\"Inid\": \"" + getIntent().getStringExtra("inid") + "\",\"Sid\": \"" + User.sid + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                DaibanXQResult s3 = GsonUtils.json2bean(response, DaibanXQResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(DaibanXQActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    tvTheme.setText(s3.getRst().getList().get(0).getFn());

                    if (s3.getRst().getList().get(0).getAsna().equals("")) {
                        tvSender.setText("发：" + s3.getRst().getList().get(0).getAsna());
                    }else {
                        tvSender.setText("发：" + User.name);
                    }
                    tvReceiver.setText("收：" + s3.getRst().getList().get(0).getSpna());
                    tvTime.setText(s3.getRst().getList().get(0).getDt());
                    webview.loadUrl(s3.getRst().getList().get(0).getH5Url());
                }
                return false;
            }
        }.volleyStringRequestPost(DaibanXQActivity.this, params, "app?", null);
    }

    public void getLCGZRequest() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"Lcjk\",\"Para\":{\"Sid\":\"" + User.sid + "\",\"InstanceId\":\"" + getIntent().getStringExtra("inid") + "\"}}");
        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                LCGZResult s3 = GsonUtils.json2bean(response, LCGZResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(DaibanXQActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    listDate = s3.getRst().getList();
                    Log.i(Globals.LOG_I, "集合个数" + listDate.size());
                    resultAdapter = new CommonAdapter<LCGZResult.RstBean.ListBean>(DaibanXQActivity.this, listDate, R.layout.liuchenggenzong_item) {

                        @Override
                        public void convert(ViewHolder holder, LCGZResult.RstBean.ListBean fileMap) {
                            holder.setText(R.id.time_text, fileMap.getTime());
                            holder.setText(R.id.neirong_liucheng_text, fileMap.getNodename() + "：" + fileMap.getActionname() + "    " + fileMap.getComments());
//                        流程显示图显示和不显示
                            int flow = listDate.indexOf(fileMap);

                            if (flow == 0) {
                                //隐藏
                                holder.setVisible(R.id.shang_view, false);
                                holder.setVisible(R.id.xia_view, true);
                                holder.setImageResource(R.id.liucheng_tp, R.mipmap.lcicons);
                            } else if (flow == listDate.size() - 1) {
                                holder.setVisible(R.id.xia_view, false);
                            }


                        }
                    };

                    list.setAdapter(resultAdapter);
                }
                return false;
            }
        }.volleyStringRequestPost(DaibanXQActivity.this, params, "app?", null);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back: {
                setResult(1);
                finish();

            }
            break;
            case R.id.ll_gzxq: {
                list.setVisibility(View.GONE);
                webview.setVisibility(View.VISIBLE);
                tvGzxq.setTextColor(this.getResources().getColor(R.color.colorxqselect));
                tvGzxq2.setBackgroundResource(R.color.colorxqselect);
                tvLvgz.setTextColor(this.getResources().getColor(R.color.colorxqnoselect));
                tvLvgz2.setBackgroundResource(R.color.colorxqnoselect);
                tvLvgz2.setVisibility(View.INVISIBLE);
                tvGzxq2.setVisibility(View.VISIBLE);
            }
            break;
            case R.id.ll_lcgz: {
                webview.setVisibility(View.GONE);
                list.setVisibility(View.VISIBLE);
                tvLvgz.setTextColor(this.getResources().getColor(R.color.colorxqselect));
                tvLvgz2.setBackgroundResource(R.color.colorxqselect);
                tvGzxq.setTextColor(this.getResources().getColor(R.color.colorxqnoselect));
                tvGzxq2.setBackgroundResource(R.color.colorxqnoselect);
                tvGzxq2.setVisibility(View.INVISIBLE);
                tvLvgz2.setVisibility(View.VISIBLE);
            }
            break;
            default:
                break;
        }
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            //更新UI
            switch (msg.what) {
                case 1:
//                    updateTitle();
                    break;
            }
        }
    };

    private class JsInterface {
        private Context mContext;

        public JsInterface(Context context) {
            this.mContext = context;
        }

        //在js中调用window.AndroidWebView.showInfoFromJs(name)，便会触发此方法。
        @JavascriptInterface
        public void showInfoFromJs(String name) {
            Log.i("zhang", "showInfoFromJs1:--- " + name);
            Message message = new Message();
            message.what = 1;
            mHandler.sendMessage(message);

        }

        //在js中调用window.AndroidWebView.showInfoFromJs(name)，便会触发此方法。
        @JavascriptInterface
        public void WidFromJs(String name) {
            Log.i("zhang", "showInfoFromJs2:--- " + name);
//            wid = name;
        }
    }
}
