package com.wang.dao.jdbcimpl;

import com.wang.dao.dao.DAO;
import com.wang.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO接口骨架类 :
 * <p>
 * insert()
 * delete()
 * update()
 * query()
 *
 * @date 2018/5/22
 * @auther ten
 */
abstract class AbstractDAO implements DAO {
    /**
     * insert
     *
     * @param sql sql
     * @throws SQLException SQL异常
     */
    @Override
    public void insert(String sql, Object[] args) throws SQLException {
        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        preparedStatement.executeUpdate();
    }

    /**
     * delete
     *
     * @param sql sql
     * @throws SQLException SQL异常
     */
    @Override
    public void delete(String sql) throws SQLException {
        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }

    /**
     * update
     *
     * @param sql sql
     * @throws SQLException SQL异常
     */
    @Override
    public void update(String sql) throws SQLException {
        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }

    /**
     * query
     *
     * @param sql sql
     * @throws SQLException SQL异常
     */
    @Override
    public ResultSet query(String sql) throws SQLException {
        Connection connection = Connections.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }
}
