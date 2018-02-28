package com.example.litianci.guangming.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.litianci.guangming.BaseActivity;
import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.bean.SelecPersonResult;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.bean.Users;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;
import com.example.litianci.guangming.views.CircularImage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SelectPersonActivity extends BaseActivity implements TextView.OnEditorActionListener, View.OnClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.search_et_tz)
    EditText searchEtTz;
    @Bind(R.id.txlexpandable_list)
    ExpandableListView txlexpandableList;
    @Bind(R.id.iv_sure)
    ImageView ivSure;
    private java.util.List<SelecPersonResult.RstBean.ListBean> Clist;
    private MyExpandableListViewAdapter adapter;
    ArrayList<Users> List = new ArrayList<Users>();
    private ArrayList<String> strings = new ArrayList<>();
    private ArrayList<String> strings2 = new ArrayList<>();
    private ArrayList<String> ryid = new ArrayList<>();
    private Intent intent;
    private StringBuilder stringBuilder = new StringBuilder();
    private StringBuilder stringBuilder2 = new StringBuilder();
    private StringBuilder ryidstringBuilder = new StringBuilder();
    private String bzf;
    private SelecPersonResult result;
    Comparator<Users> comparator = new Comparator<Users>() {
        public int compare(Users s1, Users s2) {
            //先排年龄
            if (s1.power != s2.power) {
                return s1.power - s2.power;
            } else {
                //年龄相同则按姓名排序
                if (!s1.name.equals(s2.name)) {
                    return s1.name.compareTo(s2.name);
                }
            }
            return 0;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_select_person);
        ButterKnife.bind(this);
        ivSure.setOnClickListener(this);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        intent = getIntent();
        getRequest("");
        //设置list的展开
        txlexpandableList.setGroupIndicator(null);
        // 监听组点击
        txlexpandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @SuppressLint("NewApi")
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (Clist.get(groupPosition).getDeptCode().isEmpty()) {
                    return true;
                }
                return false;
            }
        });
        searchEtTz.setOnEditorActionListener(this);

        // 监听每个分组里子控件的点击事件
        txlexpandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//                intent.putExtra(Globals.HJ_DZ_DW, Clist.get(groupPosition).getCompanyname());
