package com.wang.service.impl;

import com.wang.bean.doo.AdminDO;
import com.wang.service.util.Service;
import com.wang.service.AdminRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员注册
 *
 * @date 2018/5/24
 * @auther ten
 */
 class AdminRegisterServiceImpl implements AdminRegisterService {
    private Logger logger = LoggerFactory.getLogger(AdminRegisterServiceImpl.class);

    private AdminRegisterServiceImpl() {
    }

    static Service newService() {
        return new AdminRegisterServiceImpl();
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
