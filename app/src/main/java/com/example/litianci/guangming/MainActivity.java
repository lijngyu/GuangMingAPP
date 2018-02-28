package com.example.litianci.guangming;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.litianci.guangming.adapter.CommonAdapter;
import com.example.litianci.guangming.adapter.ViewHolder;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.daiban.FragmentDaiban;
import com.example.litianci.guangming.home.FragmentHome;
import com.example.litianci.guangming.home.FragmentHome2;
import com.example.litianci.guangming.home.FragmentHome3;
import com.example.litianci.guangming.home.SQActivity;
import com.example.litianci.guangming.my.FragmentMine;
import com.example.litianci.guangming.notice.FragmentNotice;
import com.example.litianci.guangming.utils.AppUtil;
import com.example.litianci.guangming.utils.UpdateVersionService;
import com.example.litianci.guangming.views.GridViewForScrollView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @创建人：李井宇
 * @创建时间：2017/11/01
 * @用途：主页面包含四个fragment
 */

public class MainActivity extends FragmentActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    @Bind(R.id.frame_content)
    FrameLayout frameContent;
    @Bind(R.id.image_home)
    ImageView imageHome;
    @Bind(R.id.layout_home)
    FrameLayout layoutHome;
    @Bind(R.id.image_daiban)
    ImageView imageDaiban;
    @Bind(R.id.layout_daiban)
    FrameLayout layoutDaiban;
    @Bind(R.id.image_notice)
    ImageView imageNotice;
    @Bind(R.id.layout_notice)
    FrameLayout layoutNotice;
    @Bind(R.id.image_mine)
    ImageView imageMine;
    @Bind(R.id.layout_mine)
    FrameLayout layoutMine;
    @Bind(R.id.frameMenu)
    FrameLayout frameMenu;
    @Bind(R.id.toggle_btn)
    ImageView toggleBtn;
    @Bind(R.id.yuan1)
    FrameLayout yuan1;
    // 定义Fragment页面
    private FragmentHome fragmentHome;
    private FragmentHome2 fragmentHome2;
    private FragmentHome3 fragmentHome3;
    private FragmentDaiban fragmentDaiban;
    private FragmentNotice fragmentNotice;
    private FragmentMine fragmentMine;

    // 定义PopupWindow
    private PopupWindow popWindow;
    private CommonAdapter<Map<String, Object>> adapter2;
    // 获取手机屏幕分辨率的类
    private DisplayMetrics dm;
    private int anInt = 0;

    // 用户退出界面点击返回按钮的间隔时间
    private ArrayList<Map<String, Object>> items;
    private WebView webs;
    private UpdateVersionService updateVersionService;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtil.setTranslucentStatus(this);
        setContentView(R.layout.activity_main);
//        new Handler().post(new Runnable() {
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                updateVersionService = new UpdateVersionService(
//                        Globals.VERSION_XML, MainActivity.this);// 创建更新业务对象
//                updateVersionService.checkUpdate();// 调用检查更新的方法,如果可以更新.就更新
//            }
//        });
        ButterKnife.bind(this);
        addGridView();
        Btnhome();
        setClick();

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    public void setClick() {
        layoutHome.setOnClickListener(this);
        layoutDaiban.setOnClickListener(this);
        layoutNotice.setOnClickListener(this);
        layoutMine.setOnClickListener(this);
        toggleBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_home: {
                Btnhome();
            }
            break;
            case R.id.layout_daiban: {
                Btndaiban();
            }
            break;
            case R.id.layout_notice: {
                Btnnotice();
            }
            break;
            case R.id.layout_mine: {
                Btnmine();
            }
            break;
            case R.id.toggle_btn: {
                clickToggleBtn();
            }
            break;
            case R.id.jia_guan: {
                popWindow.dismiss();
            }
            break;

            default:
                break;
        }
    }

    private void addGridView() {

        //适配显示数据
        items = new ArrayList<Map<String, Object>>();
        if (User.hysq.equals("1")) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.huiyishiyudingshenqing);//添加图像资源的ID
            item.put("textItem", "会议申请");//按序号添加ItemText
            items.add(item);
        }
        if (User.tzggfbsq.equals("1")) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.tongzhigonggaoshenqing);//添加图像资源的ID
            item.put("textItem", "通知公告发布申请");//按序号添加ItemText
            items.add(item);
        }
        if (User.yzsq.equals("1")) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.yongzhangshenqing);//添加图像资源的ID
            item.put("textItem", "用章申请");//按序号添加ItemText
            items.add(item);
        }
        if (User.fwsq.equals("1")) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.wenjianchuanyue2);//添加图像资源的ID
            item.put("textItem", "发文申请");//按序号添加ItemText
            items.add(item);
        }
        if (User.qjsq.equals("1")) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.qingjiashenqing);//添加图像资源的ID
            item.put("textItem", "请假申请");//按序号添加ItemText
            items.add(item);
        }
        if (User.clsysq.equals("1")) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.cheliangshiyongshenqing);//添加图像资源的ID
            item.put("textItem", "车辆使用申请");//按序号添加ItemText
            items.add(item);
        }


        if (User.hbsq.equals("1")) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.huanban);//添加图像资源的ID
            item.put("textItem", "换班申请");//按序号添加ItemText
            items.add(item);
        }
        if (User.gztz.equals("1")) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.gongzuotongzhi);//添加图像资源的ID
            item.put("textItem", "工作通知");//按序号添加ItemText
            items.add(item);
        }
