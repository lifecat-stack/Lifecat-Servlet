package com.ten.lifecat.servlet.service.impl;

import com.ten.lifecat.servlet.entity.Admin;
import com.ten.service.AdminRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO 管理员注册
 *
 * @date 2018/5/24
 * @auther ten
 */
public class AdminRegisterServiceImpl implements AdminRegisterService {
    private Logger logger = LoggerFactory.getLogger(AdminRegisterServiceImpl.class);

    public AdminRegisterServiceImpl() {
    }

    /**
     * TODO 管理员注册功能
     */
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.error("功能未开放");
        return null;
    }

    @Override
    public boolean isAdminExisted(String adminName) {
        return false;
    }

    @Override
    public void insertAdminToDatabase(Admin admin) {
    }
}
