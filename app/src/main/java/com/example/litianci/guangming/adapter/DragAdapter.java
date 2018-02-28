package com.example.litianci.guangming.adapter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.litianci.guangming.Globals;
import com.example.litianci.guangming.LoginActivity;
import com.example.litianci.guangming.R;
import com.example.litianci.guangming.bean.User;
import com.example.litianci.guangming.utils.SharedPreferencesUtils;

/**
 * @author xiaanming
 * @blog http://blog.csdn.net/xiaanming
 */
public class DragAdapter extends BaseAdapter implements DragGridBaseAdapter {
    private Context context;
    private List<Map<String, String>> list;
    private LayoutInflater mInflater;
    private int mHidePosition = -1;

    public DragAdapter(Context context, List<Map<String, String>> list) {
        this.list = list;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * ���ڸ���convertView����ĳЩitem��ʧ�ˣ��������ﲻ����item��
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.item_grid_home, null);
        ImageView mImageView = (ImageView) convertView.findViewById(R.id.image);
        TextView mTextView = (TextView) convertView.findViewById(R.id.text);

        mImageView.setImageResource(Integer.parseInt(list.get(position).get("imageItem")));
        mTextView.setText(list.get(position).get("textItem"));

        if (position == mHidePosition) {
            convertView.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }


    @Override
    public void reorderItems(int oldPosition, int newPosition) {
        Map<String, String> temp = list.get(oldPosition);
        if (oldPosition < newPosition) {
            for (int i = oldPosition; i < newPosition; i++) {
                Collections.swap(list, i, i + 1);
            }
        } else if (oldPosition > newPosition) {
            for (int i = oldPosition; i > newPosition; i--) {
                Collections.swap(list, i, i - 1);
            }
        }

        list.set(newPosition, temp);
        Log.i("数据", list.toString());
        for (int i = 0; i < list.size(); i++) {
            SharedPreferencesUtils.saveString(context,
                    "" + i, list.get(i).get("imageItem") + ":" + list.get(i).get("textItem"));
        }

    }

    @Override
    public void setHideItem(int hidePosition) {
        this.mHidePosition = hidePosition;
        notifyDataSetChanged();
    }


}
