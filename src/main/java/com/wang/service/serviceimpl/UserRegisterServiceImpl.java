package com.wang.service.serviceimpl;

import com.wang.bean.doo.UserDO;
import com.wang.bean.dto.UserDTO;
import com.wang.constant.Page;
import com.wang.dao.DAOFactory;
import com.wang.dao.dao.UserDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.service.Service;
import com.wang.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 用户注册
 *
 * @date 2018/5/24
 * @auther ten
 */
class UserRegisterServiceImpl implements UserRegisterService {

    private Logger logger = LoggerFactory.getLogger(UserRegisterServiceImpl.class);

    private UserRegisterServiceImpl() {
    }

    static Service newService() {
        return new UserRegisterServiceImpl();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        String rUserName = req.getParameter("rUserName");
        String rUserPassword = req.getParameter("rUserPassword1");

        String dateTime = DateTimeUtil.getInstance().getCurrentTime();

        DAOFactory factory = new JdbcDAOFactory();
        UserDAO dao = factory.getUserDAO();

        boolean isExisted = true;
        try {
            isExisted = dao.isUserExisted(rUserName);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (isExisted) {
            logger.warn("username is existed");
            return new ServiceResult.Builder(false)
                    .errormsg("username is existed")
                    .page(Page.PAGE_INDEX)
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
            logger.warn("sql insert exception");
            return new ServiceResult.Builder(false)
                    .errormsg("sql insert exception").page(Page.PAGE_INDEX).build();
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
            logger.warn("sql query exception");
            return new ServiceResult.Builder(false)
                    .errormsg("sql query exception").page(Page.PAGE_INDEX).build();
        }
        UserDTO user = new UserDTO.Builder(userDO2.getUserId(), userDO2.getUserName()).build();
        req.getSession().setAttribute("user", user);
        logger.info("user_register success");
        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();

    }
}