package com.wang.dao.jdbcimpl;

import com.wang.dao.dao.UserDAO;
import com.wang.doo.UserDO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDAO -- jdbc实现类
 *
 * @auther ten
 */
class UserDAOImpl extends AbstractDAO implements UserDAO {

    private UserDAOImpl() {
    }

    static UserDAO newUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public void insertUser(UserDO userDO) throws SQLException {
        String sql = "insert into user(user_name,user_password,user_level,user_gmt_create,user_gmt_modified) " +
                "VALUES( ?,?,?,?,?)";
        Object[] args = {userDO.getUserName(), userDO.getUserPassword(), userDO.getUserLevel(), userDO.getUserGmtCreate(), userDO.getUserGmtModified()};
        insert(sql, args);
    }

    @Override
    public UserDO queryUser(String userName) throws SQLException {
        String sql = "select (user_id,user_name,user_password,user_level,user_gmt_create,user_gmt_modified) from user where user_name = " + userName;
        ResultSet resultSet = query(sql);
        UserDO userDO = new UserDO();
        userDO.setUserId(Integer.valueOf(resultSet.getString("user_id")));
        userDO.setUserName(resultSet.getString("user_name"));
        userDO.setUserPassword(resultSet.getString("user_password"));
        userDO.setUserLevel(resultSet.getString("user_level"));
        userDO.setUserGmtCreate(resultSet.getString("user_gmt_create"));
        userDO.setUserGmtModified(resultSet.getString("user_gmt_modified"));
        return userDO;
    }

    @Override
    public boolean isUserExisted(String userName) throws SQLException {
        String sql = "select count(user_id) from user where user_name = " + userName;
        return query(sql).getInt(1) > 0;
    }

    @Override
    public String queryUserPassword(String userName) throws SQLException {
        String sql = "select user_password from user where user_name = " + userName;
        return query(sql).getString("user_password");
    }

    @Override
    public void updateUserPassword(Integer userId, String password) throws SQLException {
        String sql = "update user set user_password = " + password + " where user_id = " + userId;
        update(sql);
    }
}