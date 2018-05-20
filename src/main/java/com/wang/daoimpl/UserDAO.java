package com.wang.daoimpl;

import com.wang.bean.User;
import com.wang.dao.DAO;
import com.wang.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDAO: user表数据库操作
 * <p>
 * 访问范围: 全局
 * 获取实例: 包权限
 * 调用者: Manager
 * <p>
 * 1. 查询user queryUser(user_id)
 * 2. 插入user insertUser(User)
 * 3. 查询密码 queryUserPsw(user_id)
 * 4. 更新密码 updateUserPsw(password)
 * 5. 查询username queryUserName(user_id)
 *
 * @auther ten
 */
public class UserDAO implements DAO {

    private UserDAO() {
    }

    static DAO newUserDAO() {
        return new UserDAO();
    }

    /**
     * 查询user queryUser(user_id)
     *
     * @param id user_id
     * @return User 数据库返回User对象
     * @throws SQLException         SQL异常
     * @throws NullPointerException 数据库查询为空
     */
    public User queryUser(int id) throws SQLException {

        String sql = "select * from user where id = " + id;

        ResultSet resultSet;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();

        if (resultSet == null) {
            throw new NullPointerException();
        }

        String name = resultSet.getString("name");
        String password = resultSet.getString("password");
        String level = resultSet.getString("level");

        return new User.Builder(name, password).id(id).level(level).build();
    }

    /**
     * 插入user insertUser(User)
     *
     * @param user User对象
     * @throws SQLException SQL异常
     */
    public void insertUser(User user) throws SQLException {

        String sql = "insert into user values(?,?,?,?)";

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getLevel());

        preparedStatement.executeUpdate();
    }


    /**
     * 查询密码 queryUserPsw(user_id)
     *
     * @param id 用户id
     * @return password
     * @throws SQLException SQL异常
     */
    public String queryUserPsw(int id) throws SQLException {

        String sql = "select password from user where id = " + id;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.getString("password");
    }

    /**
     * 更新密码 updateUserPsw(id,password)
     *
     * @param id       用户id
     * @param password 新密码
     * @throws SQLException SQL异常
     */
    public void updateUserPsw(int id, String password) throws SQLException {

        String sql = "update user set password = " + password + " where id = " + id;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.executeUpdate();
    }

    /**
     * 查询username queryUserName(user_id)
     *
     * @param id 用户id
     * @throws SQLException SQL异常
     */
    public String  queryUserName(int id) throws SQLException {

        String sql = "select name from user where id = " + id;

        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.getString("name");
    }
}