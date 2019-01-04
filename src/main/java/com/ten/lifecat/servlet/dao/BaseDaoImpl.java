package com.ten.lifecat.servlet.dao;

import com.ten.lifecat.servlet.util.Connections;
import com.ten.lifecat.servlet.util.Connections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Base jdbc operation
 */
public class BaseDaoImpl {
    private static final Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);

    private Connection connection;

    public BaseDaoImpl() {
        try {
            connection = Connections.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * insert all column
     *
     * @return increase primary key
     */
    public int insert(String sql, Object[] args) {
        logger.info("insert:" + sql);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // set '?' object through order
        for (int i = 0; i < args.length; i++) {
            if (args[i] != null) {
                preparedStatement.setObject(i + 1, args[i]);
            } else {
                preparedStatement.setObject(i + 1, null);
            }
        }

        return preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    /**
     * delete
     */
    public int delete(String sql, Object[] args) {
        logger.info("delete:" + sql);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            if (args[i] != null) {
                preparedStatement.setObject(i + 1, args[i]);
            } else {
                preparedStatement.setObject(i + 1, null);
            }
        }

        return preparedStatement.executeUpdate();
    }

    /**
     * update
     */
    public int update(String sql, Object[] args) {
        logger.info("update:" + sql);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            if (args[i] != null) {
                preparedStatement.setObject(i + 1, args[i]);
            } else {
                preparedStatement.setObject(i + 1, null);
            }
        }

        return preparedStatement.executeUpdate();
    }

    /**
     * query
     *
     * @return ResultSet
     */
    public ResultSet query(String sql, Object[] args) {
        logger.info("query:" + sql);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            if (args[i] != null) {
                preparedStatement.setObject(i + 1, args[i]);
            } else {
                preparedStatement.setObject(i + 1, null);
            }
        }

        return preparedStatement.executeQuery();
    }

}
