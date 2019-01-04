package com.ten.lifecat.servlet.service.util;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * ServiceFactory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÆßÔÂ 9, 2018</pre>
 */
public class ServiceFactoryTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getServiceByClassKey(String key)
     */
    @Test
    public void testGetServiceByClassKey() throws Exception {
        Service service=ServiceFactory.getServiceByClassKey("diary_list_query");
        assert service!=null;
    }


} 
