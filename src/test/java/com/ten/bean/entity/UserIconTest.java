package com.ten.bean.entity;

import org.junit.*;

/**
 * UserIcon Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 20, 2018</pre>
 */
public class UserIconTest {
    private static UserIcon userIcon;

    @BeforeClass
    public static void beforeClass() {
        userIcon = new UserIcon();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() {
        userIcon = null;
    }

    /**
     * Method: getUserId()
     */
    @Test
    public void testGetUserId() throws Exception {
        userIcon.setUserId(17);
        assert userIcon.getUserId() == 17;
    }

    /**
     * Method: setUserId(Integer userId)
     */
    @Test
    public void testSetUserId() throws Exception {
    }

    /**
     * Method: getIconPath()
     */
    @Test
    public void testGetIconPath() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setIconPath(String iconPath)
     */
    @Test
    public void testSetIconPath() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getIconGmtCreate()
     */
    @Test
    public void testGetIconGmtCreate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setIconGmtCreate(String iconGmtCreate)
     */
    @Test
    public void testSetIconGmtCreate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getIconGmtModified()
     */
    @Test
    public void testGetIconGmtModified() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setIconGmtModified(String iconGmtModified)
     */
    @Test
    public void testSetIconGmtModified() throws Exception {
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
