package com.jju.yuxin.xiaoyuantong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.jju.yuxin.xiaoyuantong.R;
import com.jju.yuxin.xiaoyuantong.domain.Youwan;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong
 * Created by yuxin.
 * Created time 2016/10/9 0009 下午 8:37.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class JingDianActivity extends Activity {
    private ImageView imjingdian;
    private TextView ivshow;
    private Youwan jingdian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jingdian);
        jingdian = getIntent().getParcelableExtra("jingdian");
        initialize();
        imjingdian.setImageResource(jingdian.img);
        ivshow.setText(jingdian.show);
    }

    private void initialize() {
        imjingdian = (ImageView) findViewById(R.id.im_jingdian);
        ivshow = (TextView) findViewById(R.id.iv_show);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent backintent = new Intent(JingDianActivity.this, YouwanActivity.class);
            startActivity(backintent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
