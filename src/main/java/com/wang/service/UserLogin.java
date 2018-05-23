package com.wang.service;

import com.wang.constant.HOST;
import com.wang.dao.dao.DAOFactory;
import com.wang.dao.dao.UserDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.doo.UserDO;
import com.wang.dto.UserDTO;

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

        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        UserDAO dao = factory.getUserDAO();

        // DAO查询user
        UserDO userDO = null;
        boolean success = false;
        try {
            userDO = dao.queryUser(username);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success) {
            return new ServiceResult.Builder(true)
                    .errormsg("数据库查询异常").page(req.getRequestURI()).build();
        }

        if (userDO == null) {
            return new ServiceResult.Builder(true)
                    .errormsg("数据库无此用户").page(req.getRequestURI()).build();
        }

        if (!password.equals(userDO.getUserPassword())) {
            return new ServiceResult.Builder(true)
                    .errormsg("密码错误").page(req.getRequestURI()).build();
        }

        UserDTO user = new UserDTO.Builder(userDO.getUserId(), userDO.getUserName()).build();
        req.getSession().setAttribute("user", user);
        return new ServiceResult.Builder(true).page(HOST.PAGE_USERHOME).build();
    }
}

