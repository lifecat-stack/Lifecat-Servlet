package com.wang.manager;

import com.wang.bean.entity.AdminDO;
import com.wang.bean.vo.AdminVO;

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
     * @return AdminVO DTO
     * @throws
     */
    public AdminVO adminLogin(AdminDO adminDO);

    /**
     * 管理员注册
     *
     * @param adminDO DO
     * @return AdminVO DTO
     * @throws
     */
    public AdminVO adminRegister(AdminDO adminDO);
}