//


    }

    public void Btnhome() {
        if (anInt != 1) {
            // 实例化Fragment页面
            fragmentHome3 = new FragmentHome3();
            // 得到Fragment事务管理器
            FragmentTransaction fragmentTransaction = this
                    .getSupportFragmentManager().beginTransaction();
            // 替换当前的页面
            fragmentTransaction.replace(R.id.frame_content, fragmentHome3);
            // 事务管理提交
            fragmentTransaction.commit();
            // 改变选中状态
            layoutHome.setSelected(true);
            imageHome.setSelected(true);

            layoutDaiban.setSelected(false);
            imageDaiban.setSelected(false);

            layoutNotice.setSelected(false);
            imageNotice.setSelected(false);

            layoutMine.setSelected(false);
            imageMine.setSelected(false);

        }
    }

    public void Btndaiban() {
        if (anInt != 2) {
            // 实例化Fragment页面
            fragmentDaiban = new FragmentDaiban();
            // 得到Fragment事务管理器
            FragmentTransaction fragmentTransaction = this
                    .getSupportFragmentManager().beginTransaction();
            // 替换当前的页面
            fragmentTransaction.replace(R.id.frame_content, fragmentDaiban);
            // 事务管理提交
            fragmentTransaction.commit();
            // 改变选中状态
            layoutHome.setSelected(false);
            imageHome.setSelected(false);

            layoutDaiban.setSelected(true);
            imageDaiban.setSelected(true);

            layoutNotice.setSelected(false);
            imageNotice.setSelected(false);

            layoutMine.setSelected(false);
            imageMine.setSelected(false);

        }
    }

    public void Btnnotice() {
        if (anInt != 3) {
            // 实例化Fragment页面
            fragmentNotice = new FragmentNotice();
            // 得到Fragment事务管理器
            FragmentTransaction fragmentTransaction = this
                    .getSupportFragmentManager().beginTransaction();
            // 替换当前的页面
            fragmentTransaction.replace(R.id.frame_content, fragmentNotice);
            // 事务管理提交
            fragmentTransaction.commit();
            // 改变选中状态
            layoutHome.setSelected(false);
            imageHome.setSelected(false);

            layoutDaiban.setSelected(false);
            imageDaiban.setSelected(false);

            layoutNotice.setSelected(true);
            imageNotice.setSelected(true);

            layoutMine.setSelected(false);
            imageMine.setSelected(false);
        }
    }

    public void Btnmine() {
        if (anInt != 4) {
            // 实例化Fragment页面
            fragmentMine = new FragmentMine();
            // 得到Fragment事务管理器
            FragmentTransaction fragmentTransaction = this
                    .getSupportFragmentManager().beginTransaction();
            // 替换当前的页面
            fragmentTransaction.replace(R.id.frame_content, fragmentMine);
            // 事务管理提交
            fragmentTransaction.commit();
            // 改变选中状态
            layoutHome.setSelected(false);
            imageHome.setSelected(false);

            layoutDaiban.setSelected(false);
            imageDaiban.setSelected(false);

            layoutNotice.setSelected(false);
            imageNotice.setSelected(false);

            layoutMine.setSelected(true);
            imageMine.setSelected(true);

        }
    }

    /**
     * 点击了中间按钮
     */
    private void clickToggleBtn() {
//        Toast.makeText(this,"目前此功能暂未开发完成",Toast.LENGTH_SHORT).show();
        showPopupWindow(toggleBtn);
        // 改变按钮显示的图片为按下时的状态
//        plusImageView.setSelected(true);
    }

    /**
     * 显示PopupWindow弹出菜单
     */
    private void showPopupWindow(View parent) {
        if (popWindow == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.popwindow_layout, null);
            dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);

            GridViewForScrollView gridview = (GridViewForScrollView) view.findViewById(R.id.jia_gridview);
            webs = (WebView) view.findViewById(R.id.swebs);
            gridview.setSelector(new ColorDrawable(Color.TRANSPARENT));
            adapter2 = new CommonAdapter<Map<String, Object>>(MainActivity.this, items, R.layout.grid_item1) {
                @Override
                public void convert(ViewHolder holder, Map<String, Object> o) {
                    holder.setImageResource(R.id.grid_iamge1, (Integer) o.get("imageItem")).setText(R.id.grid_text1, (String) o.get("textItem"));
                }
            };
            gridview.setAdapter(adapter2);
            gridview.setOnItemClickListener(this);

            LinearLayout guan = (LinearLayout) view.findViewById(R.id.jia_guan);
            guan.setOnClickListener(this);
