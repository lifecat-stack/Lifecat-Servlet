package com.wang.db;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @name Date
 * @description 获取当前时间
 * @auther ten
 */
public class MyDate {
    /* 获取时间 */
    public static String GetNowDate() {
        String temp_str = "";
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
        temp_str = sdf.format(dt);
        return temp_str;
    }
}
