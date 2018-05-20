package com.wang.dao;

import com.wang.doo.UserDO;

import java.sql.SQLException;

/**
 * dao - user
 *
 * @auther ten
 */
public interface UserDAO {
    /**
     * 注册 :
     * 插入UserDO到user表
     * 返回自增长主键user_id
     *
     * @param userDO UserDO
     * @return user_id
     * @throws SQLException e
     */
    int insertUser(UserDO userDO) throws SQLException;

    /**
     * 登录 :
     * 通过user_name(uk)进行查询
     * 获取数据库user信息
     * user信息封装在UserDO中返回
     *
     * @param userName 用户名
     * @return UserDO UserDO
     * @throws SQLException         e
     * @throws NullPointerException 记录不存在
     */
    UserDO queryUser(String userName) throws SQLException;

    /**
     * 注册-用户是否存在 :
     * 通过user_name(uk)进行查询
     * 判断user是否存在
     *
     * @param userName 用户名
     * @return boolean 用户名是否存在
     */
    boolean isUserExisted(String userName) throws SQLException;

    /**
     * 密码更新 :
     * 通过useName获取密码
     *
     * @param userName 用户名
     * @return user_password
     * @throws SQLException e
     */
    String queryUserPassword(String userName) throws SQLException;

    /**
     * 密码更新 :
     * 更新用户密码
     *
     * @param password 新密码
     * @throws SQLException e
     */
    void updateUserPassword(String password) throws SQLException;
}
