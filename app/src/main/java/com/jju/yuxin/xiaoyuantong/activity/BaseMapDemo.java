package com.jju.yuxin.xiaoyuantong.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.MapView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ===============================* 注释专用*=====================================
 *
 * Packname  baidumapsdk.demo.map
 * ClassName  BaseMapDemo
 * Describe :创建一张百度地图并管理地图的生命周期, 包含个性化地图与普通地图切换功能
 * History:
 *
 * ==============================================================================
 */
public class BaseMapDemo extends Activity {

    @SuppressWarnings("unused")
    private static final String LTAG = BaseMapDemo.class.getSimpleName();
    //地图的视图
    private MapView mMapView;
    //FrameLayout作为地图视图的容器
    FrameLayout layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
//        设置个性化地图样式是生效
        SDKInitializer.initialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        //创建一个新的地图视图   new BaiduMapOptions() 是MapView 初始化选项
        mMapView = new MapView(this, new BaiduMapOptions());
        //初始化View
        initView(this);
        //将一个FrameLayout设置为当前地图的容器
        setContentView(layout);
    }

    /**
     * 初始化View
     */
    private void initView(Context context) {
        //new一个FrameLayout
        layout = new FrameLayout(this);
        //向当前FrameLayout添加地图视图
        layout.addView(mMapView);

    }

    @Override
    protected void onPause() {
        super.onPause();
        // activity 暂停时同时暂停地图控件
        mMapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // activity 恢复时同时恢复地图控件
        mMapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // activity 销毁时同时销毁地图控件
        mMapView.onDestroy();
        //设置个性化地图样式是失效
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            startActivity(new Intent(BaseMapDemo.this, ChuxingActivity.class));
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
