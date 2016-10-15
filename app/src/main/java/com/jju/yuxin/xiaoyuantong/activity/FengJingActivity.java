package com.jju.yuxin.xiaoyuantong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jju.yuxin.xiaoyuantong.horizontallistview.HorizontalListView;
import com.jju.yuxin.xiaoyuantong.horizontallistview.HorizontalListViewAdapter;
import com.jju.yuxin.xiaoyuantong.R;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong
 * Created by yuxin.
 * Created time 2016/10/9 0009 下午 4:23.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */


public class FengJingActivity extends Activity {
    private LinearLayout llhs;
    private ImageView ivshow;
    private HorizontalListView hz_lv;
    private int[] imgs=new int[]{R.drawable.jju01,R.drawable.jju02,R.drawable.jju03,
            R.drawable.jju04,R.drawable.jju05,R.drawable.jju06,
            R.drawable.jju07,R.drawable.jju08,R.drawable.jju09,R.drawable.jju10};
    private HorizontalListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialize();
        InitListener();
    }


    private void initialize() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fengjing);
        hz_lv = (HorizontalListView) findViewById(R.id.hz_lv);
        ivshow = (ImageView) findViewById(R.id.iv_show);
    }


    private void InitListener() {
        adapter = new HorizontalListViewAdapter(this, imgs);
        hz_lv.setAdapter(adapter);
        hz_lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ivshow.setImageResource(imgs[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent backintent=new Intent(FengJingActivity.this,SchoolLifeActivity.class);
            startActivity(backintent);
            finish();
        }
        return super.onKeyDown(keyCode, event);

    }
}
