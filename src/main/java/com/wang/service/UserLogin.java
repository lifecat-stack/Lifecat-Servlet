package com.wang.service;

import com.wang.bean.User;
import com.wang.manager.ManagerFactory;
import com.wang.manager.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
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
class UserLogin implements Service {

    private Logger logger;

    private UserLogin() {
        logger = Logger.getLogger("UserLogin");
    }

    static Service getModel() {
        return new UserLogin();
    }


    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User.Builder(username, password).build();

        logger.info(user.toString());

        UserManager daoModel = (UserManager) ManagerFactory.getManagerByName(user.getId(), "UserManager");

        User dbuser;

        //从数据库获取User对象
        try {
            dbuser = daoModel.queryUser();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ServiceResult.Builder(true).errormsg("数据库无此用户").page(req.getRequestURI()).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ServiceResult.Builder(true).errormsg("数据库查询异常").page(req.getRequestURI()).build();
        }

        //判断user是否相同
        final boolean isEquals = (dbuser.getName().equals(username) && dbuser.getPassword().equals(password));
        if (isEquals) {
            req.getSession().setAttribute("user",user);
            return new ServiceResult.Builder(false).page(req.getRequestURI()).build();
        }

        return new ServiceResult.Builder(true).errormsg("账号或密码错误").page(req.getRequestURI()).build();
    }
}

