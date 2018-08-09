package com.ten.dao.jdbcimpl;

import com.ten.dao.DAOFactory;
import com.ten.util.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * JdbcDAOFactory
 *
 * @auther ten
 */
public class JdbcDAOFactory implements DAOFactory {

    private static Logger logger = LoggerFactory.getLogger(JdbcDAOFactory.class);

    @Override
    public Object getDaoByTableName(String tableName) {
        Object obj = null;

        String propertiesName = "/properties/jdbcDaoName.properties";

        Map<String, String> map = new PropertiesReader().getPropertiesMap(propertiesName);
        assert map != null;

        try {
            obj = Class.forName(map.get(tableName)).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            logger.warn("jdbc dao not found in {}", propertiesName);
            e.printStackTrace();
        }

        return obj;
    }
}
