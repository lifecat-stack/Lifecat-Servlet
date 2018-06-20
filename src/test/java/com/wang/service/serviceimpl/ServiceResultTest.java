package com.wang.service.serviceimpl;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ServiceResult Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 16, 2018</pre>
 */
public class ServiceResultTest {


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
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getErrormsg()
     */
    @Test
    public void testGetErrormsg() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: isSuccess()
     */
    @Test
    public void testIsSuccess() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getPage()
     */
    @Test
    public void testGetPage() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: errormsg(String errormsg)
     */
    @Test
    public void testErrormsg() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: page(String page)
     */
    @Test
    public void testPage() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: build()
     */
    @Test
    public void testBuild() throws Exception {
//TODO: Test goes here... 
    }


} 
