package com.wang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @name Date
 * @description 获取当前时间:使用单例模式
 * @auther ten
 */
public class MyDate {
    //仅第一次调用时加载
    private static final MyDate INSTANCE = new MyDate();

    //私有构造方法
    private MyDate() {
        System.out.println("MyDate加载:"+this);
    }

    //静态工厂获取单例
    public static MyDate getInstance() {
        return INSTANCE;
    }

    //获取当前日期时间
    public String getCurrentTime() {
        String temp_str = "";
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
        temp_str = sdf.format(dt);
        return temp_str;
    }

    //返回当前时间
    @Override
    public String toString() {
        return this.getCurrentTime();
    }
}
