package com.ten.service.impl;

import com.ten.bean.vo.UserVO;
import com.ten.constant.Page;
import com.ten.dao.DAOFactory;
import com.ten.dao.UserDAO;
import com.ten.dao.jdbcimpl.JdbcDAOFactory;
import com.ten.service.UserPswUpdateService;
import com.ten.util.DateTimeUtil;
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
public class UserPswUpdateServiceImpl implements UserPswUpdateService {

    private Logger logger = LoggerFactory.getLogger(UserPswUpdateServiceImpl.class);

    private UserDAO dao;

    public UserPswUpdateServiceImpl() {
        DAOFactory factory = new JdbcDAOFactory();
        dao = (UserDAO) factory.getDaoByTableName("user");
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        String newpassword = req.getParameter("newPassword1");

        UserVO userDTO = (UserVO) req.getSession().getAttribute("user");
        Integer userId = userDTO.getUserId();

        String dateTime = DateTimeUtil.getInstance().getCurrentTime();

        updateUserPassword(userId, newpassword);

        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }

    @Override
    public void updateUserPassword(int userId, String newpassword) {
        try {
            dao.updateUserPassword(userId, newpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

