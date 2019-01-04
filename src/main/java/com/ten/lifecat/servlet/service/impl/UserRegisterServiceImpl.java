package com.ten.lifecat.servlet.service.impl;

import com.ten.lifecat.servlet.entity.User;
import com.ten.bean.vo.UserVO;
import com.ten.constant.Page;
import com.ten.lifecat.servlet.dao.JdbcDAOFactory;
import com.ten.service.UserRegisterService;
import com.ten.lifecat.servlet.util.DateTimeUtil;
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
public class UserRegisterServiceImpl implements UserRegisterService {

    private Logger logger = LoggerFactory.getLogger(UserRegisterServiceImpl.class);

    private UserDAO dao;

    public UserRegisterServiceImpl() {
        dao = (UserDAO) JdbcDAOFactory.getDaoByTableName("user");
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        String rUserName = req.getParameter("rUserName");
        String rUserPassword = req.getParameter("rUserPassword1");

        String dateTime = DateTimeUtil.getInstance().getCurrentTime();

        boolean isExisted = isUserExisted(rUserName);
        if (isExisted) {
            return new ServiceResult.Builder(false).errormsg("该用户已存在").page(Page.PAGE_INDEX).build();
        }

        User userDO = new User();
        userDO.setUserName(rUserName);
        userDO.setUserPassword(rUserPassword);
        userDO.setUserLevel("user");
        userDO.setCreateTime(dateTime);
        userDO.setUpdateTime(dateTime);

        int userId = insertUserToDatabase(userDO);
        if (userId < 1) {
            return new ServiceResult.Builder(false).errormsg("注册失败").page(Page.PAGE_INDEX).build();
        }

        UserVO user = new UserVO(userId, rUserName);
        req.getSession().setAttribute("user", user);
        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }

    @Override
    public boolean isUserExisted(String userName) {
        try {
            return dao.isUserExisted(userName);
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override
    public int insertUserToDatabase(User user) {
        try {
            return dao.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}