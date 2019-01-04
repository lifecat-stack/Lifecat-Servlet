package com.ten.lifecat.servlet.util;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * DateTimeUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class DateTimeUtilTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getInstance()
     */
    @Test
    public void testGetInstance() throws Exception {
        DateTimeUtil dateTimeUtil1 = DateTimeUtil.getInstance();
        DateTimeUtil dateTimeUtil2 = DateTimeUtil.getInstance();
        assertSame(dateTimeUtil1, dateTimeUtil2);
    }

    /**
     * Method: getCurrentTime()
     */
    @Test
    public void testGetCurrentTime() throws Exception {
        DateTimeUtil dateTimeUtil = DateTimeUtil.getInstance();
        String time = dateTimeUtil.getCurrentTime();
        assertNotNull(time);
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
//TODO: Test goes here... 
    }
} 
