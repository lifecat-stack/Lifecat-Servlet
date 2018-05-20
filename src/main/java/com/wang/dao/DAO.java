package com.wang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO
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
    void delete(String sql, Object[] args) throws SQLException;

    /**
     * update
     *
     * @param sql sql
     * @throws SQLException SQL异常
     */
    void update(String sql, Object[] args) throws SQLException;

    /**
     * query
     *
     * @param sql  sql
     * @param args 参数数组
     * @throws SQLException SQL异常
     */
    ResultSet query(String sql, Object[] args) throws SQLException;
}
