package com.wang.dao.mybatisimpl;

import com.wang.bean.entity.UserDO;
import com.wang.dao.UserDAO;
import com.wang.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

/**
 * UserDAO -- mybatis实现类
 *
 * @auther ten
 */
public class UserDAOImpl extends AbstractDAO implements UserDAO {


    @Override
    public int insertUser(UserDO userDO) throws SQLException {
        try (SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession()) {
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            userDAO.insertUser(userDO);
        }
        return 0;
    }

    @Override
    public UserDO queryUser(String userName) throws SQLException {
        try (SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession()) {
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            return userDAO.queryUser(userName);
        }
    }

    @Override
    public boolean isUserExisted(String userName) throws SQLException {
        try (SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession()) {
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            return userDAO.isUserExisted(userName);
        }
    }

    @Override
    public String queryUserPassword(String userName) throws SQLException {
        try (SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession()) {
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            return userDAO.queryUserPassword(userName);
        }
    }

    @Override
    public void updateUserPassword(Integer userId, String password) throws SQLException {
        try (SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession()) {
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            userDAO.updateUserPassword(userId, password);
        }
    }
}