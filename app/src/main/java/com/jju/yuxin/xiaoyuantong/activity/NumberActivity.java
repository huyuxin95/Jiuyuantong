package com.jju.yuxin.xiaoyuantong.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.jju.yuxin.xiaoyuantong.R;
import com.jju.yuxin.xiaoyuantong.dao.NumberDataBase;

import java.util.List;
import java.util.Map;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong.activity
 * Created by yuxin.
 * Created time 2016/10/9 0009 下午 9:45.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class NumberActivity extends Activity {

    private ExpandableListView exlv;
    private ImageView iv_more_add;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_number);
        initialize();
        initListener();
        Initdate();
    }

    private void initListener() {
        iv_more_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv_add=new TextView(NumberActivity.this);
                tv_add.setText("添加");
                tv_add.setGravity(Gravity.CENTER);
                tv_add.setTextColor( Color.parseColor("#FFFFFFFF"));
                tv_add.setTextSize(25);
                popupWindow = new PopupWindow(tv_add,180, 80);
                popupWindow.setBackgroundDrawable(new ColorDrawable(
                        Color.parseColor("#F9A150")));
                popupWindow.showAsDropDown(iv_more_add);
                popupWindow.setFocusable(false);
                tv_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismissPopupWindow();
                       startActivity(new Intent(NumberActivity.this,AddNumActivity.class));
                        finish();
                    }
                });

            }
        });
    }

    private void Initdate() {
        NumberDataBase numberDataBase = new NumberDataBase(this);
        List<Map<String, String>> groupData = numberDataBase.getGroupData();
        List<List<Map<String, String>>> childData = numberDataBase.getChildData();
        final SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                R.layout.simple_list_item_1,
                new String[]{"cate"},
                new int[]{R.id.text1},
                childData,
                android.R.layout.simple_list_item_2,
                new String[]{"name", "number"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );
        exlv.setAdapter(adapter);

    }

    private void initialize() {
        exlv = (ExpandableListView) findViewById(R.id.ex_lv);
        iv_more_add = (ImageView) findViewById(R.id.iv_more_add);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent backintent = new Intent(NumberActivity.this, MainActivity.class);
            startActivity(backintent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void dismissPopupWindow() {
        if (popupWindow!=null&&popupWindow.isShowing()){
            popupWindow.dismiss();
            popupWindow=null;
        }
    }
}
