package com.wang.dao;

import com.wang.doo.AdminDO;

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
     * 返回自增长主键admin_id
     *
     * @param adminDO AdminDO
     * @return admin_id
     * @throws SQLException e
     */
    int insertAdmin(AdminDO adminDO) throws SQLException;

    /**
     * 登录 :
     * 通过admin_name(uk)进行查询
     * 获取数据库admin信息
     * admin信息封装在AdminDO中返回
     *
     * @param adminName 用户名
     * @return AdminDO AdminDO对象
     * @throws SQLException         e
     * @throws NullPointerException 记录不存在
     */
    AdminDO queryAdmin(String adminName) throws SQLException;

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