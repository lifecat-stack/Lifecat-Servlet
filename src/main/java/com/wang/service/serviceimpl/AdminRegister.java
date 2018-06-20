package com.wang.service.serviceimpl;

import com.wang.service.Service;
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
 class AdminRegister implements Service {
    private Logger logger = LoggerFactory.getLogger(AdminRegister.class);

    private AdminRegister() {
    }

    static Service newService() {
        return new AdminRegister();
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO 管理员注册功能
        return null;
    }
}
