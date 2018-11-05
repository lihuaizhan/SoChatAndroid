package com.neishenmo.sochat.sochatandroid.utils;

import android.util.Log;

/**
 * Created by Administrator on 2018-04-25.
 * 封装Log打印
 */

public class LogUtils {
    // 设置为false则可以使得Log不输出
    private static boolean enable = true;

    public static void isEnable(boolean enable) {
        LogUtils.enable = enable;
    }

    public static void v(String tag, String msg) {
        if (enable)
            Log.d("" + tag, "" + msg);
    }

    public static void d(String tag, String msg) {
        if (enable)
            Log.d("" + tag, "" + msg);
    }

    public static void i(String tag, String msg) {
        if (enable)
            Log.i("" + tag, "" + msg);
    }

    public static void w(String tag, String msg) {
        if (enable)
            Log.w("" + tag, "" + msg);
    }

    public static void e(String tag, String msg) {
        if (enable)
            Log.e("" + tag, "" + msg);
    }
}
