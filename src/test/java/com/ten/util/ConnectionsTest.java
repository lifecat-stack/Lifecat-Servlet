package com.ten.util;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

/**
 * Connections Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÎåÔÂ 24, 2018</pre>
 */
public class ConnectionsTest {
    private static Connection conn = null;

    @BeforeClass
    public static void beforeClass() throws Exception {
        conn = Connections.getConnection();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getConnection()
     */
    @Test
    public void testGetConnection() throws Exception {
        assertNotNull(conn);
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testMain() throws Exception {
        Connection conn = Connections.getConnection();
        assertNotNull(conn);
    }
} 
