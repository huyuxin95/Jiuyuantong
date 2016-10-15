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
 * Packname com.jju.yuxin.xiaoyuantong
 * Created by yuxin.
 * Created time 2016/10/9 0009 下午 3:18.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class SchoolLifeActivity extends Activity {
    private TextView tvfengjing;
    private TextView tvpingmiantu;
    private TextView tvxinshengzhinan;
    private TextView tvfanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        //监听初始化
        InitListener();
    }

    private void initialize() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_schoolife);
        tvfengjing = (TextView) findViewById(R.id.tv_fengjing);
        tvpingmiantu = (TextView) findViewById(R.id.tv_pingmiantu);
        tvxinshengzhinan = (TextView) findViewById(R.id.tv_xinshengzhinan);
        tvfanhui = (TextView) findViewById(R.id.tv_fanhui);
    }

    private void InitListener() {
        MyListener listener = new MyListener();
        tvfengjing.setOnClickListener(listener);
        tvpingmiantu.setOnClickListener(listener);
        tvxinshengzhinan.setOnClickListener(listener);
        tvfanhui.setOnClickListener(listener);


    }

    private class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //校区平面图
                case R.id.tv_pingmiantu:
                    Intent pingintent=new Intent(SchoolLifeActivity.this,PingMianActivity.class);
                    startActivity(pingintent);
                    finish();
                    break;
                //校园风景图
                case R.id.tv_fengjing:
                    Intent fengintent=new Intent(SchoolLifeActivity.this,FengJingActivity.class);
                    startActivity(fengintent);
                    finish();
                    break;
                //新生指南
                case R.id.tv_xinshengzhinan:
                    Intent Xinintent=new Intent(SchoolLifeActivity.this,XinshengActivity.class);
                    startActivity(Xinintent);
                    finish();
                    break;
                //返回
                case R.id.tv_fanhui:
                    Intent backintent=new Intent(SchoolLifeActivity.this,MainActivity.class);
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

        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent backintent=new Intent(SchoolLifeActivity.this,MainActivity.class);
            startActivity(backintent);
            finish();
        }
        return super.onKeyDown(keyCode, event);

    }
}
