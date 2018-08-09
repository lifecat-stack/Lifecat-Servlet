package com.ten.dao;

/**
 * DAO工厂
 *
 * @date 2018/5/23
 * @auther ten
 */
public interface DAOFactory {
    /**
     * 通过DAO对应的数据表名
     * 通过properties映射文件
     * 获取DAO全限定名
     * 通过反射加载DAO实例
     *
     * @return DAO dao实例
     */
    public Object getDaoByTableName(String tableName);
}
