package com.neishenmo.sochat.sochatandroid.utils;


import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018-04-26.
 */

public class TimeConvertUtil {
    //计算登陆时间转换
    public static String getTimeInterval(String inputTime) {

        // inputTime传入的时间格式必须类似于“yyyy-MM-dd HH:mm:ss”这样的格式

        if (inputTime.length() != 19) {
            return inputTime;
        }

        String result = null;

        try {

            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            //  ParsePosition 是指从哪个位置开始索引

            ParsePosition pos = new ParsePosition(0);

            Date d1 = sd.parse(inputTime, pos);

            // 用现在距离1970年的时间间隔new

            // Date().getTime()减去以前的时间距离1970年的时间间隔d1.getTime()得出的就是以前的时间与现在时间的时间间隔

            long time = new Date().getTime() - d1.getTime();// 得出的时间间隔是毫秒

            if (time / 1000 < 60) {

                // 如果时间间隔小于等于60秒则显示“刚刚”

                result = "刚刚";

            } else if (time / 60000 < 60) {

                // 如果时间间隔小于60分钟则显示多少分钟前

                result = time / 60000 + "分钟前";

            } else if (time / 3600000 < 24) {

                // 如果时间间隔小于24小时则显示多少小时前

                result = time / 3600000 + "小时前";

            } else if (time / 86400000 < 2) {

                // 如果时间间隔小于2天则显示昨天（3600000*24）

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                result = sdf.format(d1.getTime());

                result = "昨天" +result;

            } else if (time / 86400000 < 3) {

                // 如果时间间隔小于3天则显示前天

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                result = sdf.format(d1.getTime());

                result = "前天" +result;

            } else if (time / 86400000 < 30) {

                // 如果时间间隔小于30天则显示多少天前

                result = time / 86400000 + "天前";

            } else if (time / 86400000 < 60) {

                result = "1个月前";

            } else if (time / 86400000 < 90) {

                result = "2个月前";

            } else if (time / 86400000 < 120) {

                result = "3个月前";

            } else if (time / 86400000 < 150) {

                result = "4个月前";

            } else if (time / 86400000 < 180) {

                result = "5个月前";

            } else if (time / 86400000 < 210) {

                result = "6个月前";

            } else if (time / 86400000 < 240) {

                result = "7个月前";

            } else if (time / 86400000 < 270) {

                result = "8个月前";

            } else if (time / 86400000 < 300) {

                result = "9个月前";

            } else if (time / 86400000 < 330) {

                result = "10个月前";

            } else if (time / 86400000 < 360) {

                result = "11个月前";

            } else if (time / 86400000 < 720) {

                result = "1年前";

            } else if (time / 86400000 < 1080) {

                result = "2年前";

            } else {

                // 大于2年，显示年月日时间

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

                result = sdf.format(d1.getTime());

            }

        } catch (Exception e) {

            return inputTime;

        }

        return result;


    }
     //把字符串转为日期
    public static int ConverToDate(String strDate) throws Exception
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return getAge(df.parse(strDate));
    }
    public static int getAge(Date birthDate) {

        if (birthDate == null)
            throw new
                    RuntimeException("出生日期不能为null");

        int age = 0;

        Date now = new Date();

        SimpleDateFormat format_y = new
                SimpleDateFormat("yyyy");
        SimpleDateFormat format_M = new
                SimpleDateFormat("MM");

        String birth_year =
                format_y.format(birthDate);
        String this_year =
                format_y.format(now);

        String birth_month =
                format_M.format(birthDate);
        String this_month =
                format_M.format(now);

        // 初步，估算
        age =
                Integer.parseInt(this_year) - Integer.parseInt(birth_year);

        // 如果未到出生月份，则age - 1
        if
                (this_month.compareTo(birth_month) < 0)
            age -=
                    1;
        if (age <
                0)
            age =
                    0;
        return age;
    }
}
