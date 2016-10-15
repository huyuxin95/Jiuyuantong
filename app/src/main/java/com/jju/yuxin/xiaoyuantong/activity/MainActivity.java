package com.jju.yuxin.xiaoyuantong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.jju.yuxin.xiaoyuantong.R;

public class MainActivity extends Activity {

    private ImageView ivchuxingzhinan;
    private ImageView ivxuexiaoshenghuo;
    private ImageView ivyouwan;
    private ImageView ivhaomabaishitong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //控件初始化
        initialize();
        //监听初始化
        InitListener();
    }

    /**
     * 初始化界面控件
     */
    private void initialize() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ivchuxingzhinan = (ImageView) findViewById(R.id.iv_chuxingzhinan);
        ivxuexiaoshenghuo = (ImageView) findViewById(R.id.iv_xuexiaoshenghuo);
        ivyouwan = (ImageView) findViewById(R.id.iv_youwan);
        ivhaomabaishitong = (ImageView) findViewById(R.id.iv_haomabaishitong);
    }

    /**
     * 为ImageView设置监听
     */
    private void InitListener() {
        MyListener listener=new MyListener();
        ivchuxingzhinan.setOnClickListener(listener);
        ivxuexiaoshenghuo.setOnClickListener(listener);
        ivyouwan.setOnClickListener(listener);
        ivhaomabaishitong.setOnClickListener(listener);
    }

    private class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                //出行指南
                case R.id.iv_chuxingzhinan:
                    Intent Chuintent=new Intent(MainActivity.this,ChuxingActivity.class);
                    startActivity(Chuintent);
                    finish();
                    break;
                //学校生活
                case R.id.iv_xuexiaoshenghuo:
                    Intent Schoolintent=new Intent(MainActivity.this,SchoolLifeActivity.class);
                    startActivity(Schoolintent);
                    finish();
                    break;
                //游玩
                case R.id.iv_youwan:
                    Intent Youwanintent=new Intent(MainActivity.this,YouwanActivity.class);
                    startActivity(Youwanintent);
                    finish();
                    break;
                //号码百事通
                case R.id.iv_haomabaishitong:
                    Intent Numberintent=new Intent(MainActivity.this,NumberActivity.class);
                    startActivity(Numberintent);
                    finish();
                    break;
                default:
                    break;
            }

        }
    }

}
