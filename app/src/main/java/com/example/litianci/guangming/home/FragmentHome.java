package com.example.litianci.guangming.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.adapter.CommonAdapter;
import com.example.litianci.guangming.adapter.ViewHolder;
import com.example.litianci.guangming.bean.HomeResult;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.utils.GsonUtils;
import com.example.litianci.guangming.utils.VolleyUtil;
import com.example.litianci.guangming.views.GridViewForScrollView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @创建人：李井宇
 * @创建时间：2017.11.01
 * @用途：首页fragment
 */

public class FragmentHome extends Fragment implements View.OnClickListener {


    @Bind(R.id.gome_view)
    WebView gomeView;
    @Bind(R.id.iv_titlenotice)
    ImageView ivTitlenotice;
    @Bind(R.id.tv_titlenotice)
    TextView tvTitlenotice;
    @Bind(R.id.tv_more)
    TextView tvMore;
    @Bind(R.id.gv_rcbg)
    GridViewForScrollView gvRcbg;

    @Bind(R.id.gv_zlcs)
    GridViewForScrollView gvZlcs;
    @Bind(R.id.gv_gzgl)
    GridViewForScrollView gvGzgl;
    @Bind(R.id.gv_hygl)
    GridViewForScrollView gvHygl;
    @Bind(R.id.gv_clgl)
    GridViewForScrollView gvClgl;
    @Bind(R.id.llrichangbangong)
    LinearLayout llrichangbangong;
    @Bind(R.id.llziliaochuansong)
    LinearLayout llziliaochuansong;
    @Bind(R.id.llgongzuoguanli)
    LinearLayout llgongzuoguanli;
    @Bind(R.id.llhuiyiguanli)
    LinearLayout llhuiyiguanli;
    @Bind(R.id.llcheliangguanli)
    LinearLayout llcheliangguanli;
    //日常办公
    private CommonAdapter adapter1;
    private ArrayList<Map<String, Object>> item1;
    //资料传送
    private CommonAdapter adapter2;
    private ArrayList<Map<String, Object>> item2;
    //工作管理
    private CommonAdapter adapter3;
    private ArrayList<Map<String, Object>> item3;
    //会议管理
    private CommonAdapter adapter5;
    private ArrayList<Map<String, Object>> item5;
    //车辆管理
    private CommonAdapter adapter6;
    private ArrayList<Map<String, Object>> item6;
    private boolean richang = true;
    private boolean ziliao = false;
    private boolean gongzuo = false;
    private boolean huiyi = false;
    private boolean cheliang = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        getRequest();
        tvMore.setOnClickListener(this);
        gvClgl.setVisibility(View.GONE);
        gvGzgl.setVisibility(View.GONE);
        gvHygl.setVisibility(View.GONE);
        gvZlcs.setVisibility(View.GONE);
        llrichangbangong.setOnClickListener(this);
        llziliaochuansong.setOnClickListener(this);
        llgongzuoguanli.setOnClickListener(this);
        llhuiyiguanli.setOnClickListener(this);
        llcheliangguanli.setOnClickListener(this);
        ivTitlenotice.setOnClickListener(this);
        addGridView();
        setItemClick();
        return view;
    }

    public void getRequest() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Globals.WS_POST_KEY, "{\"Ac\": \"Index\",\"Para\": {\"Sid\": \"" + User.sid + "\"}}");

        new VolleyUtil() {

            @Override
            public <T> boolean analysisData(String response) {
                HomeResult s3 = GsonUtils.json2bean(response, HomeResult.class);
                Log.i("wwwwwww", response);
                if (s3 == null || !(s3.getStu() == 1)) {
                    Toast.makeText(getActivity(), Globals.SER_ERROR,
                            Toast.LENGTH_SHORT).show();

                } else {
                    tvTitlenotice.setText(s3.getRst().getTitle());
                }
                return false;
            }
        }.volleyStringRequestPost(getActivity(), params, "app?", null);
    }

    private void addGridView() {
        item1 = new ArrayList<Map<String, Object>>();
        item2 = new ArrayList<Map<String, Object>>();
        item3 = new ArrayList<Map<String, Object>>();
        item5 = new ArrayList<Map<String, Object>>();
        item6 = new ArrayList<Map<String, Object>>();
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.wenjianchuanyue);//添加图像资源的ID
            item.put("textItem", "文件传阅");//按序号添加ItemText
            item1.add(item);

        }

        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.tongxunlu);//添加图像资源的ID
            item.put("textItem", "通讯录");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.zhibananpai);//添加图像资源的ID
            item.put("textItem", "值班安排");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.richenganpai);//添加图像资源的ID
            item.put("textItem", "日程安排");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.qingjiachaxun);//添加图像资源的ID
            item.put("textItem", "请假查询");//按序号添加ItemText
            item1.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.yongzhangchaxun);//添加图像资源的ID
            item.put("textItem", "用章查询");//按序号添加ItemText
            item1.add(item);
        }

        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.chuanziliao);//添加图像资源的ID
            item.put("textItem", "传资料");//按序号添加ItemText
            item2.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.shouziliao);//添加图像资源的ID
            item.put("textItem", "收资料");//按序号添加ItemText
            item2.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.yifasong);//添加图像资源的ID
            item.put("textItem", "已发送");//按序号添加ItemText
            item2.add(item);
        }
