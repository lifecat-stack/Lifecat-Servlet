package com.wang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @auther ten
 */
public class DateTimeUtil {

    private static volatile DateTimeUtil INSTANCE = null;

    private DateTimeUtil() {
        System.out.println("MyDate延迟加载时间:" + this);
    }

    public static DateTimeUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (DateTimeUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DateTimeUtil();
                }
            }
        }
        return INSTANCE;
    }

    public String getCurrentTime() {
        String tempStr = "";
        Date dt = new Date();
        //aa表示“上午”或“下午” HH表示24小时制 hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
        tempStr = sdf.format(dt);
        return tempStr;
    }

    @Override
    public String toString() {
        return this.getCurrentTime();
    }
}
