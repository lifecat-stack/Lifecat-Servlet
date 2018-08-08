package com.wang.service;

import com.wang.bean.entity.AdminDO;
import com.wang.service.util.Service;

/**
 * 管理员登录
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface AdminLoginService extends Service {
    /**
     * 账号是否存在
     *
     * @param
     * @throws
     */
    boolean isAdminExisted(String adminName);

    /**
     * 获取账号信息
     *
     * @param
     * @throws
     */
    AdminDO queryAdminByName(String adminName);
}
