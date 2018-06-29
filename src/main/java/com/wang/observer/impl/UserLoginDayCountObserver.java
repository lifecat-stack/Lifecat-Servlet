package com.wang.observer.impl;

import com.wang.observer.UserLoginObserver;
import com.wang.subject.impl.UserLoginSubjectImpl;

import java.util.Observable;

/**
 * 观察 - 每日用户登录数量
 *
 * @date 2018/6/29
 * @auther ten
 */
public class UserLoginDayCountObserver implements UserLoginObserver {
    /**
     * 主题对象
     */
    private UserLoginSubjectImpl subject;

    /**
     * 注册观察者
     */
    public UserLoginDayCountObserver() {
        subject = new UserLoginSubjectImpl();
        subject.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
