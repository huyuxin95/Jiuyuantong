package com.jju.yuxin.xiaoyuantong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jju.yuxin.xiaoyuantong.R;
import com.jju.yuxin.xiaoyuantong.dao.NumberDataBase;
import com.jju.yuxin.xiaoyuantong.db.NumberOpenHelper;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong.activity
 * Created by yuxin.
 * Created time 2016/10/11 0011 下午 7:53.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class AddNumActivity extends Activity {

    private EditText etnumber;
    private EditText etcate;
    private EditText etname;
    private Button bttijiao;
    private Button btcongzi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnum);
        initialize();
        //监听初始化
        InitListener();
    }


    private void initialize() {
        etnumber = (EditText) findViewById(R.id.et_number);
        etcate = (EditText) findViewById(R.id.et_cate);
        etname = (EditText) findViewById(R.id.et_name);
        bttijiao = (Button) findViewById(R.id.bt_tijiao);
        btcongzi = (Button) findViewById(R.id.bt_congzi);
    }

    private void InitListener() {
        btcongzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etnumber.setText("");
                etcate.setText("");
                etname.setText("");
            }
        });
        bttijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = etnumber.getText().toString().trim();
                String name = etname.getText().toString().trim();
                String cate = etcate.getText().toString().trim();
                NumberDataBase db = new NumberDataBase(AddNumActivity.this);
                db.addNumber(name, number, cate);
                Toast.makeText(AddNumActivity.this, "添加成功!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddNumActivity.this, NumberActivity.class));
                finish();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            startActivity(new Intent(AddNumActivity.this, NumberActivity.class));
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