//                intent.putExtra(Globals.HJ_DZ_ID, Clist.get(groupPosition).getAdresslistList().get(childPosition).getAdressid());
//                intent.putExtra(Globals.HJ_DZ_NA, Clist.get(groupPosition).getAdresslistList().get(childPosition).getAdressname());
//                setResult(Activity.RESULT_OK, intent);//返回页面1
//                finish();
                return false;
            }
        });

    }

    /**
     * 加载网络数据
     */
    public void getRequest(final String string) {
        Map<String, String> params = new HashMap<String, String>();
        if (getIntent().getStringExtra("bzf").equals("WjcySelPeople")) {
            params.put(Globals.WS_POST_KEY, "{\"Ac\": \"" + getIntent().getStringExtra("bzf") + "\",\"Para\": {\"Search\": \"" + string + "\",\"Sid\": \"" + User.sid + "\"}}");
        } else {
            params.put(Globals.WS_POST_KEY, "{\"Ac\": \"" + getIntent().getStringExtra("bzf") + "\",\"Para\": {\"Search\": \"" + string + "\"}}");
        }

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                result = GsonUtils.json2bean(response, SelecPersonResult.class);
                Clist = (java.util.List<SelecPersonResult.RstBean.ListBean>) result.getRst().getList();
                Log.i("zhang", "tia" + Clist.size());
                adapter = new MyExpandableListViewAdapter(SelectPersonActivity.this);

                txlexpandableList.setAdapter(adapter);
                if (!string.equals("")) {
                    for (int i = 0; i < adapter.getGroupCount(); i++) {
                        txlexpandableList.expandGroup(i);
                    }
                } else if (string.equals("")) {
                    for (int i = 0; i < adapter.getGroupCount(); i++) {
                        txlexpandableList.collapseGroup(i);
                    }
                }


                return false;
            }
        }.volleyStringRequestPost(SelectPersonActivity.this, params, "app?", null);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEND || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
            Log.i("zhang", "text====" + v.getText());
            getRequest(v.getText().toString().trim());
            return true;
        }
        return false;
    }

    static void display(ArrayList<Users> lst) {
        for (Users s : lst)
            Log.i("zhang", s.getName() + "/" + s.getPower());
    }

    @Override
    public void onClick(View view) {
        Log.i("zhang", "tj " + strings.size());
        strings.size();
//        for (int i = 0; i < strings.size(); i++) {
//            Users stu1 = new Users(strings.get(i), Integer.parseInt(strings2.get(i)));
//
//            List.add(stu1);
//        }
//        //这里就会自动根据规则进行排序
//        Collections.sort(List, comparator);
//        display(List);
        for (int i = 0; i < strings.size(); i++) {

            stringBuilder.append(strings.get(i) + ";");
            stringBuilder2.append(strings2.get(i) + ",");
            ryidstringBuilder.append(ryid.get(i) + ";");
        }
//        Bundle bundle2 = new Bundle()
        intent.putExtra("strResult", stringBuilder.toString());
        intent.putExtra("strResult2", ryidstringBuilder.toString());
        intent.putExtra("strResult3", stringBuilder2.toString());
        setResult(2, intent);
        finish();
    }

    // 用过ListView的人一定很熟悉，只不过这里是BaseExpandableListAdapter
    class MyExpandableListViewAdapter extends BaseExpandableListAdapter {

        private Context context;

        public MyExpandableListViewAdapter(Context context) {
            this.context = context;
        }

        /**
         * 获取组的个数
         *
         * @return
         * @see ExpandableListAdapter#getGroupCount()
         */
        @Override
        public int getGroupCount() {
            return Clist.size();
        }

        /**
         * 获取指定组中的子元素个数
         *
         * @param groupPosition
         * @return
         * @see ExpandableListAdapter#getChildrenCount(int)
         */
        @Override
        public int getChildrenCount(int groupPosition) {
            return Clist.get(groupPosition).getPeoplelist().size();
        }

        /**
         * 获取指定组中的数据
         *
         * @param groupPosition
         * @return
         * @see ExpandableListAdapter#getGroup(int)
         */
        @Override
        public Object getGroup(int groupPosition) {
            return Clist.get(groupPosition);
        }

        /**
         * 获取指定组中的指定子元素数据。
         *
         * @param groupPosition
         * @param childPosition
         * @return
         * @see ExpandableListAdapter#getChild(int, int)
         */
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return Clist.get(groupPosition).getPeoplelist().get(childPosition);
        }

        /**
         * 获取指定组的ID，这个组ID必须是唯一的
         *
         * @param groupPosition
         * @return
         * @see ExpandableListAdapter#getGroupId(int)
         */
        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        /**
         * 获取指定组中的指定子元素ID
         *
         * @param groupPosition
         * @param childPosition
         * @return
         * @see ExpandableListAdapter#getChildId(int, int)
         */
        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        /**
         * 组和子元素是否持有稳定的ID,也就是底层数据的改变不会影响到它们。
         *
         * @return
         * @see ExpandableListAdapter#hasStableIds()
         */
        @Override
        public boolean hasStableIds() {
            return true;
        }

        /**
         * 获取显示指定组的视图对象
         *
         * @param groupPosition 组位置
         * @param isExpanded    该组是展开状态还是伸缩状态
         * @param convertView   重用已有的视图对象
         * @param parent        返回的视图对象始终依附于的视图组
         * @return
         * @see ExpandableListAdapter#getGroupView(int, boolean, View,
         * ViewGroup)
         */
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            GroupHolder groupHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.txl_f_item, null);
                groupHolder = new GroupHolder();
                groupHolder.txt = (TextView) convertView.findViewById(R.id.txl_1);

                convertView.setTag(groupHolder);
            } else {
                groupHolder = (GroupHolder) convertView.getTag();
            }
            groupHolder.txt.setText(Clist.get(groupPosition).getDeptName());
            return convertView;
        }

        /**
         * 获取一个视图对象，显示指定组中的指定子元素数据。
         *
         * @param groupPosition 组位置
         * @param childPosition 子元素位置
         * @param isLastChild   子元素是否处于组中的最后一个
         * @param convertView   重用已有的视图(View)对象
         * @param parent        返回的视图(View)对象始终依附于的视图组
         * @return
         * @see ExpandableListAdapter#getChildView(int, int, boolean, View,
         * ViewGroup)
         */
        @Override
        public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ItemHolder itemHolder = null;
            convertView = LayoutInflater.from(context).inflate(R.layout.txl_z_item, null);
            itemHolder = new ItemHolder();
            itemHolder.txt = (TextView) convertView.findViewById(R.id.txl_name);
            itemHolder.txt1 = (TextView) convertView.findViewById(R.id.txl_zw);
            itemHolder.img = (CircularImage) convertView.findViewById(R.id.txl_iamge1);
            itemHolder.ccx = (CheckBox) convertView.findViewById(R.id.txl_c);
            if (strings.contains(Clist.get(groupPosition).getPeoplelist().get(childPosition).getPeopleName())) {
                itemHolder.ccx.setChecked(true);
            } else {
                itemHolder.ccx.setChecked(false);
            }
            itemHolder.ccx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        strings.add(Clist.get(groupPosition).getPeoplelist().get(childPosition).getPeopleName());
                        ryid.add(Clist.get(groupPosition).getPeoplelist().get(childPosition).getSendcode());
                        strings2.add(Clist.get(groupPosition).getPeoplelist().get(childPosition).getPeopleCode());

                    } else {
                        if (strings.contains(Clist.get(groupPosition).getPeoplelist().get(childPosition).getPeopleName()))
                            strings.remove(Clist.get(groupPosition).getPeoplelist().get(childPosition).getPeopleName());
                        if (strings2.contains(Clist.get(groupPosition).getPeoplelist().get(childPosition).getPeopleCode()))
                            strings2.remove(Clist.get(groupPosition).getPeoplelist().get(childPosition).getPeopleCode());

                        if (ryid.contains(Clist.get(groupPosition).getPeoplelist().get(childPosition).getSendcode()))
                            ryid.remove(Clist.get(groupPosition).getPeoplelist().get(childPosition).getSendcode());

                    }
                }
            });
            itemHolder.txt.setText(Clist.get(groupPosition).getPeoplelist().get(childPosition).getPeopleName());

            return convertView;
        }

        /**
         * 是否选中指定位置上的子元素。
         *
         * @param groupPosition
         * @param childPosition
         * @return
         * @see ExpandableListAdapter#isChildSelectable(int, int)
         */
        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

    }

    class GroupHolder {
        public TextView txt;

        public TextView img;
    }

    class ItemHolder {
        public CircularImage img;
        public CheckBox ccx;
        public TextView txt;
        public TextView txt1;
    }

}