//
            popWindow = new PopupWindow(view, dm.widthPixels, dm.heightPixels);

        }
        // 使其聚集 ，要想监听菜单里控件的事件就必须要调用此方法
        popWindow.setFocusable(true);
        // 设置允许在外点击消失
        popWindow.setOutsideTouchable(true);
        // 设置背景，这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popWindow.setBackgroundDrawable(new BitmapDrawable());
        // PopupWindow的显示及位置设置
        popWindow.showAtLocation(parent, Gravity.FILL, 0, 0);
        popWindow.showAsDropDown(parent, 0, 0);

        popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // 改变显示的按钮图片为正常状态
            }
        });

        // 监听触屏事件
        popWindow.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                // 改变显示的按钮图片为正常状态

                return false;
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final String s = Globals.MY_URL + "login.cmd" + "?usercode=" + User.sid + "&pwd=" + User.pwd;
        webs.loadUrl(s);
        Log.i("我点击的是：", s);
        String name = (String) items.get(i).get("textItem");
        if (name.equals("发文申请")) {
            popWindow.dismiss();
            Intent intent1 = new Intent(this, SQActivity.class);
            intent1.putExtra(Globals.QJBS, "发文申请");
            startActivity(intent1);
        }
        if (name.equals("请假申请")) {
            popWindow.dismiss();
            Intent intent2 = new Intent(this, SQActivity.class);
            intent2.putExtra(Globals.QJBS, "请假申请");
            startActivity(intent2);
        }
        if (name.equals("车辆使用申请")) {
            popWindow.dismiss();
            Intent intent3 = new Intent(this, SQActivity.class);
            intent3.putExtra(Globals.QJBS, "车辆使用申请");
            startActivity(intent3);
        }
        if (name.equals("会议申请")) {
            popWindow.dismiss();
            Intent intent4 = new Intent(this, SQActivity.class);
            intent4.putExtra(Globals.QJBS, "会议申请");
            startActivity(intent4);
        }
        if (name.equals("通知公告发布申请")) {
            popWindow.dismiss();
            Intent intent5 = new Intent(this, SQActivity.class);
            intent5.putExtra(Globals.QJBS, "通知公告发布申请");
            startActivity(intent5);
        }
        if (name.equals("用章申请")) {
            popWindow.dismiss();
            Intent intent6 = new Intent(this, SQActivity.class);
            intent6.putExtra(Globals.QJBS, "用章申请");
            startActivity(intent6);

        }
        if (name.equals("换班申请")) {
            popWindow.dismiss();
            Intent intent5 = new Intent(this, SQActivity.class);
            intent5.putExtra(Globals.QJBS, "换班申请");
            startActivity(intent5);
        }
        if (name.equals("工作通知")) {
            popWindow.dismiss();
            Intent intent6 = new Intent(this, SQActivity.class);
            intent6.putExtra(Globals.QJBS, "工作通知");
            startActivity(intent6);

        }

    }
}
