package com.jju.yuxin.xiaoyuantong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.jju.yuxin.xiaoyuantong.R;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong
 * Created by yuxin.
 * Created time 2016/10/9 0009 下午 3:49.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class PingMianActivity extends Activity {

    private Spinner spxiaoqu;
    private ImageView imback;
    private int map[] = new int[]{R.drawable.zhumap, R.drawable.xundong, R.drawable.lufeng, R.drawable.nanhu,};
    private LinearLayout ll;
    private float StartX,StartY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        InitListener();
    }

    private void initialize() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pingmian);
        spxiaoqu = (Spinner) findViewById(R.id.sp_xiaoqu);
        imback = (ImageView) findViewById(R.id.im_back);
        ll = (LinearLayout) findViewById(R.id.ll);
        MyListener listener = new MyListener();
        ll.setOnTouchListener(listener);
    }

    private void InitListener() {
        spxiaoqu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ll.scrollTo(0,0);
                LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

                imback.setLayoutParams(params);
                imback.setImageResource(map[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private class MyListener implements View.OnTouchListener {
        float CurrX=0,CurrY=0;
        float StartLine=0,EndLine=0;
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (event.getPointerCount()==1){
                        StartX=event.getX();
                        StartY=event.getY();
                    }

                    break;
                case MotionEvent.ACTION_MOVE:
                    if (event.getPointerCount()==1) {
                        CurrX = event.getX();
                        CurrY = event.getY();
                        ll.scrollBy((int) (StartX - CurrX), (int) (StartY - CurrY));
                        StartX = CurrX;
                        StartY = CurrY;
                    }
                    if (event.getPointerCount()==2){
                        float x1 = event.getX(0);
                        float y1 = event.getY(0);
                        float x2 = event.getX(1);
                        float y2 = event.getY(1);
                        EndLine=(float) Math.sqrt(Math.pow(Math.abs(x1-x2),2)+Math.pow(Math.abs(y1-y2),2));
                        if (StartLine<=0){
                            StartLine=EndLine;
                        }else {
                            LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) imback.getLayoutParams();
                            //缩小
                           if ( StartLine-EndLine>5){
                               params.width=(int) (imback.getWidth()*0.95);
                               params.height=(int) (imback.getHeight()*0.95);
                               imback.setLayoutParams(params);
                               StartLine=EndLine;

                            //放大
                           }else if (StartLine-EndLine<-5){
                               params.width=(int) (imback.getWidth()*1.05);
                               params.height=(int) (imback.getHeight()*1.05);
                               imback.setLayoutParams(params);
                               StartLine=EndLine;
                           }

                        }


                    }
                    
                    break;
                case MotionEvent.ACTION_UP:

                    break;
                default:
                    break;
            }

            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent backintent = new Intent(PingMianActivity.this, SchoolLifeActivity.class);
            startActivity(backintent);
            finish();
        }
        return super.onKeyDown(keyCode, event);

    }
}
