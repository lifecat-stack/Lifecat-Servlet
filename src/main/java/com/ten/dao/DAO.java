package com.ten.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO :
 * <p>
 * 定义数据库操作
 * 1.insert
 * 2.delete
 * 3.update
 * 4.query
 *
 * @date 2018/5/20
 * @auther ten
 */
public interface DAO {
    /**
     * insert
     *
     * @param sql sql
     * @throws SQLException SQL异常
     */
    void insert(String sql, Object[] args) throws SQLException;

    /**
     * delete
     *
     * @param sql sql
     * @throws SQLException SQL异常
     */
    void delete(String sql) throws SQLException;

    /**
     * update
     *
     * @param sql sql
     * @throws SQLException SQL异常
     */
    void update(String sql) throws SQLException;

    /**
     * query
     *
     * @param sql sql
     * @throws SQLException SQL异常
     */
    ResultSet query(String sql) throws SQLException;
}
