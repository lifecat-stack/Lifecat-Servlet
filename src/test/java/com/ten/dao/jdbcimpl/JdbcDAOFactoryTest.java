package com.ten.dao.jdbcimpl;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

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
        factory.getDaoByTableName("diary");
    }


} 
