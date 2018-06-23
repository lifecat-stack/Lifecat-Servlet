package com.wang.dao.jdbcimpl;

import com.wang.dao.DAOFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JdbcDAOFactory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 6, 2018</pre>
 */
public class JdbcDAOFactoryTest {

    private static DAOFactory daoFactory;

    @BeforeClass
    public static void before() throws Exception {
        daoFactory = new JdbcDAOFactory();
    }

    @AfterClass
    public static void after() throws Exception {
        daoFactory = null;
    }

    /**
     * Method: getAdminDAO()
     */
    @Test
    public void testGetAdminDAO() throws Exception {
        assert daoFactory.getAdminDAO() instanceof AdminDAOImpl;
    }

    /**
     * Method: getDiaryDAO()
     */
    @Test
    public void testGetDiaryDAO() throws Exception {
        assert daoFactory.getDiaryDAO() instanceof DiaryDAOImpl;
    }

    /**
     * Method: getImageDAO()
     */
    @Test
    public void testGetImageDAO() throws Exception {
        assert daoFactory.getImageDAO() instanceof ImageDAOImpl;
    }

    /**
     * Method: getImageFeatureDAO()
     */
    @Test
    public void testGetImageFeatureDAO() throws Exception {
        assert daoFactory.getImageFeatureDAO() instanceof ImageFeatureDAOImpl;
    }

    /**
     * Method: getImageClassDAO()
     */
    @Test
    public void testGetImageClassDAO() throws Exception {
        assert daoFactory.getImageClassDAO() instanceof ImageClassDAOImpl;
    }

    /**
     * Method: getUserDAO()
     */
    @Test
    public void testGetUserDAO() throws Exception {
        assert daoFactory.getUserDAO() instanceof UserDAOImpl;
    }

    /**
     * Method: getUserIconDAO()
     */
    @Test
    public void testGetUserIconDAO() throws Exception {
        assert daoFactory.getUserIconDAO() instanceof UserIconDAOImpl;
    }

    /**
     * Method: getUserPropertyDAO()
     */
    @Test
    public void testGetUserPropertyDAO() throws Exception {
        assert daoFactory.getUserPropertyDAO() instanceof UserPropertyDAOImpl;
    }


} 
