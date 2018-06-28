package com.wang.manager.impl;


import com.wang.dao.DAOFactory;
import com.wang.dao.UserDAO;
import com.wang.dao.UserIconDAO;
import com.wang.dao.UserPropertyDAO;
import com.wang.dao.jdbcimpl.JdbcDAOFactory;
import com.wang.manager.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UserManagerImpl: user表逻辑操作
 * <p>
 * 访问范围: 全局
 * 调用者: Service
 * 异常检测: 确保DAO参数无差错
 * <p>
 * 1. 查询user queryUser(user_id)
 * 2. 注册user insertUser(User)
 * 3. 更新user密码 updateUserPsw(password)
 * 4. 判断用户名是否存在 isUserNameExited(user_id)
 *
 * @auther ten
 */
public class UserManagerImpl implements Manager {
    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);
    /**
     * DAO组件
     */
    private DAOFactory factory;
    private UserDAO userDAO;
    private UserIconDAO userIconDAO;
    private UserPropertyDAO userPropertyDAO;

    /**
     * Generator
     */
    public UserManagerImpl() {
        init();
        verify();
    }

    /**
     * 初始化DAO组件
     */
    private void init() {
        factory = new JdbcDAOFactory();
        userDAO = (UserDAO) factory.getDaoByTableName("UserDAO");
        userIconDAO = (UserIconDAO) factory.getDaoByTableName("UserIconDAO");
        userPropertyDAO = (UserPropertyDAO) factory.getDaoByTableName("UserPropertyDAO");
    }

    /**
     * 验证DAO初始化
     */
    private void verify() {
        assert factory != null;
        assert userDAO != null;
        assert userIconDAO != null;
        assert userPropertyDAO != null;
    }

    public void userLogin(String userName, String userPassword) {

    }

}
