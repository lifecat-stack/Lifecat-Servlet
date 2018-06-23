package com.wang.service.service;

import com.wang.bean.doo.AdminDO;
import com.wang.service.Service;

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
    void insertAdminToDatabase(AdminDO adminDO);
}
