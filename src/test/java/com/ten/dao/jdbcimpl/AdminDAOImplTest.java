package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.AdminDO;
import com.ten.dao.AdminDAO;
import com.ten.dao.DAOFactory;
import org.junit.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * AdminDAOImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 6, 2018</pre>
 */
public class AdminDAOImplTest {

    private static DAOFactory daoFactory;
    private AdminDAO dao;

    @BeforeClass
    public static void beforeClass() throws Exception {
        daoFactory = new JdbcDAOFactory();
    }

    @Before
    public void before() throws Exception {
        dao = (AdminDAO) daoFactory.getDaoByTableName("admin");
        assertNotNull(dao);
    }

    @After
    public void after() throws Exception {
        dao = null;
    }

    @AfterClass
    public static void afterClass() throws Exception {
        daoFactory = null;
    }


    /**
     * Method: insertAdmin(AdminDO adminDO)
     */
    @Test
    public void testInsertAdmin() throws Exception {
        AdminDO adminDO = new AdminDO();

        adminDO.setAdminName("test");
        adminDO.setAdminPassword("test");
        adminDO.setAdminGmtCreate("2000-1-1 00:00:00");
        adminDO.setAdminGmtModified("2000-1-1 00:00:00");
        adminDO.setAdminLevel("admin");

        dao.insertAdmin(adminDO);
    }

    /**
     * Method: queryAdmin(String adminName)
     */
    @Test
    public void testQueryAdmin() throws Exception {
        AdminDO adminDO = dao.queryAdmin("test");

        assertNotNull(adminDO);
    }

    /**
     * Method: isAdminExisted(String adminName)
     */
    @Test
    public void testIsAdminExisted() throws Exception {
        assertTrue(dao.isAdminExisted("test"));
    }


} 
