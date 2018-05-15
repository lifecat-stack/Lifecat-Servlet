package com.wang.servicemodel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * UserLoginModel: 用户登录
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
 class UpImageModel implements ServiceModel {
     private Logger logger;


    private UpImageModel() {
        logger=Logger.getLogger("UpImageModel");

    }

    static ServiceModel getModel() {
        return new UpImageModel();
    }

    @Override
    public ModelResult execute(HttpServletRequest req, HttpServletResponse resp) {

        return null;
    }
}
