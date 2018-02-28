package com.example.litianci.guangming.my;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.adapter.CommonAdapter;
import com.example.litianci.guangming.adapter.ViewHolder;
import com.example.litianci.guangming.bean.LeaveResult;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.pullswipe.PullToRefreshSwipeMenuListView;
import com.example.litianci.guangming.pullswipe.pulltorefresh.RefreshTime;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;
import com.example.litianci.guangming.xiangqing.LeaveXQActivity;
import com.fourmob.datetimepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyLeaveActivity extends FragmentActivity implements PullToRefreshSwipeMenuListView.IXListViewListener, AbsListView.OnScrollListener, TextView.OnEditorActionListener ,DatePickerDialog.OnDateSetListener{

    @Bind(R.id.search_et_tz)
    EditText searchEtTz;
    @Bind(R.id.gwgl_list)
    PullToRefreshSwipeMenuListView gwglList;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    private List<LeaveResult.RstBean.ListBean> firstList;
    private List<LeaveResult.RstBean.ListBean> allList = new ArrayList<>();
    private CommonAdapter<LeaveResult.RstBean.ListBean> resultAdapter;
    private LeaveResult result;

    /**
     * 控制列表中的页数
     */
    private int page = 1;
    private String TAG = "___log日志____";
    private Handler mHandler;
    private boolean flsh = false;
    private boolean isFlsh = true;
    private String string = "";
    /**
     * 用户预定会议的时候选择日期
     */
    final Calendar calendar = Calendar.getInstance();
    final DatePickerDialog datePickerDialog = DatePickerDialog.newInstance((DatePickerDialog.OnDateSetListener) this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), true);
    public static final String DATEPICKER_TAG = "datepicker";
    /**
     * 获得的月
     */
    private String acquisitionMoth;
    /**
     * 获得的日
     */
    private String acquisitionDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_meetting_send);
        ButterKnife.bind(this);
        tvTitle.setText("我的请假");
        searchEtTz.setHint("请选择申请日期");
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
                Intent intent = new Intent(MyLeaveActivity.this, LeaveXQActivity.class);
                intent.putExtra("id", allList.get(position - 1).getId());
                startActivity(intent);
            }
        });
        gwglList.setPullRefreshEnable(true);
        gwglList.setPullLoadEnable(true);
        gwglList.setXListViewListener(this);
        gwglList.setOnScrollListener(this);
        searchEtTz.setOnEditorActionListener(this);
        searchEtTz.setFocusable(false);
        searchEtTz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.setVibrate(true);
                datePickerDialog.setYearRange(1985, 2028);
                datePickerDialog.setCloseOnSingleTapDay(true);
                datePickerDialog.show(getSupportFragmentManager(), DATEPICKER_TAG);
            }
        });
        mHandler = new Handler();
    }

    public void getRequest(String string) {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"LeaveW\",\"Para\": {\"Sid\": \"" + User.sid + "\",\"Search\": \"" + string + "\",\"Page\": \"" + page + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                result = GsonUtils.json2bean(response, LeaveResult.class);
                Log.i("wwwwwww", response);
                if (result == null || (result.getStu() != 1)) {
                    Toast.makeText(MyLeaveActivity.this, Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    firstList = result.getRst().getList();
                    if (flsh) {
                        Log.i("我现在刷新了", "firstList" + firstList.size());
                        allList.clear();
                        allList.addAll(firstList);
                        SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault());
                        RefreshTime.setRefreshTime(MyLeaveActivity.this, df.format(new Date()));
                        resultAdapter.setData(firstList);
                        resultAdapter.notifyDataSetChanged();
                        gwglList.setRefreshTime(RefreshTime.getRefreshTime(MyLeaveActivity.this));
                        gwglList.stopRefresh();
                        gwglList.stopLoadMore();
                        flsh = false;

                    } else {

                        if (isFlsh) {
                            allList.clear();
                            allList.addAll(firstList);
                            Log.i("zhang", "列表个数---第一" + firstList.size());
                            Log.i("zhang", "列表个数---第二" + allList.size());
                            resultAdapter = new CommonAdapter<LeaveResult.RstBean.ListBean>(MyLeaveActivity.this, firstList, R.layout.item_list_meetingnotice) {
                                @Override
                                public void convert(ViewHolder holder, LeaveResult.RstBean.ListBean testResult) {
                                    holder.setText(R.id.tv_title, testResult.getUsername()).
                                            setText(R.id.tv_sender, testResult.getDeptname()).
                                            setText(R.id.tv_time, testResult.getApplyday());
                                    switch (testResult.getType()) {
                                        case "0": {
                                            holder.setImageResource(R.id.image, R.mipmap.nianjia);
                                        }
                                        break;
                                        case "1": {
                                            holder.setImageResource(R.id.image, R.mipmap.shijia);
                                        }
                                        break;
                                        case "2": {
                                            holder.setImageResource(R.id.image, R.mipmap.bingjia);
                                        }
                                        break;
                                        case "3": {
                                            holder.setImageResource(R.id.image, R.mipmap.hunjia);
                                        }
                                        break;
                                        case "4": {
                                            holder.setImageResource(R.id.image, R.mipmap.chanjia);
                                        }
                                        break;
                                        case "5": {
                                            holder.setImageResource(R.id.image, R.mipmap.sangjia);
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
                                Toast.makeText(MyLeaveActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                                onLoad();
                            }
                        }

                    }

                }

                return false;
            }
        }.volleyStringRequestPost(MyLeaveActivity.this, params, "app?", null);
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
        gwglList.setRefreshTime(RefreshTime.getRefreshTime(MyLeaveActivity.this));
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
                Toast.makeText(MyLeaveActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
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
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        //以下方法防止两次发送请求
        if (actionId == EditorInfo.IME_ACTION_SEND ||
                (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
            switch (event.getAction()) {
                case KeyEvent.ACTION_UP:
                    Log.i("zhang", "text====" + v.getText());
                    string = v.getText().toString().trim();
                    page = 1;
                    allList.clear();
                    isFlsh = false;
                    getRequest(string);
                    gwglList.setSelection(0);
                    return true;
                default:
                    return true;
            }
        }
        return false;

    }
    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
        if (month == 12) {
            month = 1;
        } else {
            month++;
        }
        if (month < 10) {
            acquisitionMoth = "0" + month;
        } else {
            acquisitionMoth = "" + month;
        }
        if (day < 10) {
            acquisitionDay = "0" + day;
        } else {
            acquisitionDay = "" + day;
        }
        searchEtTz.setText(year + "-" + acquisitionMoth + "-" + acquisitionDay);
        page = 1;
        allList.clear();
        string = year + "-" + acquisitionMoth + "-" + acquisitionDay;
        getRequest(string);
        gwglList.setSelection(0);
    }
}
