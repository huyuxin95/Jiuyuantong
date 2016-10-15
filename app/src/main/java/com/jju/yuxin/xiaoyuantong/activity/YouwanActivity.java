package com.jju.yuxin.xiaoyuantong.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jju.yuxin.xiaoyuantong.R;
import com.jju.yuxin.xiaoyuantong.domain.Youwan;

import java.util.ArrayList;
import java.util.List;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong
 * Created by yuxin.
 * Created time 2016/10/9 0009 下午 7:46.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */
public class YouwanActivity extends Activity {
    private ListView lvyouwan;
    private List<Youwan> youwans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        youwans = new ArrayList<Youwan>();
        youwans.add(new Youwan(R.drawable.you01, "庐山", " 庐山雄奇秀拔，云雾缭绕", "庐山，又称匡山或匡庐, 庐山雄奇秀拔，云雾缭绕，山中多飞泉瀑布和奇洞怪石，名胜古迹遍布"));
        youwans.add(new Youwan(R.drawable.you02, "鄱阳湖", " 鄱阳湖是一个古老的断陷湖盆", "鄱阳湖是一个古老的断陷湖盆，约1.35亿年前沉陷成巨大的盆地，距今六七千年前积水成为湖泊。"));
        youwans.add(new Youwan(R.drawable.you03, "庐山西海", " 湖水清澈，碧波荡漾，风光秀丽", "天姿胜景，令人心 旷神怡，流连忘返。湖区四周群山环抱，古迹甚多"));
        youwans.add(new Youwan(R.drawable.you04, "庐山石门涧", "集“雄、险、奇、特、秀”于一体", "一座地质变化、生物进化、自然造化、历史文化的综合大观园，有“匡庐绝胜”、“山水绝胜”之美誉"));
        youwans.add(new Youwan(R.drawable.you05, "庐山东林寺", " 倡导“弥陀净土法门”", "　东林寺位于庐山西麓，是我国佛教净土宗发源地，倡导“弥陀净土法门”，并创设莲社"));
        youwans.add(new Youwan(R.drawable.you06, "庐山瀑布群", " 历代诸多文人骚客在此赋诗题词", "历代诸多文人骚客在此赋诗题词，赞颂其壮观雄伟，给庐山瀑布带来了极高的声誉。"));
        youwans.add(new Youwan(R.drawable.you07, "庐山三叠泉", " 未到三叠泉，不算庐山客", "匡庐瀑布，首推三叠，故有“不到三叠泉，不算“庐山客”之说。但三叠泉却长期隐藏荒山深壑"));
        initialize();
    }

    private void initialize() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_youwan);
        lvyouwan = (ListView) findViewById(R.id.lv_youwan);
        final MyAdapter adapter = new MyAdapter(this);
        lvyouwan.setAdapter(adapter);
        lvyouwan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(YouwanActivity.this, JingDianActivity.class);
                intent.putExtra("jingdian", adapter.getItem(position));
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * 适配器
     */
    private class MyAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater layoutInflater;

        public MyAdapter(Context context) {
            this.context = context;
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return youwans.size();
        }

        @Override
        public Youwan getItem(int position) {
            return youwans.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.activity_youwan_item, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((Youwan) getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(Youwan youwan, ViewHolder holder) {
            holder.imYouwanImg.setImageResource(youwan.img);
            holder.tvYouwanTitle.setText(youwan.name);
            holder.tvYouwanContent.setText(youwan.content);
        }

        protected class ViewHolder {
            private ImageView imYouwanImg;
            private TextView tvYouwanTitle;
            private TextView tvYouwanContent;

            public ViewHolder(View view) {
                imYouwanImg = (ImageView) view.findViewById(R.id.im_youwan_img);
                tvYouwanTitle = (TextView) view.findViewById(R.id.tv_youwan_title);
                tvYouwanContent = (TextView) view.findViewById(R.id.tv_youwan_content);
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent backintent = new Intent(YouwanActivity.this, MainActivity.class);
            startActivity(backintent);
            finish();
        }
        return super.onKeyDown(keyCode, event);

    }
}
