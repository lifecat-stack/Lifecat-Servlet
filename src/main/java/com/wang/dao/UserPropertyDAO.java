package com.wang.dao;

import com.wang.doo.UserPropertyDO;

import java.sql.SQLException;

/**
 * dao - user property
 *
 * @auther ten
 */
public interface UserPropertyDAO {
    /**
     * 资料插入 :
     * 插入UserPropertyDO到user_property表
     *
     * @param userPropertyDO userPropertyDO
     * @throws SQLException e
     */
    public void insertUserProperty(UserPropertyDO userPropertyDO) throws SQLException;

    /**
     * 资料查询 :
     * 通过user_id进行查询
     * 获取数据库user_property信息
     * 信息封装在UserPropertyDO中返回
     *
     * @param userId 用户ID
     * @return UserPropertyDO UserPropertyDO
     * @throws SQLException         e
     * @throws NullPointerException 记录不存在
     */
    public UserPropertyDO queryUserProperty(int userId) throws SQLException;
}
