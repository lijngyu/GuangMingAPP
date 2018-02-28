package com.example.litianci.guangming.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.SplashScreenActivity;
import com.example.litianci.guangming.adapter.DragAdapter;
import com.example.litianci.guangming.utils.SharedPreferencesUtils;
import com.example.litianci.guangming.views.DragGridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;

/**
 * Created by litianci on 2018/1/16.
 */

public class FragmentHome2 extends Fragment {
    private ArrayList<Map<String, String>> item1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home2, container, false);
        ButterKnife.bind(this, view);
        item1 = new ArrayList<Map<String, String>>();
        DragGridView mDragGridView = (DragGridView) view.findViewById(R.id.dragGridView);
        if (SharedPreferencesUtils.getString(getActivity(), "0", null) != null) {
            for (int i = 0; i < 19; i++) {
                Map<String, String> item = new HashMap<String, String>();
                item.put("imageItem", SharedPreferencesUtils.getString(getActivity(), "" + i, null).split(":")[0]);//添加图像资源的ID
                item.put("textItem", SharedPreferencesUtils.getString(getActivity(), "" + i, null).split(":")[1]);//按序号添加ItemText
                item1.add(item);
            }
        } else {
            addGridView();
        }


//            dataSourceList.add(item1);


        final DragAdapter mDragAdapter = new DragAdapter(getActivity(), item1);

        mDragGridView.setAdapter(mDragAdapter);
        mDragGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = item1.get(i).get("textItem");
                switch (name) {
                    case "文件传阅": {
                        Intent intent = new Intent(getActivity(), FileCirculationActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "通讯录": {
                        Intent intent = new Intent(getActivity(), TXLActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "值班安排": {
                        Intent intent = new Intent(getActivity(), DutyActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "日程安排": {
                        Intent intent = new Intent(getActivity(), ScheduleActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "请假查询": {
                        Intent intent = new Intent(getActivity(), LeaveActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "用章查询": {
                        Intent intent = new Intent(getActivity(), YongZhangActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "传资料": {
                        Intent intent = new Intent(getActivity(), SendDataActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "收资料": {
                        Intent intent = new Intent(getActivity(), ReceiveDataActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "已发送": {
                        Intent intent = new Intent(getActivity(), AlreadySendActivity.class);
                        startActivity(intent);
                    }
                    break;
//                    case "草稿箱": {
//                        Intent intent = new Intent(getActivity(), DraftsActivity.class);
//                        startActivity(intent);
//                    }
//                    break;
                    case "收藏资料": {
                        Intent intent = new Intent(getActivity(), CollectionDataActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "待办工作": {
                        Intent intent = new Intent(getActivity(), DaibanActivity.class);
                        intent.putExtra("type", "待办工作");
                        intent.putExtra("ac", "Todo");
                        startActivity(intent);
                    }
                    break;
                    case "已办工作": {
                        Intent intent = new Intent(getActivity(), DaibanActivity.class);
                        intent.putExtra("type", "已办工作");
                        intent.putExtra("ac", "Done");
                        startActivity(intent);
                    }
                    break;
                    case "收藏工作": {
                        Intent intent = new Intent(getActivity(), DaibanActivity.class);
                        intent.putExtra("type", "收藏工作");
                        intent.putExtra("ac", "Collectlist");
                        startActivity(intent);
                    }
                    break;
                    case "会议通知发送": {
                        Intent intent = new Intent(getActivity(), MeettingSendActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "会议通知查询": {
                        Intent intent = new Intent(getActivity(), MeettingNoticeSearchActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "会议室预定查询": {
                        Intent intent = new Intent(getActivity(), MeettingRoomSearchActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "会议材料管理": {
                        Intent intent = new Intent(getActivity(), MeettingMaterialsActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "车辆信息管理": {
                        Intent intent = new Intent(getActivity(), CarManageActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case "车辆使用记录": {
                        Intent intent = new Intent(getActivity(), CarUseActivity.class);
                        startActivity(intent);
                    }
                    break;

                    default:
                        break;
                }
            }
        });

        return view;
    }

    private void addGridView() {


        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.wenjianchuanyue);//添加图像资源的ID
            item.put("textItem", "文件传阅");//按序号添加ItemText
            item1.add(item);

        }

        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.tongxunlu);//添加图像资源的ID
            item.put("textItem", "通讯录");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.zhibananpai);//添加图像资源的ID
            item.put("textItem", "值班安排");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.richenganpai);//添加图像资源的ID
            item.put("textItem", "日程安排");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.qingjiachaxun);//添加图像资源的ID
            item.put("textItem", "请假查询");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.yongzhangchaxun);//添加图像资源的ID
            item.put("textItem", "用章查询");//按序号添加ItemText
            item1.add(item);
        }

        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.chuanziliao);//添加图像资源的ID
            item.put("textItem", "传资料");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.shouziliao);//添加图像资源的ID
            item.put("textItem", "收资料");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.yifasong);//添加图像资源的ID
            item.put("textItem", "已发送");//按序号添加ItemText
            item1.add(item);
        }
//
        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.shoucangziliao);//添加图像资源的ID
            item.put("textItem", "收藏资料");//按序号添加ItemText
            item1.add(item);
        }

        //工作管理列表


        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.daibangongzuo);//添加图像资源的ID
            item.put("textItem", "待办工作");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.yibangongzuo);//添加图像资源的ID
            item.put("textItem", "已办工作");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.shoucanggongzuo);//添加图像资源的ID
            item.put("textItem", "收藏工作");//按序号添加ItemText
            item1.add(item);
        }

        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.huiyitongzhifasong);//添加图像资源的ID
            item.put("textItem", "会议通知发送");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.huiyitongzhichaxun);//添加图像资源的ID
            item.put("textItem", "会议通知查询");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.huiyiyudingchaxun);//添加图像资源的ID
            item.put("textItem", "会议室预定查询");//按序号添加ItemText
            item1.add(item);
        }

        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.huiyicailiaoguanli);//添加图像资源的ID
            item.put("textItem", "会议材料管理");//按序号添加ItemText
            item1.add(item);
        }


        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.cheliangxinxiguanli);//添加图像资源的ID
            item.put("textItem", "车辆信息管理");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("imageItem", "" + R.mipmap.cheliangshiyongjilu);//添加图像资源的ID
            item.put("textItem", "车辆使用记录");//按序号添加ItemText
            item1.add(item);
        }


    }
}
