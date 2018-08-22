package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.UserDO;
import com.ten.dao.DAOFactory;
import com.ten.dao.UserDAO;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * UserDAOImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 6, 2018</pre>
 */
public class UserDAOImplTest {

    private static DAOFactory daoFactory;
    private UserDAO dao;

    @BeforeClass
    public static void beforeClass() throws Exception {
        daoFactory = new JdbcDAOFactory();
    }

    @Before
    public void before() throws Exception {
        dao = (UserDAO) daoFactory.getDaoByTableName("user");
        assertNotNull(dao);
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() throws Exception {
        daoFactory = null;
    }

    /**
     * Method: insertUser(UserDO userDO)
     */
    @Test
    public void testInsertUser() throws Exception {
        UserDO userDO = new UserDO();

        userDO.setUserName("test");
        userDO.setUserPassword("123456");
        userDO.setUserLevel("test");
        userDO.setUserGmtCreate("2019-01-01 00:00:00");
        userDO.setUserGmtModified("2019-01-01 00:00:00");

        int userId = dao.insertUser(userDO);
        assertNotEquals(userId, 0);
    }

    /**
     * Method: queryUser(String userName)
     */
    @Test
    public void testQueryUser() throws Exception {
        UserDO userDO = dao.queryUser("test");
        assertEquals("test", userDO.getUserName());
        assertEquals("123456", userDO.getUserPassword());
        assertEquals("test", userDO.getUserLevel());
        assertEquals("2019-01-01 00:00:00", userDO.getUserGmtCreate());
        assertEquals("2019-01-01 00:00:00", userDO.getUserGmtModified());
    }

    /**
     * Method: isUserExisted(String userName)
     */
    @Test
    public void testIsUserExisted() throws Exception {
        assertTrue(dao.isUserExisted("test"));
    }

    /**
     * Method: queryUserPassword(String userName)
     */
    @Test
    public void testQueryUserPassword() throws Exception {
        assertEquals("123456", dao.queryUserPassword("test"));
    }

    /**
     * Method: updateUserPassword(Integer userId, String password)
     */
    @Test
    public void testUpdateUserPassword() throws Exception {
        dao.updateUserPassword(6, "123456");
    }


} 
