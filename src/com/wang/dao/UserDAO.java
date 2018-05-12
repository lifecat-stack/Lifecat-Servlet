package com.wang.dao;

import com.wang.util.Connections;

import java.sql.*;

/**
 * user表
 * <p>
 * 注册: 插入(id,name,password,level)
 * 登录: 查询(name,password) and 返回(id)
 * 更新密码: 查询(password) and 更新(password)
 *
 * @auther ten
 */
public class UserDAO extends BaseDAO implements DAO {
    /**
     * 注册user到user表
     *
     * @param id       id
     * @param name     name
     * @param password password
     * @param level    level
     * @throws SQLException
     */
    public void registerUser(int id, String name, String password, String level) throws SQLException {
        String sql = "insert into user values(?,?,?,?)";

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, level);

        preparedStatement.executeUpdate();
    }

    /**
     * 从user表中获取User
     *
     * @param name 根据用户名name进行查询
     * @throws SQLException
     */
    public ResultSet selectUser(String name) throws SQLException {
        String sql = "select * from user where name = " + name;

        ResultSet resultSet;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();

        if (resultSet == null) {
            throw new NullPointerException();
        }

        return resultSet;
    }

    /**
     * 重载: 从user表中获取User
     *
     * @param id 根据用户id进行查询
     * @throws SQLException
     */
    public ResultSet selectUser(int id) throws SQLException {
        String sql = "select * from user where id = " + id;

        ResultSet resultSet;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();

        if (resultSet == null) {
            throw new NullPointerException();
        }

        return resultSet;
    }


    /**
     * 更新用户密码user
     *
     * @param id 用户id
     * @throws SQLException
     */
    public void updateUserPsw(int id, String password) throws SQLException {
        String sql = "update user set password = " + password + " where id = " + id;

        ResultSet resultSet;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.executeUpdate();
    }
}