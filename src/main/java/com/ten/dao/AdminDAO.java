package com.ten.dao;

import com.ten.bean.entity.Admin;

import java.sql.SQLException;

/**
 * dao - admin
 *
 * @auther ten
 */
public interface AdminDAO {
    /**
     * 注册 :
     * 插入AdminDO到admin表
     *
     * @param admin Admin
     * @throws SQLException e
     */
    void insertAdmin(Admin admin) throws SQLException;

    /**
     * 登录 :
     * 通过admin_name(uk)进行查询
     * 获取数据库admin信息
     *
     * @param adminName 用户名
     * @return Admin Admin
     * @throws SQLException         e
     * @throws NullPointerException 记录不存在
     */
    Admin queryAdmin(String adminName) throws SQLException;

    /**
     * 注册 :
     * 通过admin_name(uk)进行查询
     * 判断Admin对象是否存在
     *
     * @param adminName 用户名
     * @return boolean 用户名是否存在
     */
    boolean isAdminExisted(String adminName) throws SQLException;
}