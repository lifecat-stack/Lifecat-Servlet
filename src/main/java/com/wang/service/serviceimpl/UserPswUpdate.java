package com.wang.service.serviceimpl;

import com.wang.service.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 更新用户密码
 *
 * @date 2018/5/24
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

