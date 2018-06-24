package com.wang.service.impl;

import com.wang.bean.dto.UserDTO;
import com.wang.constant.Page;
import com.wang.dao.DAOFactory;
import com.wang.dao.UserDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.service.util.Service;
import com.wang.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 更新用户密码
 *
 * @date 2018/5/24
 * @auther ten
 */
class UserPswUpdateServiceImpl implements UserPswUpdateService {

    private Logger logger = LoggerFactory.getLogger(UserPswUpdateServiceImpl.class);

    private UserPswUpdateServiceImpl() {
    }

    static Service newService() {
        return new UserPswUpdateServiceImpl();
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        String newpassword = req.getParameter("newPassword1");

        UserDTO userDTO = (UserDTO) req.getSession().getAttribute("user");

        Integer userId = userDTO.getUserId();

        String dateTime = DateTimeUtil.getInstance().getCurrentTime();

        DAOFactory factory = new JdbcDAOFactory();
        UserDAO dao = factory.getUserDAO();

        boolean success = false;
        try {
            dao.updateUserPassword(userId, newpassword);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (success) {
            logger.warn("password update failure");
            return new ServiceResult.Builder(false)
                    .errormsg("password update failure")
                    .page(Page.PAGE_USERHOME)
                    .build();
        }

        logger.info("password update success");
        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }
}

