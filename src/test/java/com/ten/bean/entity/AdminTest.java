package com.ten.bean.entity;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Admin Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÎåÔÂ 20, 2018</pre>
 */
public class AdminTest {
    private static Admin admin;

    @BeforeClass
    public static void beforeClass() {
        admin = new Admin();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() {
        admin = null;
    }

    /**
     * Method: getAdminId()
     */
    @Test
    public void testGetAdminId() throws Exception {
        admin.setAdminId(17);
        assert admin.getAdminId() == 17;
    }

    /**
     * Method: setAdminId(int adminId)
     */
    @Test
    public void testSetAdminId() throws Exception {
    }

    /**
     * Method: getAdminName()
     */
    @Test
    public void testGetAdminName() throws Exception {
        admin.setAdminName("wang");
        assertEquals("wang", admin.getAdminName());
    }

    /**
     * Method: setAdminName(String adminName)
     */
    @Test
    public void testSetAdminName() throws Exception {
    }

    /**
     * Method: getAdminPassword()
     */
    @Test
    public void testGetAdminPassword() throws Exception {
        admin.setAdminPassword("123456");
        assertEquals("123456", admin.getAdminPassword());
    }

    /**
     * Method: setAdminPassword(String adminPassword)
     */
    @Test
    public void testSetAdminPassword() throws Exception {
    }

    /**
     * Method: getAdminLevel()
     */
    @Test
    public void testGetAdminLevel() throws Exception {
        admin.setAdminLevel("user");
        assertEquals("user", admin.getAdminLevel());
    }

    /**
     * Method: setAdminLevel(String adminLevel)
     */
    @Test
    public void testSetAdminLevel() throws Exception {
    }

    /**
     * Method: getAdminGmtCreate()
     */
    @Test
    public void testGetAdminGmtCreate() throws Exception {
        admin.setAdminGmtCreate("2018-06-01 23:59:59");
        assertEquals("2018-06-01 23:59:59", admin.getAdminGmtCreate());
    }

    /**
     * Method: setAdminGmtCreate(String adminGmtCreate)
     */
    @Test
    public void testSetAdminGmtCreate() throws Exception {
    }

    /**
     * Method: getAdminGmtModified()
     */
    @Test
    public void testGetAdminGmtModified() throws Exception {
        admin.setAdminGmtModified("2018-06-01 23:59:59");
        assertEquals("2018-06-01 23:59:59", admin.getAdminGmtModified());
    }

    /**
     * Method: setAdminGmtModified(String adminGmtModified)
     */
    @Test
    public void testSetAdminGmtModified() throws Exception {
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("Admin:" + admin.toString());
    }
} 
