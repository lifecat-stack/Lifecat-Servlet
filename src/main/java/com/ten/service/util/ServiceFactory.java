package com.ten.service.util;

import com.ten.util.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * ServiceFactory :
 * <p>
 * 返回相应的service对象
 *
 * @auther ten
 */
public class ServiceFactory {
    private static Logger logger = LoggerFactory.getLogger(ServiceFactory.class);

    /**
     * 通过类名Key
     * 通过properties配置映射关系
     * 通过反射加载获取类对象
     *
     * @param key 配置映射关系
     * @return service 反射加载类对象
     */
    public static Service getServiceByClassKey(String key) {
        Service service = null;
        String propertiesName = "/properties/serviceName.properties";

        Map<String, String> map = new PropertiesReader().getPropertiesMap(propertiesName);
        assert map != null;

        String val=map.get(key);
        System.out.println(val);

        try {
            service = (Service) Class.forName(val).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            logger.warn("service not found in {}", propertiesName);
            e.printStackTrace();
        }

        return service;
    }
}
