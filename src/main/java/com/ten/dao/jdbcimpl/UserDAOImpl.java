package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.UserDO;
import com.ten.dao.BaseDAO;
import com.ten.dao.UserDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDAO -- jdbc实现类
 *
 * @auther ten
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {
    public  UserDAOImpl() {
    }

    @Override
    public int insertUser(UserDO userDO) throws SQLException {
        String sql = "INSERT INTO user(user_name,user_password,user_level,user_gmt_create,user_gmt_modified)\n"
                + " VALUES(?,?,?,?,?)";
        Object[] args = {userDO.getUserName(), userDO.getUserPassword(), userDO.getUserLevel(), userDO.getUserGmtCreate(), userDO.getUserGmtModified()};
        return insertAndReturnKey(sql, args);
    }

    @Override
    public UserDO queryUser(String userName) throws SQLException {
        String sql = "select user_id,user_password,user_level,user_gmt_create,user_gmt_modified from user where user_name = '" + userName + "'";
        ResultSet resultSet = query(sql);
        UserDO userDO = new UserDO();
        resultSet.next();
        userDO.setUserId(resultSet.getInt("user_id"));
        userDO.setUserName(userName);
        userDO.setUserPassword(resultSet.getString("user_password"));
        userDO.setUserLevel(resultSet.getString("user_level"));
        userDO.setUserGmtCreate(resultSet.getString("user_gmt_create"));
        userDO.setUserGmtModified(resultSet.getString("user_gmt_modified"));
        return userDO;
    }

    @Override
    public boolean isUserExisted(String userName) throws SQLException {
        String sql = "select count(user_id) from user where user_name = '" + userName + "'";
        ResultSet rs = query(sql);
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public String queryUserPassword(String userName) throws SQLException {
        String sql = "select user_password from user where user_name = '" + userName + "'";
        ResultSet rs = query(sql);
        rs.next();
        return rs.getString("user_password");
    }

    @Override
    public void updateUserPassword(Integer userId, String password) throws SQLException {
        String sql = "update user set user_password = '" + password + "' where user_id = '" + userId + "'";
        update(sql);
    }
}