package com.jju.yuxin.xiaoyuantong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.jju.yuxin.xiaoyuantong.R;

import java.util.ArrayList;
import java.util.List;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong
 * Created by yuxin.
 * Created time 2016/10/9 0009 下午 4:56.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class XinshengActivity extends Activity {


    private static final String TAG = "XinshengActivity";
    private TextView tvzhinan8;
    private TextView tvzhinan2;
    private TextView tvzhinan7;
    private TextView tvzhinan6;
    private TextView tvzhinan3;
    private TextView tvzhinan5;
    private TextView tvzhinan1;
    private TextView tvzhinan4;
    private List<TextView> tv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        //监听初始化
        InitListener();
    }

    private void initialize() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_xinsheng);
        tvzhinan8 = (TextView) findViewById(R.id.tv_zhinan_8);
        tvzhinan2 = (TextView) findViewById(R.id.tv_zhinan_2);
        tvzhinan7 = (TextView) findViewById(R.id.tv_zhinan_7);
        tvzhinan6 = (TextView) findViewById(R.id.tv_zhinan_6);
        tvzhinan3 = (TextView) findViewById(R.id.tv_zhinan_3);
        tvzhinan5 = (TextView) findViewById(R.id.tv_zhinan_5);
        tvzhinan1 = (TextView) findViewById(R.id.tv_zhinan_1);
        tvzhinan4 = (TextView) findViewById(R.id.tv_zhinan_4);
        tv_list = new ArrayList<>();
        tv_list.add(tvzhinan1);
        tv_list.add(tvzhinan2);
        tv_list.add(tvzhinan3);
        tv_list.add(tvzhinan4);
        tv_list.add(tvzhinan5);
        tv_list.add(tvzhinan6);
        tv_list.add(tvzhinan7);
        tv_list.add(tvzhinan8);
    }

    private void InitListener() {
        for (final TextView tv : tv_list) {
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int indexOf = tv_list.indexOf(tv);
                    Log.i(TAG, "onClick" + "indexOf:" + indexOf);
                    Intent intent = new Intent(XinshengActivity.this, ZhiNanActivity.class);
                    intent.addFlags(indexOf);
                    startActivity(intent);
                    finish();
                }
            });

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent backintent = new Intent(XinshengActivity.this, SchoolLifeActivity.class);
            startActivity(backintent);
            finish();
        }
        return super.onKeyDown(keyCode, event);

    }

}
