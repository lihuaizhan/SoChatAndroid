package com.neishenmo.sochat.sochatandroid.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2018-05-10.
 */

public class StringUtil {
    public static String toUtf8(String str) {
        try {
            String strGBK = URLEncoder.encode(str, "GBK");
            System.out.println(strGBK);
            String strUTF8 = URLDecoder.decode(str, "UTF-8");
            return  strUTF8;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
      return null;}
}
