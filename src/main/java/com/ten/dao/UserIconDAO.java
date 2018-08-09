package com.ten.dao;

import com.ten.bean.entity.UserIconDO;

import java.sql.SQLException;

/**
 * dao - user icon
 *
 * @auther ten
 */
public interface UserIconDAO {
    /**
     * 用户头像插入 :
     * 用户注册时调用
     * 插入默认UserIconDO到user_icon表
     *
     * @param userIconDO userIconDO
     * @throws SQLException e
     */
    void insertUserIcon(UserIconDO userIconDO) throws SQLException;

    /**
     * 用户头像更新 :
     * 更新user_icon表
     *
     * @param userIconDO userIconDO
     * @throws SQLException e
     */
    void updateUserIcon(UserIconDO userIconDO) throws SQLException;

    /**
     * 用户头像路径查询 :
     * 通过user_id进行查询路径Path
     *
     * @param userId 用户ID
     * @return user_icon_path String
     * @throws SQLException         e
     * @throws NullPointerException 记录不存在
     */
    String queryUserIcon(Integer userId) throws SQLException;

}
