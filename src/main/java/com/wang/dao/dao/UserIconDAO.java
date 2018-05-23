package com.wang.dao.dao;

import com.wang.doo.UserIconDO;

import java.sql.SQLException;

/**
 * dao - user icon
 *
 * @auther ten
 */
public interface UserIconDAO {
    /**
     * 用户头像更新 :
     * 插入UserIconDO到user_icon表
     *
     * @param userIconDO userIconDO
     * @throws SQLException e
     */
    void insertUserIcon(UserIconDO userIconDO) throws SQLException;

    /**
     * 用户头像查询 :
     * 通过user_id进行查询
     * 获取数据库user_icon信息
     *
     * @param userId 用户ID
     * @return user_icon_path String
     * @throws SQLException         e
     * @throws NullPointerException 记录不存在
     */
    String queryUserIcon(int userId) throws SQLException;

}
