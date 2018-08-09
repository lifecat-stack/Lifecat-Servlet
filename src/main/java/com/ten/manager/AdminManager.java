package com.ten.manager;

import com.ten.bean.entity.AdminDO;
import com.ten.bean.vo.AdminVO;

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
