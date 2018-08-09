package com.ten.subject;

/**
 * 观察者 - 主题
 * <p>
 * 统计User在线人数
 *
 * @date 2018/6/28
 * @auther ten
 */
public interface UserLoginSubject {
    /**
     * 增加在线人数
     */
    public void increaseUserCount();

    /**
     * 减少在线人数
     */
    public void decreaseUserCount();

    /**
     * 获取在线人数
     */
    public int getUserCount();
}
