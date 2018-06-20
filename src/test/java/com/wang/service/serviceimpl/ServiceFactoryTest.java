package com.wang.service.serviceimpl;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ServiceFactory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 16, 2018</pre>
 */
public class ServiceFactoryTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Before
    public void before() throws Exception { // 创建request和response的Mock
        request = EasyMock.createMock(HttpServletRequest.class);
        response = EasyMock.createMock(HttpServletResponse.class);
        session = EasyMock.createMock(HttpSession.class);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getServiceByUrl(String url)
     */
    @Test
    public void testGetServiceByUrl() throws Exception {
//TODO: Test goes here... 
    }


} 
