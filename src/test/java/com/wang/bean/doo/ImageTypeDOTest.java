package com.wang.bean.doo;

import org.junit.*;

/**
 * ImageTypeDO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class ImageTypeDOTest {
    private static ImageTypeDO imageTypeDO;

    @BeforeClass
    public static void beforeClass() {
        imageTypeDO = new ImageTypeDO();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() {
        imageTypeDO = null;
    }

    /**
     * Method: getImageId()
     */
    @Test
    public void testGetImageId() throws Exception {
        imageTypeDO.setImageId(17);
        assert imageTypeDO.getImageId() == 17;
    }

    /**
     * Method: setImageId(Integer imageId)
     */
    @Test
    public void testSetImageId() throws Exception {
    }

    /**
     * Method: getUserId()
     */
    @Test
    public void testGetUserId() throws Exception {
        imageTypeDO.setUserId(17);
        assert imageTypeDO.getUserId() == 17;
    }

    /**
     * Method: setUserId(Integer userId)
     */
    @Test
    public void testSetUserId() throws Exception {
    }

    /**
     * Method: getClassId()
     */
    @Test
    public void testGetClassId() throws Exception {
        imageTypeDO.setClassId(17);
        assert imageTypeDO.getClassId() == 17;
    }

    /**
     * Method: setClassId(Integer classId)
     */
    @Test
    public void testSetClassId() throws Exception {
    }

    /**
     * Method: getTypeGmtCreate()
     */
    @Test
    public void testGetTypeGmtCreate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setTypeGmtCreate(String typeGmtCreate)
     */
    @Test
    public void testSetTypeGmtCreate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getTypeGmtModified()
     */
    @Test
    public void testGetTypeGmtModified() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setTypeGmtModified(String typeGmtModified)
     */
    @Test
    public void testSetTypeGmtModified() throws Exception {
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
