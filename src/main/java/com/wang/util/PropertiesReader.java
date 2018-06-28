package com.wang.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * properties文件读取类
 *
 * @date 2018/6/28
 * @auther ten
 */
public class PropertiesReader {
    /**
     * 读取制定properties文件
     *
     * @param propertiesName resources目录下路径名
     * @return map properties映射关系
     */
    public Map<String, String> getPropertiesMap(String propertiesName) {

        Properties props = new Properties();
        Map<String, String> map = new HashMap<String, String>(24);

        try {
            InputStream in = getClass().getResourceAsStream(propertiesName);
            props.load(in);
            Enumeration en = props.propertyNames();
            // 以等号作为分割key-value
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String property = props.getProperty(key);
                map.put(key, property);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}
