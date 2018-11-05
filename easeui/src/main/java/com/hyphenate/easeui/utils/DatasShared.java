package com.hyphenate.easeui.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * 数据存取
 *
 * @author
 */
public class DatasShared {
	public static SharedPreferences infoSP;
	public static SharedPreferences nameSP;
	private static final String LATITUDE = "latitude";
	private static final String LONGITUDE = "longitude";

	public DatasShared(Context context) {
		infoSP = context.getSharedPreferences("neishenme_easeui_picture", Context.MODE_PRIVATE);
		nameSP = context.getSharedPreferences("neishenme_easeui_name", Context.MODE_PRIVATE);
	}

	public static void setLatitude( String latitude) {
		infoSP.edit().putString(LATITUDE, latitude).apply();
	}

	public static String getLatitude() {
		Log.e("获取经度","用户获取到的数值为：" + infoSP.getString(LATITUDE, "无数据"));
		return infoSP.getString(LATITUDE, "0");
	}

	public static void setLongitude( String longitude) {
		infoSP.edit().putString(LONGITUDE, longitude).apply();
	}

	public static String getLongitude() {
		Log.e("获取纬度","用户获取到的数值为：" + infoSP.getString(LONGITUDE, "无数据"));
		return infoSP.getString(LONGITUDE, "0");
	}

	public static void setHXInfo(String hxinfo, String hxvalue) {
		infoSP.edit().putString(hxinfo, hxvalue).apply();
	}

	public static String getHXInfo(String hxinfo) {
//		Log.e("环信获取头像","用户获取到的数值为：" + infoSP.getString(hxinfo, "无数据"));
		return infoSP.getString(hxinfo, null);
	}

	public static void setHXNickName(String hxinfo, String hxvalue) {
		nameSP.edit().putString(hxinfo, hxvalue).apply();
	}

	public static String getHXNickName(String hxinfo) {
//		Log.e("存储环信","用户获取到的数值为：" + infoSP.getString(hxinfo, "无数据"));
		return nameSP.getString(hxinfo, null);
	}
}
