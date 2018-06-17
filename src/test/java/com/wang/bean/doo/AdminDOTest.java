package com.wang.bean.doo;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * AdminDO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÎåÔÂ 20, 2018</pre>
 */
public class AdminDOTest {
    private static AdminDO adminDO;

    @BeforeClass
    public static void beforeClass() {
        adminDO = new AdminDO();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() {
        adminDO = null;
    }

    /**
     * Method: getAdminId()
     */
    @Test
    public void testGetAdminId() throws Exception {
        adminDO.setAdminId(17);
        assert adminDO.getAdminId() == 17;
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
        adminDO.setAdminName("wang");
        assertEquals("wang", adminDO.getAdminName());
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
        adminDO.setAdminPassword("123456");
        assertEquals("123456", adminDO.getAdminPassword());
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
        adminDO.setAdminLevel("user");
        assertEquals("user", adminDO.getAdminLevel());
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
        adminDO.setAdminGmtCreate("2018-06-01 23:59:59");
        assertEquals("2018-06-01 23:59:59", adminDO.getAdminGmtCreate());
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
        adminDO.setAdminGmtModified("2018-06-01 23:59:59");
        assertEquals("2018-06-01 23:59:59", adminDO.getAdminGmtModified());
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
        System.out.println("AdminDO:" + adminDO.toString());
    }
} 
