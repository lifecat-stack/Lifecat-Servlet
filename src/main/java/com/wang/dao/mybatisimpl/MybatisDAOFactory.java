package com.wang.dao.mybatisimpl;

import com.wang.dao.DAOFactory;
import com.wang.util.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * JdbcDAOFactory :
 * 获取jdbc包的DAO接口实现实例
 *
 * @auther ten
 */
public class MybatisDAOFactory implements DAOFactory {


    private static Logger logger = LoggerFactory.getLogger(MybatisDAOFactory.class);

    @Override
    public Object getDaoByTableName(String tableName) {
        Object obj = null;

        String propertiesName = "properties/mybatisDaoName.properties";

        Map<String, String> map = new PropertiesReader().getPropertiesMap(propertiesName);
        assert map != null;

        try {
            obj = Class.forName(map.get(tableName)).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            logger.warn("mybatis dao not found in {}", propertiesName);
            e.printStackTrace();
        }

        return obj;
    }
}
