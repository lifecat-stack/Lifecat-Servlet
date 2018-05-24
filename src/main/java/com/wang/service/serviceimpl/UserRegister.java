package com.wang.service.serviceimpl;

import com.wang.constant.HOST;
import com.wang.dao.dao.DAOFactory;
import com.wang.dao.dao.UserDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.bean.doo.UserDO;
import com.wang.bean.dto.UserDTO;
import com.wang.service.service.Service;
import com.wang.util.MyDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

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

    private Logger logger = LoggerFactory.getLogger(UserRegister.class);

    private UserRegister() {
    }

    static Service newService() {
        return new UserRegister();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        String rUserName = req.getParameter("rUserName");
        String rUserPassword = req.getParameter("rUserPassword");

        String dateTime = MyDate.getInstance().getCurrentTime();

        DAOFactory factory = new JdbcDAOFactory();
        UserDAO dao = factory.getUserDAO();

        boolean isExisted = true;
        try {
            isExisted = dao.isUserExisted(rUserName);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (isExisted) {
            return new ServiceResult.Builder(false)
                    .errormsg("用户名已存在")
                    .page(req.getRequestURI())
                    .build();
        }

        UserDO userDO = new UserDO();
        userDO.setUserName(rUserName);
        userDO.setUserPassword(rUserPassword);
        userDO.setUserLevel("user");
        userDO.setUserGmtCreate(dateTime);
        userDO.setUserGmtModified(dateTime);

        boolean success = false;
        try {
            dao.insertUser(userDO);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success) {
            return new ServiceResult.Builder(true)
                    .errormsg("数据库插入异常").page(req.getRequestURI()).build();
        }

        UserDO userDO2 = null;
        boolean success2 = false;
        try {
            userDO2 = dao.queryUser(rUserName);
            success2 = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success2) {
            return new ServiceResult.Builder(true)
                    .errormsg("数据库查询异常").page(req.getRequestURI()).build();
        }
        UserDTO user = new UserDTO.Builder(userDO2.getUserId(), userDO2.getUserName()).build();
        req.getSession().setAttribute("user", user);
        return new ServiceResult.Builder(true).page(HOST.PAGE_USERHOME).build();

    }
}