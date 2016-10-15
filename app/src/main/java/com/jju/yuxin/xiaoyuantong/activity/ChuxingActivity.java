package com.jju.yuxin.xiaoyuantong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.jju.yuxin.xiaoyuantong.R;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong.activity
 * Created by yuxin.
 * Created time 2016/10/11 0011 下午 8:43.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class ChuxingActivity extends Activity {

    private TextView tvmapfanhui;
    private TextView tvchaweizhi;
    private TextView tvxianlu;
    private TextView tvmylocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chuxing);
        Tvlistener tvlistener = new Tvlistener();

        tvmapfanhui = (TextView) findViewById(R.id.tv_mapfanhui);
        tvchaweizhi = (TextView) findViewById(R.id.tv_chaweizhi);
        tvxianlu = (TextView) findViewById(R.id.tv_xianlu);
        tvmylocation = (TextView) findViewById(R.id.tv_mylocation);

        tvmapfanhui.setOnClickListener(tvlistener);
        tvchaweizhi.setOnClickListener(tvlistener);
        tvxianlu.setOnClickListener(tvlistener);
        tvmylocation.setOnClickListener(tvlistener);
    }


    private class Tvlistener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_mylocation:
                    startActivity(new Intent(ChuxingActivity.this,BaseMapDemo.class));
                    break;
                case R.id.tv_xianlu:
                    startActivity(new Intent(ChuxingActivity.this,BusLineSearchDemo.class));
                    break;
                case R.id.tv_chaweizhi:
                    startActivity(new Intent(ChuxingActivity.this,PoiSearchDemo.class));
                    break;
                case R.id.tv_mapfanhui:
//                    Intent backintent = new Intent(ChuxingActivity.this, MainActivity.class);
//                    startActivity(backintent);
                    Intent backintent = new Intent(ChuxingActivity.this, GetLocation.class);
                    startActivity(backintent);
                    finish();
                    break;
                default:
                    break;
            }


        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent backintent = new Intent(ChuxingActivity.this, MainActivity.class);
            startActivity(backintent);
            finish();
        }
        return super.onKeyDown(keyCode, event);

    }
}
