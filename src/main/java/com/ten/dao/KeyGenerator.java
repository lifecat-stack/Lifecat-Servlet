package com.ten.dao;

import java.sql.SQLException;

/**
 * 插入操作返回自增长主键
 *
 * @date 2018/6/19
 * @auther ten
 */
public interface KeyGenerator {
    /**
     * insert
     *
     * @param sql sql
     * @throws SQLException SQL异常
     */
    int insertAndReturnKey(String sql, Object[] args) throws SQLException;
}
