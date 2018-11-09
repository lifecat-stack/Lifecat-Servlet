package com.ten.dao.jdbcimpl;

import com.ten.dao.JdbcDAOFactory;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static junit.framework.TestCase.assertNotNull;

/**
 * JdbcDAOFactory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÆßÔÂ 9, 2018</pre>
 */
public class JdbcDAOFactoryTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getDaoByTableName(String tableName)
     */
    @Test
    public void testGetDaoByTableName() throws Exception {
        JdbcDAOFactory factory = new JdbcDAOFactory();
        assertNotNull(factory.getDaoByTableName("diary"));
    }

} 
