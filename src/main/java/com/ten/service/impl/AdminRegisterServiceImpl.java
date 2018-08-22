package com.ten.service.impl;

import com.ten.bean.entity.AdminDO;
import com.ten.service.AdminRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员注册
 * TODO 功能未开放
 *
 * @date 2018/5/24
 * @auther ten
 */
public class AdminRegisterServiceImpl implements AdminRegisterService {

    private Logger logger = LoggerFactory.getLogger(AdminRegisterServiceImpl.class);

    public AdminRegisterServiceImpl() {
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO 管理员注册功能
        return null;
    }

    @Override
    public boolean isAdminExisted(String adminName) {
        return false;
    }

    @Override
    public void insertAdminToDatabase(AdminDO adminDO) {
    }
}