//        if (true) {
//            Map<String, Object> item = new HashMap<String, Object>();
//            item.put("imageItem", R.mipmap.caogaoxiang);//添加图像资源的ID
//            item.put("textItem", "草稿箱");//按序号添加ItemText
//            item2.add(item);
//        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.shoucangziliao);//添加图像资源的ID
            item.put("textItem", "收藏资料");//按序号添加ItemText
            item2.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.whitebg);//添加图像资源的ID
            item.put("textItem", "");//按序号添加ItemText
            item2.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.whitebg);//添加图像资源的ID
            item.put("textItem", "");//按序号添加ItemText
            item2.add(item);
        }

        //工作管理列表


        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.daibangongzuo);//添加图像资源的ID
            item.put("textItem", "待办工作");//按序号添加ItemText
            item3.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.yibangongzuo);//添加图像资源的ID
            item.put("textItem", "已办工作");//按序号添加ItemText
            item3.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.shoucanggongzuo);//添加图像资源的ID
            item.put("textItem", "收藏工作");//按序号添加ItemText
            item3.add(item);
        }

        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.huiyitongzhifasong);//添加图像资源的ID
            item.put("textItem", "会议通知发送");//按序号添加ItemText
            item5.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.huiyitongzhichaxun);//添加图像资源的ID
            item.put("textItem", "会议通知查询");//按序号添加ItemText
            item5.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.huiyiyudingchaxun);//添加图像资源的ID
            item.put("textItem", "会议室预定查询");//按序号添加ItemText
            item5.add(item);
        }

        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.huiyicailiaoguanli);//添加图像资源的ID
            item.put("textItem", "会议材料管理");//按序号添加ItemText
            item5.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.whitebg);//添加图像资源的ID
            item.put("textItem", "");//按序号添加ItemText
            item5.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.whitebg);//添加图像资源的ID
            item.put("textItem", "");//按序号添加ItemText
            item5.add(item);
        }


        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.cheliangxinxiguanli);//添加图像资源的ID
            item.put("textItem", "车辆信息管理");//按序号添加ItemText
            item6.add(item);
        }
        if (true) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.cheliangshiyongjilu);//添加图像资源的ID
            item.put("textItem", "车辆使用记录");//按序号添加ItemText
            item6.add(item);
        }


    }

    public void setItemClick() {
        gvRcbg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) item1.get(position).get("textItem");
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

                    default:
                        break;
                }
            }
        });
        gvZlcs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) item2.get(position).get("textItem");
                switch (name) {
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
                    default:
                        break;
                }
            }
        });
        gvGzgl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) item3.get(position).get("textItem");
                switch (name) {
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
                    default:
                        break;
                }
            }
        });
        gvHygl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) item5.get(position).get("textItem");
                switch (name) {
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
                    default:
                        break;
                }
            }
        });

        gvClgl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) item6.get(position).get("textItem");
                switch (name) {
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_titlenotice: {
                Intent intent = new Intent(getActivity(), MsgCenterActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.tv_more: {
                Intent intent = new Intent(getActivity(), NoticeActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.llrichangbangong: {
                if (richang) {
                    gvRcbg.setVisibility(View.GONE);
                    richang = false;
                } else {
                    gvRcbg.setVisibility(View.VISIBLE);
                    richang = true;
                }
            }
            break;
            case R.id.llziliaochuansong: {
                if (ziliao) {
                    gvZlcs.setVisibility(View.GONE);
                    ziliao = false;
                } else {
                    gvZlcs.setVisibility(View.VISIBLE);
                    ziliao = true;
                }
            }
            break;
            case R.id.llgongzuoguanli: {
                if (gongzuo) {
                    gvGzgl.setVisibility(View.GONE);
                    gongzuo = false;
                } else {
                    gvGzgl.setVisibility(View.VISIBLE);
                    gongzuo = true;
                }
            }
            break;
            case R.id.llhuiyiguanli: {
                if (huiyi) {
                    gvHygl.setVisibility(View.GONE);
                    huiyi = false;
                } else {
                    gvHygl.setVisibility(View.VISIBLE);
                    huiyi = true;
                }
            }
            break;
            case R.id.llcheliangguanli: {
                if (cheliang) {
                    gvClgl.setVisibility(View.GONE);
                    cheliang = false;
                } else {
                    gvClgl.setVisibility(View.VISIBLE);
                    cheliang = true;
                }
            }
            break;
            default:
                break;
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        adapter1 = new CommonAdapter<Map<String, Object>>(getActivity(), item1, R.layout.item_grid_home) {
            @Override
            public void convert(ViewHolder holder, Map<String, Object> o) {

                holder.setImageResource(R.id.image, (Integer) o.get("imageItem")).setText(R.id.text, (String) o.get("textItem"));
            }
        };
        adapter2 = new CommonAdapter<Map<String, Object>>(getActivity(), item2, R.layout.item_grid_home) {
            @Override
            public void convert(ViewHolder holder, Map<String, Object> o) {
                holder.setImageResource(R.id.image, (Integer) o.get("imageItem")).setText(R.id.text, (String) o.get("textItem"));
            }
        };
        adapter3 = new CommonAdapter<Map<String, Object>>(getActivity(), item3, R.layout.item_grid_home) {
            @Override
            public void convert(ViewHolder holder, Map<String, Object> o) {

                holder.setImageResource(R.id.image, (Integer) o.get("imageItem")).setText(R.id.text, (String) o.get("textItem"));
            }
        };
        adapter1 = new CommonAdapter<Map<String, Object>>(getActivity(), item1, R.layout.item_grid_home) {
            @Override
            public void convert(ViewHolder holder, Map<String, Object> o) {

                holder.setImageResource(R.id.image, (Integer) o.get("imageItem")).setText(R.id.text, (String) o.get("textItem"));
            }
        };
        adapter2 = new CommonAdapter<Map<String, Object>>(getActivity(), item2, R.layout.item_grid_home) {
            @Override
            public void convert(ViewHolder holder, Map<String, Object> o) {
                holder.setImageResource(R.id.image, (Integer) o.get("imageItem")).setText(R.id.text, (String) o.get("textItem"));
            }
        };
        adapter3 = new CommonAdapter<Map<String, Object>>(getActivity(), item3, R.layout.item_grid_home) {
            @Override
            public void convert(ViewHolder holder, Map<String, Object> o) {

                holder.setImageResource(R.id.image, (Integer) o.get("imageItem")).setText(R.id.text, (String) o.get("textItem"));
            }
        };
        adapter1 = new CommonAdapter<Map<String, Object>>(getActivity(), item1, R.layout.item_grid_home) {
            @Override
            public void convert(ViewHolder holder, Map<String, Object> o) {

                holder.setImageResource(R.id.image, (Integer) o.get("imageItem")).setText(R.id.text, (String) o.get("textItem"));
            }
        };
        adapter2 = new CommonAdapter<Map<String, Object>>(getActivity(), item2, R.layout.item_grid_home) {
            @Override
            public void convert(ViewHolder holder, Map<String, Object> o) {
                holder.setImageResource(R.id.image, (Integer) o.get("imageItem")).setText(R.id.text, (String) o.get("textItem"));
            }
        };
        adapter3 = new CommonAdapter<Map<String, Object>>(getActivity(), item3, R.layout.item_grid_home) {
            @Override
            public void convert(ViewHolder holder, Map<String, Object> o) {

                holder.setImageResource(R.id.image, (Integer) o.get("imageItem")).setText(R.id.text, (String) o.get("textItem"));
            }
        };
        adapter5 = new CommonAdapter<Map<String, Object>>(getActivity(), item5, R.layout.item_grid_home) {
            @Override
            public void convert(ViewHolder holder, Map<String, Object> o) {
                holder.setImageResource(R.id.image, (Integer) o.get("imageItem")).setText(R.id.text, (String) o.get("textItem"));
            }
        };
        adapter6 = new CommonAdapter<Map<String, Object>>(getActivity(), item6, R.layout.item_grid_home) {
            @Override
            public void convert(ViewHolder holder, Map<String, Object> o) {

                holder.setImageResource(R.id.image, (Integer) o.get("imageItem")).setText(R.id.text, (String) o.get("textItem"));
            }
        };
        gvRcbg.setAdapter(adapter1);
        gvZlcs.setAdapter(adapter2);
        gvGzgl.setAdapter(adapter3);
        gvHygl.setAdapter(adapter5);
        gvClgl.setAdapter(adapter6);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
