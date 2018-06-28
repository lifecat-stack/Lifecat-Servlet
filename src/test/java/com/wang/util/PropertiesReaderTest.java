package com.wang.util;

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
 * @since <pre>���� 28, 2018</pre>
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
        Map<String ,String > map = new PropertiesReader().getPropertiesMap("serviceName.properties");
        assertNotNull(map);
    }

} 
