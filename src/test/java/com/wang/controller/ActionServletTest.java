package com.wang.controller;

import org.apache.cactus.ServletTestCase;
import org.apache.cactus.WebRequest;
import org.apache.cactus.WebResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ActionServlet Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 16, 2018</pre>
 */
public class ActionServletTest extends ServletTestCase {
    private ActionServlet servlet;

    @Before
    public void before(WebRequest request) throws Exception {
        servlet = new ActionServlet();
//        request.setURL();
    }

    @After
    public void after(WebResponse response) throws Exception {

    }

    /**
     * Method: doGet(HttpServletRequest req, HttpServletResponse resp)
     */
    @Test
    public void testDoGet() throws Exception {
        servlet.doGet(super.request, super.response);
    }

    /**
     * Method: doPost(HttpServletRequest req, HttpServletResponse resp)
     */
    @Test
    public void testDoPost() throws Exception {
    }
} 
