package com.jju.yuxin.xiaoyuantong.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.jju.yuxin.xiaoyuantong.R;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong.activity
 * Created by yuxin.
 * Created time 2016/10/11 0011 下午 11:06.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class GetLocation extends Activity {

    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mLocationClient = new LocationClient(getApplicationContext());//声明LocationClient类
        mLocationClient.registerLocationListener(myListener);//注册监听函数

        LocationClientOption option = new LocationClientOption();//设置请求参数
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//设置定位模式
        option.setCoorType("bd09ll");//返回的定位结果是百度经纬度,默认值gcj02
        option.setScanSpan(5000);//设置发起定位请求的间隔时间为5000ms
        option.setIsNeedAddress(true);//返回的定位结果包含地址信息
        option.setNeedDeviceDirect(true);//返回的定位结果包含手机机头的方向
        mLocationClient.setLocOption(option);

        mLocationClient.start();//启动请求

        if (mLocationClient != null && mLocationClient.isStarted()){

            mLocationClient.requestLocation();
        }
        else{
            Log.d("Location", "locClient is null or not started");
        }

    }

    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location == null)
                return;
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());
            sb.append(" error code : ");
            sb.append(location.getLocType());
            sb.append("latitude :");
            sb.append(location.getLatitude());
            sb.append("lontitude :");
            sb.append(location.getLongitude());
            sb.append("radius : ");
            sb.append(location.getRadius());
            if (location.getLocType() == BDLocation.TypeGpsLocation) {
                sb.append(" speed :");
                sb.append(location.getSpeed());
                sb.append("satellite :");
                sb.append(location.getSatelliteNumber());
            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
                sb.append("addr :");
                sb.append(location.getAddrStr());
            }
            Log.v("--->", "=========");
            Log.v("--->", sb.toString());
        }
    }
}
