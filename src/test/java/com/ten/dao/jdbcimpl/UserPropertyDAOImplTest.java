package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.UserPropertyDO;
import com.ten.dao.DAOFactory;
import com.ten.dao.UserPropertyDAO;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * UserPropertyDAOImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 6, 2018</pre>
 */
public class UserPropertyDAOImplTest {

    private static DAOFactory daoFactory;
    private UserPropertyDAO dao;

    @BeforeClass
    public static void beforeClass() throws Exception {
        daoFactory = new JdbcDAOFactory();
    }

    @Before
    public void before() throws Exception {
        dao = (UserPropertyDAO) daoFactory.getDaoByTableName("user_property");
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
     * Method: insertUserProperty(UserPropertyDO userPropertyDO)
     */
    @Test
    public void testInsertUserProperty() throws Exception {
        UserPropertyDO userPropertyDO = new UserPropertyDO();
        assertNotNull(userPropertyDO);

        userPropertyDO.setUserId(6);
        userPropertyDO.setPropertyNickname("test");
        userPropertyDO.setPropertySignature("test");
        userPropertyDO.setPropertySex("man");
        userPropertyDO.setPropertyEmail("123456@qq.com");
        userPropertyDO.setPropertyLocation("wx");
        userPropertyDO.setPropertyBirthday("1997-01-01");
        userPropertyDO.setPropertyGmtCreate("2019-01-01 00:00:00");
        userPropertyDO.setPropertyGmtModified("2019-01-01 00:00:00");

        dao.insertUserProperty(userPropertyDO);
    }

    /**
     * Method: queryUserProperty(Integer userId)
     */
    @Test
    public void testQueryUserProperty() throws Exception {
        UserPropertyDO userPropertyDO = dao.queryUserProperty(6);

        assertEquals("test", userPropertyDO.getPropertyNickname());
        assertEquals("test", userPropertyDO.getPropertySignature());
        assertEquals("man", userPropertyDO.getPropertySex());
        assertEquals("123456@qq.com", userPropertyDO.getPropertyEmail());
        assertEquals("wx", userPropertyDO.getPropertyLocation());
        assertEquals("1997-01-01", userPropertyDO.getPropertyBirthday());
        assertEquals("2019-01-01 00:00:00", userPropertyDO.getPropertyGmtCreate());
        assertEquals("2019-01-01 00:00:00", userPropertyDO.getPropertyGmtModified());
    }


} 
