package com.wang.manager;

import com.wang.bean.doo.AdminDO;
import com.wang.bean.dto.AdminDTO;

/**
 * Admin模块管理器
 *
 * @date 2018/6/29
 * @auther ten
 */
public interface AdminManager extends Manager {
    /**
     * 管理员登录
     *
     * @param adminDO DO
     * @return AdminDTO DTO
     * @throws
     */
    public AdminDTO adminLogin(AdminDO adminDO);

    /**
     * 管理员注册
     *
     * @param adminDO DO
     * @return AdminDTO DTO
     * @throws
     */
    public AdminDTO adminRegister(AdminDO adminDO);
}
