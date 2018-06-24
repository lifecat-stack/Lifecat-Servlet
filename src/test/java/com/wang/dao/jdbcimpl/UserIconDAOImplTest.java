package com.wang.dao.jdbcimpl;

import com.wang.bean.doo.UserIconDO;
import com.wang.dao.DAOFactory;
import com.wang.dao.UserIconDAO;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * UserIconDAOImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 6, 2018</pre>
 */
public class UserIconDAOImplTest {
    private static DAOFactory daoFactory;
    private UserIconDAO dao;

    @BeforeClass
    public static void beforeClass() throws Exception {
        daoFactory = new JdbcDAOFactory();
    }

    @Before
    public void before() throws Exception {
        dao = daoFactory.getUserIconDAO();
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
     * Method: newUserIconDAO()
     */
    @Test
    public void testNewUserIconDAO() throws Exception {
        assertNotNull(UserIconDAOImpl.newUserIconDAO());
    }

    /**
     * Method: insertUserIcon(UserIconDO userIconDO)
     */
    @Test
    public void testInsertUserIcon() throws Exception {
        UserIconDO userIconDO = new UserIconDO();
        assertNotNull(userIconDO);

        userIconDO.setUserId(6);
        userIconDO.setIconPath("D:/Java/lifecatweb/src/main/webapp/image/one/icon/icon.jpg");
        userIconDO.setIconGmtCreate("2019-01-01 00:00:00");
        userIconDO.setIconGmtModified("2019-01-01 00:00:00");

        dao.insertUserIcon(userIconDO);
    }

    /**
     * Method: updateUserIcon(UserIconDO userIconDO)
     */
    @Test
    public void testUpdateUserIcon() throws Exception {
        UserIconDO userIconDO = new UserIconDO();
        assertNotNull(userIconDO);

        userIconDO.setUserId(6);
        userIconDO.setIconPath("D:/Java/lifecatweb/src/main/webapp/image/one/icon/icon2.jpg");
        userIconDO.setIconGmtModified("2020-01-01 00:00:00");

        dao.updateUserIcon(userIconDO);
    }

    /**
     * Method: queryUserIcon(Integer userId)
     */
    @Test
    public void testQueryUserIcon() throws Exception {
        assertEquals("D:/Java/lifecatweb/src/main/webapp/image/one/icon/icon2.jpg", dao.queryUserIcon(6));
    }


} 
