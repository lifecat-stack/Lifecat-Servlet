package com.wang.service.serviceimpl;

import com.wang.service.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * UserPswUpdate: 修改密码
 * <p>
 * 访问范围: 全局
 * 调用者: Servlet
 * 异常检测: try-catch异常处理层
 * <p>
 * 1. 通过DAOModel获取DAO, 获取Session user
 * 2. 向数据库user更新password
 * <p>
 * ps: updateUserPsw(old,new)负责进行原密码校验
 *
 * @auther ten
 */
class UserPswUpdate implements Service {

    private Logger logger = LoggerFactory.getLogger(UserPswUpdate.class);

    private UserPswUpdate() {
    }

    static Service newService() {
        return new UserPswUpdate();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO
        return null;
    }
}

