package com.wang.dao.jdbcimpl;

import com.wang.util.Connections;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;

import static junit.framework.TestCase.assertNotNull;

/**
 * AbstractDAO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 19, 2018</pre>
 */
public class AbstractDAOTest {

    private static Connection conn;

    @BeforeClass
    public static void before() throws Exception {
        conn = Connections.getConnection();
        assertNotNull(conn);
    }

    @AfterClass
    public static void after() throws Exception {
        conn = null;
    }

    /**
     * Method: insert(String sql, Object[] args)
     */
    @Test
    public void testInsert() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: delete(String sql)
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: update(String sql)
     */
    @Test
    public void testUpdate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: query(String sql)
     */
    @Test
    public void testQuery() throws Exception {
//TODO: Test goes here... 
    }


} 
