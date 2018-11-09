package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.UserProperty;
import com.ten.dao.DAOFactory;
import com.ten.dao.JdbcDAOFactory;
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
     * Method: insertUserProperty(UserProperty userPropertyDO)
     */
    @Test
    public void testInsertUserProperty() throws Exception {
        UserProperty userProperty = new UserProperty();
        assertNotNull(userProperty);

        userProperty.setUserId(6);
        userProperty.setPropertyNickname("test");
        userProperty.setPropertySignature("test");
        userProperty.setPropertySex("man");
        userProperty.setPropertyEmail("123456@qq.com");
        userProperty.setPropertyLocation("wx");
        userProperty.setPropertyBirthday("1997-01-01");
        userProperty.setPropertyGmtCreate("2019-01-01 00:00:00");
        userProperty.setPropertyGmtModified("2019-01-01 00:00:00");

        dao.insertUserProperty(userProperty);
    }

    /**
     * Method: queryUserProperty(Integer userId)
     */
    @Test
    public void testQueryUserProperty() throws Exception {
        UserProperty userProperty = dao.queryUserProperty(6);

        assertEquals("test", userProperty.getPropertyNickname());
        assertEquals("test", userProperty.getPropertySignature());
        assertEquals("man", userProperty.getPropertySex());
        assertEquals("123456@qq.com", userProperty.getPropertyEmail());
        assertEquals("wx", userProperty.getPropertyLocation());
        assertEquals("1997-01-01", userProperty.getPropertyBirthday());
        assertEquals("2019-01-01 00:00:00", userProperty.getPropertyGmtCreate());
        assertEquals("2019-01-01 00:00:00", userProperty.getPropertyGmtModified());
    }


} 
