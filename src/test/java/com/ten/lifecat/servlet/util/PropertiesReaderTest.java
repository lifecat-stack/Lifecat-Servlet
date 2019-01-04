package com.ten.lifecat.servlet.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertNotNull;

/**
 * PropertiesReader Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 28, 2018</pre>
 */
public class PropertiesReaderTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getPropertiesMap(String propertiesName)
     */
    @Test
    public void testGetPropertiesMap() throws Exception {

        String path = "/properties/jdbcDaoName.properties";
        System.out.println(path);
        Map<String, String> map = new PropertiesReader().getPropertiesMap(path);
        assertNotNull(map);


    }

} 
