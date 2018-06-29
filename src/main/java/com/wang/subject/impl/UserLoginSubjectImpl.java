package com.wang.subject.impl;

import com.wang.subject.UserLoginSubject;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 统计在线人数
 *
 * @date 2018/6/28
 * @auther ten
 */
public class UserLoginSubjectImpl extends Observable implements UserLoginSubject {
    /**
     * 在线人数
     */
    private static int userCount = 0;
    /**
     * 观察者列表
     */
    private static List<Observer> observers = null;

    /**
     * 增加在线人数
     */
    @Override
    public void increaseUserCount() {
        userCount++;

        setChanged();
        notifyObservers(userCount);
    }

    /**
     * 减少在线人数
     */
    @Override
    public void decreaseUserCount() {
        userCount--;

        setChanged();
        notifyObservers(userCount);
    }

    /**
     * 获取在线人数
     */
    @Override
    public int getUserCount() {
        return userCount;
    }

}
