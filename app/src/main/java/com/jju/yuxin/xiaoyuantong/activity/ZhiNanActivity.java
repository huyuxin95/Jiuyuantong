package com.jju.yuxin.xiaoyuantong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.TextView;

import com.jju.yuxin.xiaoyuantong.R;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong
 * Created by yuxin.
 * Created time 2016/10/9 0009 下午 6:58.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class ZhiNanActivity extends Activity {
    private TextView tvzhinanall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        InitListener();
    }


    private void initialize() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_zhinan);
        tvzhinanall = (TextView) findViewById(R.id.tv_zhinan_all);
    }

    private void InitListener() {
        int flags = getIntent().getFlags();
        switch (flags) {
            case 0:
                tvzhinanall.setText(R.string.zhengli);
                break;
            case 1:
                tvzhinanall.setText(R.string.mudidi);
                break;
            case 2:
                tvzhinanall.setText(R.string.diyizhan);
                break;
            case 3:
                tvzhinanall.setText(R.string.yigebing);
                break;
            case 4:
                tvzhinanall.setText(R.string.wanhuatong);
                break;
            case 5:
                tvzhinanall.setText(R.string.xinpengyou);
                break;
            case 6:
                tvzhinanall.setText(R.string.youbuzhu);
                break;
            case 7:
                tvzhinanall.setText(R.string.jiyu);
                break;
            default:
                break;
        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent backintent = new Intent(ZhiNanActivity.this, XinshengActivity.class);
            startActivity(backintent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
