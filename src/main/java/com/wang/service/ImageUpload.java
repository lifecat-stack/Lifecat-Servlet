package com.wang.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

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
 class ImageUpload implements Service {
     private Logger logger;


    private ImageUpload() {
        logger=Logger.getLogger("ImageUpload");

    }

    static Service getModel() {
        return new ImageUpload();
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        return null;
    }
}
