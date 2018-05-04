package com.neishenmo.sochat.sochatandroid.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * 小果冻
 * dp转px px 转dp
 * 获取屏幕宽高   控件宽高
 * Created by Administrator on 2018\4\25 0025.
 */

public class dpturnxpUtils {

    /**
     * 根据手机分辨率dp转px
     * @param context
     * @param dpValue
     * @return
     */
    public static int dp2px(Context context , int dpValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return  (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机分辨率px转dp
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dp(Context context, int pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 计算屏幕宽度
     * @param context
     * @return
     */
    public static int wide(Context context){
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        float density = dm.density;
        int width = dm.widthPixels;
        return width;
    }


}
