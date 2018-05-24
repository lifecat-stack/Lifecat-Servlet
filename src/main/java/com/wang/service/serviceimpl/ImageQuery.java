package com.wang.service.serviceimpl;

import com.wang.service.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * UserLogin: 用户登录
 * <p>
 * 访问范围: 全局
 * 调用者: Servlet
 * 异常检测: try-catch异常处理层
 * <p>
 * 1. 通过DAOModel获取对应id对象
 * 2. 验证登录表单User是否与数据库相同
 *
 * @auther ten
 */
class ImageQuery implements Service {
    private Logger logger = LoggerFactory.getLogger(ImageQuery.class);

    private ImageQuery() {
    }

    static Service newService() {
        return new ImageQuery();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
}
