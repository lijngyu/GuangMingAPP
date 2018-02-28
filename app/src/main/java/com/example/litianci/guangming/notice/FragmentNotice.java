package com.example.litianci.guangming.notice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.adapter.CommonAdapter;
import com.example.litianci.guangming.adapter.ViewHolder;
import com.example.litianci.guangming.bean.NoticeResult;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.pullswipe.PullToRefreshSwipeMenuListView;
import com.example.litianci.guangming.pullswipe.pulltorefresh.RefreshTime;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @创建人：李井宇
 * @创建时间：2017.11.01
 * @用途：消息通知fragment
 */

public class FragmentNotice extends Fragment implements View.OnClickListener, PullToRefreshSwipeMenuListView.IXListViewListener, AbsListView.OnScrollListener {
    @Bind(R.id.search_et_tz)
    EditText searchEtTz;
    @Bind(R.id.gwgl_list)
    PullToRefreshSwipeMenuListView gwglList;
    @Bind(R.id.iv_search)
    ImageView ivSearch;

    private List<NoticeResult.RstBean.ListBean> firstList;
    private List<NoticeResult.RstBean.ListBean> allList = new ArrayList<>();
    private CommonAdapter<NoticeResult.RstBean.ListBean> resultAdapter;
    private NoticeResult result;

    /**
     * 控制列表中的页数
     */
    private int page = 1;
    private String TAG = "___log日志____";
    private Handler mHandler;
    private boolean flsh = false;
    private boolean isFlsh = true;
    private String string = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice, null);
        ButterKnife.bind(this, view);
        getRequest(string);
        //可以刷新  也以有左滑收藏功能的使用的listview
        searchEtTz.setHint("请输入主题");
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                string = searchEtTz.getText().toString().trim();
                page = 1;
                allList.clear();
                isFlsh = false;
                getRequest(string);
                gwglList.setSelection(0);
            }
        });
        gwglList.setPullRefreshEnable(true);
        gwglList.setPullLoadEnable(true);
        gwglList.setXListViewListener(this);
        gwglList.setOnScrollListener(this);
        gwglList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), NoticeXQActivity.class);
                intent.putExtra("id", allList.get(position - 1).getId());
                startActivity(intent);
            }
        });
        mHandler = new Handler();
        return view;
    }

    public void getRequest(String string) {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"Notice\",\"Para\": {\"Sid\": \"" + User.sid + "\",\"Search\": \"" + string + "\",\"Page\": \"" + page + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                result = GsonUtils.json2bean(response, NoticeResult.class);
                Log.i("wwwwwww", response);
                if (result == null || !(result.getStu() == 1)) {
                    Toast.makeText(getActivity(), Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    firstList = result.getRst().getList();
                    if (flsh) {
                        Log.i("我现在刷新了", "firstList" + firstList.size());
                        allList.clear();
                        allList.addAll(firstList);
                        SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault());
                        RefreshTime.setRefreshTime(getActivity(), df.format(new Date()));
                        resultAdapter.setData(firstList);
                        resultAdapter.notifyDataSetChanged();
                        gwglList.setRefreshTime(RefreshTime.getRefreshTime(getActivity()));
                        gwglList.stopRefresh();
                        gwglList.stopLoadMore();
                        flsh = false;

                    } else {

                        if (isFlsh) {
                            allList.addAll(firstList);
                            Log.i("zhang", "列表个数---第一" + firstList.size());
                            Log.i("zhang", "列表个数---第二" + allList.size());
                            resultAdapter = new CommonAdapter<NoticeResult.RstBean.ListBean>(getActivity(), firstList, R.layout.item_list_notice) {
                                @Override
                                public void convert(ViewHolder holder, NoticeResult.RstBean.ListBean testResult) {
                                    holder.setText(R.id.tv_title, testResult.getTitle()).
                                            setText(R.id.tv_dept, testResult.getPubDept()).
                                            setText(R.id.tv_time, testResult.getPubTime());

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
                                Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                                onLoad();
                            }
                        }

                    }

                }

                return false;
            }
        }.volleyStringRequestPost(getActivity(), params, "app?", null);
    }

    @Override
    public void onResume() {
        super.onResume();
        page = 1;
        Log.i("zhang", "onRefresh: ");
        flsh = false;
        isFlsh = true;

    }

    /**
     * 模拟加载更多
     */
    private void onLoad() {
        Log.i("zhang", "onLoad: ");
        gwglList.setRefreshTime(RefreshTime.getRefreshTime(getActivity()));
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
                Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
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
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {

    }
}
