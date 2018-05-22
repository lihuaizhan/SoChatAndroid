package com.neishenmo.sochat.sochatandroid.view.particular;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.gyf.barlibrary.ImmersionBar;
import com.neishenmo.sochat.sochatandroid.R;
import com.neishenmo.sochat.sochatandroid.view.MainActivity;

public class AMapActivity extends AppCompatActivity {
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private ImmersionBar mImmersionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        getSupportActionBar().hide();
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarColor(R.color.colorTheme).fitsSystemWindows(true).init();   //所有子类都将继承这些相同的属性
        setContentView(R.layout.activity_amap);
        mMapView = (MapView) findViewById(R.id.mmap);
        mBaiduMap = mMapView.getMap();
        SharedPreferences location = getSharedPreferences("location", 0);
        float lon = Float.parseFloat(location.getString("lon", ""));
        float lat = Float.parseFloat(location.getString("lat", ""));
        mBaiduMap.setMyLocationEnabled(true);
// 构造定位数据
        MyLocationData locData = new MyLocationData.Builder()
                .accuracy(500)
                // 此处设置开发者获取到的方向信息，顺时针0-360
                .direction(100).latitude(lat)
                .longitude(lon).build();

// 设置定位数据
        mBaiduMap.setMyLocationData(locData);

// 设置定位图层的配置（定位模式，是否允许方向信息，用户自定义定位图标）
        BitmapDescriptor mCurrentMarker  = BitmapDescriptorFactory
                .fromResource(R.drawable.ic_launcher);

        Bitmap bitmap = Bitmap.createBitmap(1, 1
                ,
                Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Color.parseColor("#AAE22018"));//填充颜色
        BitmapDescriptor mCurrentMarker1  = BitmapDescriptorFactory.fromBitmap(bitmap);
        MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING, true, mCurrentMarker1, 0xAAE22018, 0xAAE22018);
        mBaiduMap.setMyLocationConfiguration(config);
//        MyLocationData locData = new MyLocationData.Builder()
//                .accuracy(location.getFloat("rudio", 0))
//                .direction(location.getFloat("rudio", 0)).latitude(lat)
//                .longitude(lon).build();
//        mBaiduMap.setMyLocationData(locData);
//               BitmapDescriptor mCurrentMarker  = BitmapDescriptorFactory
//               .fromResource(R.drawable.location_icon);
//       MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING, true, mCurrentMarker, Color.RED, 0xAA00FF00);
//        mBaiduMap.setMyLocationConfiguration(config);
        if (true) {
            LatLng ll = new LatLng(lat, lon);
            MapStatus.Builder builder = new MapStatus.Builder();
            builder.target(ll).zoom(15.0f);
            mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
        }

    }


//
//        // 开启定位图层
//        mBaiduMap.setMyLocationEnabled(true);
//// 构造定位数据
//        MyLocationData locData = new MyLocationData.Builder()
//                .accuracy(location.getFloat("rudio",0))
//                // 此处设置开发者获取到的方向信息，顺时针0-360
//                .direction(360).latitude(lat)
//                .longitude(lon).build();
//
//// 设置定位数据
//        mBaiduMap.setMyLocationData(locData);
//
//// 设置定位图层的配置（定位模式，是否允许方向信息，用户自定义定位图标）
//        BitmapDescriptor mCurrentMarker  = BitmapDescriptorFactory
//                .fromResource(R.drawable.location_icon);
//
//        MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING, true, mCurrentMarker, Color.RED, 0xAA00FF00);
//        mBaiduMap.setMyLocationConfiguration(config);
//
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
//        mMapView.onDestroy();
//    }
//
//    @Override
//    public void getData(String lon, String lat, String address, BDLocation location) {
//        String lon1 = lon;
//        // 开启定位图层
//        mBaiduMap.setMyLocationEnabled(true);
//// 构造定位数据
//        MyLocationData locData = new MyLocationData.Builder()
//                .accuracy(location.getRadius())
//                // 此处设置开发者获取到的方向信息，顺时针0-360
//                .direction(100).latitude(location.getLatitude())
//                .longitude(location.getLongitude()).build();
//
//// 设置定位数据
//        mBaiduMap.setMyLocationData(locData);
//
//// 设置定位图层的配置（定位模式，是否允许方向信息，用户自定义定位图标）
//        BitmapDescriptor mCurrentMarker  = BitmapDescriptorFactory
//                .fromResource(R.drawable.ic_launcher);
//
//        MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING, true, mCurrentMarker, 0xAAFFFF88, 0xAA00FF00);
//        mBaiduMap.setMyLocationConfiguration(config);
//
//
//    }
}
