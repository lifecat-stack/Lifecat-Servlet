package com.ten.lifecat.servlet.service;

import com.ten.lifecat.servlet.entity.Admin;
import com.ten.lifecat.servlet.service.util.Service;
import com.ten.service.util.Service;

/**
 * 管理员注册
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface AdminRegisterService extends Service {
    /**
     * 查询账号是否存在
     *
     * @param
     * @throws
     */
    boolean isAdminExisted(String adminName);

    /**
     * 向数据库注册账号
     *
     * @param
     * @throws
     */
    void insertAdminToDatabase(Admin admin);
}
