package com.jju.yuxin.xiaoyuantong.horizontallistview;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong
 * Created by yuxin.
 * Created time 2016/10/9 0009 下午 4:35.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.jju.yuxin.xiaoyuantong.R;


public class HorizontalListViewAdapter extends BaseAdapter{
    private int[] mIconIDs;
    private Context mContext;
    private LayoutInflater mInflater;
    private int selectIndex = -1;

    public HorizontalListViewAdapter(Context context, int[] ids){
        this.mContext = context;
        this.mIconIDs = ids;

        mInflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return mIconIDs.length;
    }
    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.horizontal_list_item, null);
            holder.mImage=(ImageView)convertView.findViewById(R.id.img_list_item);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        holder.mImage.setImageResource(mIconIDs[position]);
        if(position == selectIndex){
            convertView.setSelected(true);
        }else{
            convertView.setSelected(false);
        }


        return convertView;
    }

    private static class ViewHolder {
        private ImageView mImage;
    }

    public void setSelectIndex(int i){
        selectIndex = i;
    }
}
