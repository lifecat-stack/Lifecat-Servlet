package com.ten.service.impl;

import com.ten.bean.entity.UserDO;
import com.ten.bean.vo.UserVO;
import com.ten.constant.Page;
import com.ten.dao.DAOFactory;
import com.ten.dao.UserDAO;
import com.ten.dao.jdbcimpl.JdbcDAOFactory;
import com.ten.service.UserLoginService;
import com.ten.service.util.Service;
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
class UserLoginServiceImpl implements UserLoginService {

    private Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);

    private UserLoginServiceImpl() {
    }

    static Service newService() {
        return new UserLoginServiceImpl();
    }


    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {

        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");

        // 获取DAO实例
        DAOFactory factory = new JdbcDAOFactory();
        UserDAO dao = (UserDAO) factory.getDaoByTableName("user");

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

        UserVO user = new UserVO(userDO.getUserId(), userDO.getUserName());
        req.getSession().setAttribute("user", user);
        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }

    @Override
    public boolean isUserExisted(String userName) {
        return false;
    }

    @Override
    public UserDO queryUserByName(String userName) {
        return null;
    }
}

