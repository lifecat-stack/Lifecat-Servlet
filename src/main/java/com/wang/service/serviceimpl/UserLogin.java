package com.wang.service.serviceimpl;

import com.wang.bean.doo.UserDO;
import com.wang.bean.dto.UserDTO;
import com.wang.constant.Page;
import com.wang.dao.dao.DAOFactory;
import com.wang.dao.dao.UserDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.service.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 用户登录
 * <p>
 * 失败 Page.PAGE_INDEX
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
class UserLogin implements Service {

    private Logger logger = LoggerFactory.getLogger(UserLogin.class);

    private UserLogin() {
    }

    static Service newService() {
        return new UserLogin();
    }


    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");

        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        UserDAO dao = factory.getUserDAO();

        // DAO查询user
        UserDO userDO = null;
        boolean success = false;
        try {
            userDO = dao.queryUser(userName);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success) {
            return new ServiceResult.Builder(false)
                    .errormsg("数据库查询异常").page(Page.PAGE_INDEX).build();
        }

        if (userDO == null) {
            return new ServiceResult.Builder(false)
                    .errormsg("数据库无此用户").page(Page.PAGE_INDEX).build();
        }

        if (!userPassword.equals(userDO.getUserPassword())) {
            return new ServiceResult.Builder(false)
                    .errormsg("密码错误").page(Page.PAGE_INDEX).build();
        }

        UserDTO user = new UserDTO.Builder(userDO.getUserId(), userDO.getUserName()).build();
        req.getSession().setAttribute("user", user);
        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }
}

