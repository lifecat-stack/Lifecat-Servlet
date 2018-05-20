package com.wang.service;

import com.wang.bean.User;
import com.wang.manager.ManagerFactory;
import com.wang.manager.UserManager;
import com.wang.constant.HOST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * UserRegister: 用户注册
 * <p>
 * 访问范围: 全局
 * 调用者: Servlet
 * 异常检测: try-catch异常处理层
 * <p>
 * Form中检测两次密码一致性
 * 1. 通过DAOModel获取DAO
 * 2. 判断是否用户名已存在
 * 2. 若不存在, 向数据库user插入user
 *
 * @auther ten
 */
class UserRegister implements Service {

    private Logger logger;

    private UserRegister() {
        logger = Logger.getLogger("RigisterModel");
    }

    static Service getModel() {
        return new UserRegister();
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        //Form中检测两次密码一致性
        String rusername = req.getParameter("rusername");
        String rpassword1 = req.getParameter("rpassword1");
        String rpassword2 = req.getParameter("rpassword2");

        User user = new User.Builder(rusername, rpassword1).build();

        logger.info(user.toString());

        UserManager daoModel = (UserManager) ManagerFactory.getManagerByName(user.getId(), "UserManager");

        try {
            //判断ID是否存在
            final boolean isNameExited = daoModel.isUserNameExited();
            if (isNameExited) {
                return new ServiceResult.Builder(true).errormsg("用户名已存在").page(HOST.PAGE_INDEX).build();
            }

            //插入user
            daoModel.insertUser(user);

        }/*
         * 注册异常:
         *
         * 1. 返回错误信息
         * 2. 跳转page: index
         */ catch (IllegalArgumentException e) {
            e.printStackTrace();
            return new ServiceResult.Builder(true).errormsg("IllegalArgumentException").page(HOST.PAGE_INDEX).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ServiceResult.Builder(true).errormsg("SQLException").page(HOST.PAGE_INDEX).build();
        }

        /*
         * 注册成功:
         *
         * 1. 设置Session: user
         * 2. 跳转page: userhome
         */
        req.getSession().setAttribute("user", user);
        return new ServiceResult.Builder(false).page(HOST.PAGE_USERHOME).build();
    }
}