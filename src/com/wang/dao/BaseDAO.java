package com.wang.dao;

import com.wang.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * @name BaseDAO实现类
 * @description DAO增删改查的实现类
 * @auther ten
 */
public class BaseDAO implements DAO {
    protected static Logger logger = Logger.getLogger("BaseDAO");

    /*  insert into "table" values("attributes") */
    @Override
    public boolean exeInsert(String table, Object[] attributes) {
        StringBuilder builder = new StringBuilder();
        /* 生成sql */
        String sql1 = "insert into " + table + " values(";
        builder.append(sql1);
        for (int i = 0; i < attributes.length; i++) {

            /* 插入的是string */
            if (i != 0) {
                builder.append("\"");
                builder.append(attributes[i]);
                builder.append("\"");
            }
            /* 插入的是Int */
            else {
                builder.append(attributes[i]);
            }

            if (i < attributes.length - 1) {
                builder.append(",");
            } else {
                builder.append(")");
            }
        }
        String sql = builder.toString();

        logger.info("插入操作：" + sql);

        /* 执行sql */
        return exeSQLIDU(sql);
    }

    /* delete from "table" where "attribute" = "value" */
    @Override
    public boolean exeDelete(String table, String attribute, String value) {
        /* 生成sql */
        String sql = "delete from " + table + " where " + attribute + " = " + value;

        logger.info("删除操作：" + sql);

        /* 执行sql */
        return exeSQLIDU(sql);
    }

    /* update "table" set "attribute" = "value" where id = "id" */
    @Override
    public boolean exeUpdate(String table, String attribute, String value, int id) {
        /* 生成sql */
        String sql = "update " + table + " set " + attribute + " = \"" + value + "\" where " + "id = " + id;

        logger.info("更新操作：" + sql);

        /* 执行sql */
        return exeSQLIDU(sql);
    }

    /* select "attribute" from "table" where id = "id" */
    @Override
    public ResultSet exeSelect(String attribute, String table, int id) {
        /* 生成sql */
        String sql = "select " + attribute + " from " + table + " where id = " + id;

        logger.info("选择操作：" + sql);

        ResultSet resultSet = exeSQLS(sql);

        return resultSet;
    }

    /* 增删改：无返回结果，返回boolean */
    private boolean exeSQLIDU(String sql) {
        try {
            /* 获取连接 */
            Connection connection = Connections.getConnection();
            /* 设置sql */
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            /* 获取结果集 */
            preparedStatement.executeUpdate();

            logger.info("exeSQLIDU成功");
            return true;
        } catch (SQLException e) {
            logger.warning("exeSQLIDU失败");
            e.printStackTrace();
            return false;
        }
    }

    /* 查：有返回结果集 */
    private ResultSet exeSQLS(String sql) {
        try {
            ResultSet resultSet;
            /* 获取连接 */
            Connection connection = Connections.getConnection();
            /* 设置sql */
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            /* 获取结果集 */
            resultSet = preparedStatement.executeQuery();
            logger.info("exeSQLS成功");
            return resultSet;
        } catch (SQLException e) {
            logger.warning("exeSQLS失败");
            e.printStackTrace();
            return null;
        }
    }

    /* 打印错误信息 */
    public static void errorMsg(String msg) {
        logger.warning(msg + " ERROR");
    }
}
