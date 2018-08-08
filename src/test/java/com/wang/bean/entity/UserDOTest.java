package com.wang.bean.entity;

import org.junit.*;

/**
 * UserDO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 20, 2018</pre>
 */
public class UserDOTest {
    private static UserDO userDO;

    @BeforeClass
    public static void beforeClass() {
        userDO = new UserDO();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() {
        userDO = null;
    }

    /**
     * Method: getUserId()
     */
    @Test
    public void testGetUserId() throws Exception {
        userDO.setUserId(17);
        assert userDO.getUserId() == 17;
    }

    /**
     * Method: setUserId(Integer userId)
     */
    @Test
    public void testSetUserId() throws Exception {
    }

    /**
     * Method: getUserName()
     */
    @Test
    public void testGetUserName() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: setUserName(String userName)
     */
    @Test
    public void testSetUserName() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getUserPassword()
     */
    @Test
    public void testGetUserPassword() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setUserPassword(String userPassword)
     */
    @Test
    public void testSetUserPassword() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getUserGmtCreate()
     */
    @Test
    public void testGetUserGmtCreate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setUserGmtCreate(String userGmtCreate)
     */
    @Test
    public void testSetUserGmtCreate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getUserGmtModified()
     */
    @Test
    public void testGetUserGmtModified() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setUserGmtModified(String userGmtModified)
     */
    @Test
    public void testSetUserGmtModified() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
//TODO: Test goes here... 
    }
} 
