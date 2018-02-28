package com.example.litianci.guangming.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litianci.guangming.BaseActivity;
import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.adapter.CommonAdapter;
import com.example.litianci.guangming.adapter.ViewHolder;
import com.example.litianci.guangming.bean.MsgcenterResult;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.notice.NoticeXQActivity;
import com.example.litianci.guangming.pullswipe.PullToRefreshSwipeMenuListView;
import com.example.litianci.guangming.pullswipe.pulltorefresh.RefreshTime;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;
import com.example.litianci.guangming.xiangqing.DaibanXQActivity;
import com.example.litianci.guangming.xiangqing.DataXQActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MsgCenterActivity extends BaseActivity implements PullToRefreshSwipeMenuListView.IXListViewListener, AbsListView.OnScrollListener, View.OnClickListener {

    @Bind(R.id.gwgl_list)
    PullToRefreshSwipeMenuListView gwglList;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_biaoji)
    TextView tvBiaoji;
    @Bind(R.id.tv_weidu)
    TextView tvWeidu;
    @Bind(R.id.tv_yidu)
    TextView tvYidu;
    @Bind(R.id.tv_quanbu)
    TextView tvQuanbu;
    @Bind(R.id.ll_line1)
    LinearLayout llLine1;
    @Bind(R.id.ll_line2)
    LinearLayout llLine2;
    @Bind(R.id.ll_line3)
    LinearLayout llLine3;
    private List<MsgcenterResult.RstBean.ListBean> firstList;
    private List<MsgcenterResult.RstBean.ListBean> allList = new ArrayList<>();
    private CommonAdapter<MsgcenterResult.RstBean.ListBean> resultAdapter;
    private MsgcenterResult result;

    /**
     * 控制列表中的页数
     */
    private int page = 1;
    private String TAG = "___log日志____";
    private Handler mHandler;
    private boolean flsh = false;
    private boolean isFlsh = true;
    private String string = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_msg_center);
        ButterKnife.bind(this);
        //可以刷新  也以有左滑收藏功能的使用的listview
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvBiaoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Allbiaoji();
            }
        });
        tvYidu.setOnClickListener(this);
        tvWeidu.setOnClickListener(this);
        tvQuanbu.setOnClickListener(this);
        gwglList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                switch (allList.get(position - 1).getTypename()) {
                    case "资料传送": {
                        intent.setClass(MsgCenterActivity.this, DataXQActivity.class);
                        intent.putExtra("ac", "SzlD");
                        intent.putExtra("id", allList.get(position - 1).getRid());
                        startActivity(intent);
                    }
                    break;
                    case "待办工作": {
                        intent.setClass(MsgCenterActivity.this, DaibanXQActivity.class);
                        intent.putExtra("type", "待办工作");
                        intent.putExtra("id", allList.get(position - 1).getWid());
                        intent.putExtra("inid", allList.get(position - 1).getInid());
                        startActivity(intent);
                    }
                    break;
                    case "会议通知": {
                        intent.setClass(MsgCenterActivity.this, NoticeXQActivity.class);
                        intent.putExtra("id", allList.get(position - 1).getRid());
                        startActivity(intent);
                    }
                    break;
                    case "事项通知": {
                        intent.setClass(MsgCenterActivity.this, NoticeXQActivity.class);
                        intent.putExtra("id", allList.get(position - 1).getRid());
                        startActivity(intent);
                    }
                    break;
                    case "通知公告": {
                        intent.setClass(MsgCenterActivity.this, NoticeXQActivity.class);
                        intent.putExtra("id", allList.get(position - 1).getRid());
                        startActivity(intent);
                    }
                    break;
                    case "文件传阅": {
                        intent.setClass(MsgCenterActivity.this, FileCirculationXQActivity.class);
                        intent.putExtra("id", allList.get(position - 1).getRid());
                        intent.putExtra("state","1");
                        startActivity(intent);
                    }
                    break;
                    default:
                        break;
                }




            }
        });
        gwglList.setPullRefreshEnable(true);
        gwglList.setPullLoadEnable(true);
        gwglList.setXListViewListener(this);
        gwglList.setOnScrollListener(this);
        mHandler = new Handler();
    }

    public void getRequest(String string) {
        Map<String, String> params = new HashMap<String, String>();
        if (!string.equals("")) {
            params.put(Globals.WS_POST_KEY, "{\"Ac\": \"Msg\",\"Para\": {\"Sid\": \"" + User.sid + "\",\"Page\": \"" + page + "\",\"Isread\":\"" + string + "\"}}");
        } else {
            params.put(Globals.WS_POST_KEY, "{\"Ac\": \"Msg\",\"Para\": {\"Sid\": \"" + User.sid + "\",\"Page\": \"" + page + "\"}}");
        }


        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                result = GsonUtils.json2bean(response, MsgcenterResult.class);
                Log.i("wwwwwww", response);
                if (result == null || !(result.getStu() == 1)) {
                    Toast.makeText(MsgCenterActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    firstList = result.getRst().getList();
                    if (flsh) {
                        Log.i("我现在刷新了", "firstList" + firstList.size());
                        allList.clear();
                        allList.addAll(firstList);
                        SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault());
                        RefreshTime.setRefreshTime(MsgCenterActivity.this, df.format(new Date()));
                        resultAdapter.setData(firstList);
                        resultAdapter.notifyDataSetChanged();
                        gwglList.setRefreshTime(RefreshTime.getRefreshTime(MsgCenterActivity.this));
                        gwglList.stopRefresh();
                        gwglList.stopLoadMore();
                        flsh = false;

                    } else {

                        if (isFlsh) {
                            allList.clear();
                            allList.addAll(firstList);
                            Log.i("zhang", "列表个数---第一" + firstList.size());
                            Log.i("zhang", "列表个数---第二" + allList.size());
                            resultAdapter = new CommonAdapter<MsgcenterResult.RstBean.ListBean>(MsgCenterActivity.this, firstList, R.layout.item_list_msgcenter) {
                                @Override
                                public void convert(ViewHolder holder, MsgcenterResult.RstBean.ListBean testResult) {
                                    holder.setText(R.id.tv_date, testResult.getDate()).
                                            setText(R.id.tv_title, testResult.getTitle()).
                                            setText(R.id.tv_msgtype, testResult.getTypename()).
                                            setText(R.id.tv_sender, "发：" + testResult.getSendcode()).
                                            setText(R.id.tv_time, testResult.getTime());
                                    if (testResult.getIsread().equals("未读")) {
                                        holder.setImageResource(R.id.iv_statu, R.mipmap.weidu);
                                    } else {
                                        holder.setImageResource(R.id.iv_statu, R.mipmap.yidu);
                                    }
                                }
                            };
                            gwglList.setAdapter(resultAdapter);
                        } else {
                            if (firstList.size() != 0) {
                                Log.i("zhang", "列表个数size---一————" + firstList.size());
                                allList.addAll(firstList);
                                Log.i("zhang", "列表个数size---二————" + allList.size());
                                resultAdapter.setData(allList);
                                resultAdapter.notifyDataSetChanged();
                                onLoad();
                            } else {
                                Toast.makeText(MsgCenterActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                                onLoad();
                            }
                        }

                    }

                }

                return false;
            }
        }.volleyStringRequestPost(MsgCenterActivity.this, params, "app?", null);
    }

    public void Allbiaoji() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"ChangeRead\",\"Para\": {\"Sid\": \"" + User.sid + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                result = GsonUtils.json2bean(response, MsgcenterResult.class);
                Log.i("wwwwwww", response);
                if (result == null || !(result.getStu() == 1)) {
                    Toast.makeText(MsgCenterActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    page = 1;
                    Log.i("zhang", "onRefresh: ");
                    flsh = false;
                    isFlsh = true;
                    allList.clear();
                    getRequest(string);
                    Toast.makeText(MsgCenterActivity.this, "全部改为已读",
                            Toast.LENGTH_SHORT).show();

                }

                return false;
            }
        }.volleyStringRequestPost(MsgCenterActivity.this, params, "app?", null);
    }

    @Override
    protected void onResume() {

        page = 1;
        Log.i("zhang", "onRefresh: ");
        flsh = false;
        isFlsh = true;
        getRequest(string);
        super.onResume();

    }

    /**
     * 模拟加载更多
     */
    private void onLoad() {
        Log.i("zhang", "onLoad: ");
        gwglList.setRefreshTime(RefreshTime.getRefreshTime(MsgCenterActivity.this));
        gwglList.stopRefresh();
        gwglList.stopLoadMore();

    }

    @Override
    public void onRefresh() {
        page = 1;
        Log.i("zhang", "onRefresh: ");
        flsh = true;
        isFlsh = true;
        getRequest(string);
    }

    @Override
    public void onLoadMore() {

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoad();
            }
        }, 2000);
        if (page == 1) {
            if (allList.size() > 2) {
                page++;

                isFlsh = false;
                getRequest(string);

            } else {
                Toast.makeText(MsgCenterActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
            }
        }

    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
            // 判断是否滚动到底部
            if (view.getLastVisiblePosition() == view.getCount() - 1) {
                //加载更多功能的代码

                Log.i("zhang", "onLoadMore: flsh" + flsh + "allList.size()" + allList.size());
                if (flsh) {

                } else {

                    if (allList.size() > 9) {

                        page++;

                        isFlsh = false;
                        getRequest(string);
                    }
                }
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_weidu: {
                tvWeidu.setTextColor(getResources().getColor(R.color.colorwhite));
                llLine1.setVisibility(View.VISIBLE);
                tvYidu.setTextColor(getResources().getColor(R.color.msgcenternoselect));
                llLine2.setVisibility(View.INVISIBLE);
                tvQuanbu.setTextColor(getResources().getColor(R.color.msgcenternoselect));
                llLine3.setVisibility(View.INVISIBLE);
                string = "0";
                page = 1;
                Log.i("zhang", "onRefresh: ");
                flsh = false;
                isFlsh = true;
                allList.clear();
                getRequest("0");
            }
            break;
            case R.id.tv_yidu: {
                tvWeidu.setTextColor(getResources().getColor(R.color.msgcenternoselect));
                llLine1.setVisibility(View.INVISIBLE);
                tvYidu.setTextColor(getResources().getColor(R.color.colorwhite));
                llLine2.setVisibility(View.VISIBLE);
                tvQuanbu.setTextColor(getResources().getColor(R.color.msgcenternoselect));
                llLine3.setVisibility(View.INVISIBLE);
                string = "1";
                page = 1;
                Log.i("zhang", "onRefresh: ");
                flsh = false;
                isFlsh = true;
                allList.clear();
                getRequest("1");
            }
            break;
            case R.id.tv_quanbu: {
                tvWeidu.setTextColor(getResources().getColor(R.color.msgcenternoselect));
                llLine1.setVisibility(View.INVISIBLE);
                tvYidu.setTextColor(getResources().getColor(R.color.msgcenternoselect));
                llLine2.setVisibility(View.INVISIBLE);
                tvQuanbu.setTextColor(getResources().getColor(R.color.colorwhite));
                llLine3.setVisibility(View.VISIBLE);
                string = "";
                page = 1;
                Log.i("zhang", "onRefresh: ");
                flsh = false;
                isFlsh = true;
                allList.clear();
                getRequest("");
            }
            break;
            default:
                break;
        }
    }
}
