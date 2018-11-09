package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.UserIcon;
import com.ten.dao.DAOFactory;
import com.ten.dao.JdbcDAOFactory;
import com.ten.dao.UserIconDAO;
import org.junit.*;

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
        dao = (UserIconDAO) daoFactory.getDaoByTableName("user_icon");
        assertNotNull(dao);
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() throws Exception {
    }

    /**
     * Method: insertUserIcon(UserIcon userIconDO)
     */
    @Test
    public void testInsertUserIcon() throws Exception {
        UserIcon userIcon = new UserIcon();
        assertNotNull(userIcon);

        userIcon.setUserId(6);
        userIcon.setIconPath("D:/Java/lifecatweb/src/main/webapp/image/one/icon/icon.jpg");
        userIcon.setIconGmtCreate("2019-01-01 00:00:00");
        userIcon.setIconGmtModified("2019-01-01 00:00:00");

        dao.insertUserIcon(userIcon);
    }

    /**
     * Method: updateUserIcon(UserIcon userIconDO)
     */
    @Test
    public void testUpdateUserIcon() throws Exception {
        UserIcon userIcon = new UserIcon();
        assertNotNull(userIcon);

        userIcon.setUserId(6);
        userIcon.setIconPath("D:/Java/lifecatweb/src/main/webapp/image/one/icon/icon2.jpg");
        userIcon.setIconGmtModified("2020-01-01 00:00:00");

        dao.updateUserIcon(userIcon);
    }

    /**
     * Method: queryUserIcon(Integer userId)
     */
    @Test
    public void testQueryUserIcon() throws Exception {
        assertNotNull(dao.queryUserIcon(1));
    }

} 
