package com.ten.lifecat.servlet.dao;

import com.ten.lifecat.servlet.util.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * JdbcDAOFactory
 */
public class JdbcDAOFactory {
    private static final Logger logger = LoggerFactory.getLogger(JdbcDAOFactory.class);

    /**
     * DAO CLASS SET 标记已加载的DAO的类名
     */
    private static Set<String> daoSet = new HashSet<>(16);
    /**
     * DAO OBJECT MAP 存放DAO对象单例
     */
    private static Map<String, Object> daoMap = new HashMap<>(16);
    /**
     * DAO NAME MAP 存放DAO的类型信息
     */
    private static Map<String, String> nameMap;

    static {
        String propertiesName = "/properties/jdbcDaoName.properties";
        nameMap = new PropertiesReader().getPropertiesMap(propertiesName);
    }

    /**
     * 根据数据表名, 获取对应的DAO的单例, 若未加载则加载
     *
     * @param tableName 数据表名
     */
    public static Object getDaoByTableName(String tableName) {
        Object dao;

        boolean load = daoSet.contains(tableName);
        // DAO已被加载
        if (load) {
            dao = daoMap.get(tableName);
        }
        // DAO未被加载
        else {
            String daoClassName = nameMap.get(tableName);
            dao = loadObject(daoClassName);
            // 加载成功
            if (dao != null) {
                daoSet.add(tableName);
                daoMap.put(tableName, dao);
            }
            // 加载失败
            else {
                logger.warn("DAO LOAD FAILURE:" + daoClassName);
            }
        }

        return dao;
    }

    /**
     * 加载对象实例
     *
     * @param className 全限定类名
     */
    private static Object loadObject(String className) {
        try {
            return Class.forName(className).newInstance();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
