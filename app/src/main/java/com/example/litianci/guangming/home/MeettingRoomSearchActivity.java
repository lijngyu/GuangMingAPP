package com.example.litianci.guangming.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.litianci.guangming.BaseActivity;
import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.adapter.CommonAdapter;
import com.example.litianci.guangming.adapter.ViewHolder;
import com.example.litianci.guangming.bean.MeettingRoomResult;
import com.example.litianci.guangming.pullswipe.PullToRefreshSwipeMenuListView;
import com.example.litianci.guangming.pullswipe.pulltorefresh.RefreshTime;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;
import com.example.litianci.guangming.xiangqing.MeettingRoomXQActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MeettingRoomSearchActivity extends BaseActivity implements PullToRefreshSwipeMenuListView.IXListViewListener, AbsListView.OnScrollListener {

    @Bind(R.id.gwgl_list)
    PullToRefreshSwipeMenuListView gwglList;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    private List<MeettingRoomResult.RstBean.ListBean> firstList;
    private List<MeettingRoomResult.RstBean.ListBean> allList = new ArrayList<>();
    private CommonAdapter<MeettingRoomResult.RstBean.ListBean> resultAdapter;
    private MeettingRoomResult result;

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
        setContentView(R.layout.activity_meetting_room_search);
        ButterKnife.bind(this);
        //可以刷新  也以有左滑收藏功能的使用的listview
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        gwglList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MeettingRoomSearchActivity.this, MeettingRoomXQActivity.class);
                intent.putExtra("id", allList.get(position - 1).getId());
                startActivity(intent);
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
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"HyydL\",\"Para\": {\"Page\": \"" + page + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                result = GsonUtils.json2bean(response, MeettingRoomResult.class);
                Log.i("wwwwwww", response);
                if (result == null || (result.getStu() != 1)) {
                    Toast.makeText(MeettingRoomSearchActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    firstList = result.getRst().getList();
                    if (flsh) {
                        Log.i("我现在刷新了", "firstList" + firstList.size());
                        allList.clear();
                        allList.addAll(firstList);
                        SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault());
                        RefreshTime.setRefreshTime(MeettingRoomSearchActivity.this, df.format(new Date()));
                        resultAdapter.setData(firstList);
                        resultAdapter.notifyDataSetChanged();
                        gwglList.setRefreshTime(RefreshTime.getRefreshTime(MeettingRoomSearchActivity.this));
                        gwglList.stopRefresh();
                        gwglList.stopLoadMore();
                        flsh = false;

                    } else {

                        if (isFlsh) {
                            allList.clear();
                            allList.addAll(firstList);
                            Log.i("zhang", "列表个数---第一" + firstList.size());
                            Log.i("zhang", "列表个数---第二" + allList.size());
                            resultAdapter = new CommonAdapter<MeettingRoomResult.RstBean.ListBean>(MeettingRoomSearchActivity.this, firstList, R.layout.item_list_meetingnotice) {
                                @Override
                                public void convert(ViewHolder holder, MeettingRoomResult.RstBean.ListBean testResult) {
                                    holder.setText(R.id.tv_title, testResult.getMeetingName()).
                                            setText(R.id.tv_sender, testResult.getScheduleer()).
                                            setText(R.id.tv_time, testResult.getStarttime() + "——" + testResult.getEndtime());
                                    switch (testResult.getState()) {
                                        case "0": {
                                            holder.setImageResource(R.id.image, R.mipmap.shenpizhong);
                                        }
                                        break;
                                        case "5": {
                                            holder.setImageResource(R.id.image, R.mipmap.yiyuding);
                                        }
                                        break;
                                        default:
                                            break;
                                    }

                                }
                            };
                            gwglList.setAdapter(resultAdapter);
                        } else {
                            if (firstList != null || firstList.size() != 0) {
                                Log.i("zhang", "列表个数size---一————" + firstList.size());
                                allList.addAll(firstList);
                                Log.i("zhang", "列表个数size---二————" + allList.size());
                                resultAdapter.setData(allList);
                                resultAdapter.notifyDataSetChanged();
                                onLoad();
                            } else {
                                Toast.makeText(MeettingRoomSearchActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                                onLoad();
                            }
                        }

                    }

                }

                return false;
            }
        }.volleyStringRequestPost(MeettingRoomSearchActivity.this, params, "app?", null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        page = 1;
        Log.i("zhang", "onRefresh: ");
        flsh = false;
        isFlsh = true;
        getRequest(string);

    }

    /**
     * 模拟加载更多
     */
    private void onLoad() {
        Log.i("zhang", "onLoad: ");
        gwglList.setRefreshTime(RefreshTime.getRefreshTime(MeettingRoomSearchActivity.this));
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
            if (allList.size() > 9) {
                page++;

                isFlsh = false;
                getRequest(string);

            } else {
                Toast.makeText(MeettingRoomSearchActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
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

}
