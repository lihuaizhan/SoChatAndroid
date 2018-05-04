package com.neishenmo.sochat.sochatandroid.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2018-04-25.
 * 封装Toast打印
 */

public class ToastUtils {
    // 只要控制level的大小，就可以消除部分Toast
    public static int level = 0;

    public static void makeText(Context context, String content, int level) {
        if (ToastUtils.level < level) {
            Toast.makeText(context, "" + content, Toast.LENGTH_SHORT).show();
        }
    }
}
