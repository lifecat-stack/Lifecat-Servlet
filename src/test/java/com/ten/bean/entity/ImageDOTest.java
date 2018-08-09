package com.ten.bean.entity;

import org.junit.*;

/**
 * ImageDO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÎåÔÂ 20, 2018</pre>
 */
public class ImageDOTest {
    private static ImageDO imageDO;

    @BeforeClass
    public static void beforeClass() {
        imageDO = new ImageDO();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() {
        imageDO = null;
    }

    /**
     * Method: getImageId()
     */
    @Test
    public void testGetImageId() throws Exception {
        imageDO.setImageId(17);
        assert imageDO.getImageId() == 17;
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
        imageDO.setUserId(17);
        assert imageDO.getUserId() == 17;
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
        imageDO.setClassId(17);
        assert imageDO.getClassId() == 17;
    }

    /**
     * Method: setClassId(Integer classId)
     */
    @Test
    public void testSetClassId() throws Exception {
    }

    /**
     * Method: getImageText()
     */
    @Test
    public void testGetImageText() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setImageText(String imageText)
     */
    @Test
    public void testSetImageText() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getImagePath()
     */
    @Test
    public void testGetImagePath() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setImagePath(String imagePath)
     */
    @Test
    public void testSetImagePath() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getDeleted()
     */
    @Test
    public void testGetDeleted() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setDeleted(String deleted)
     */
    @Test
    public void testSetDeleted() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getImageGmtCreate()
     */
    @Test
    public void testGetImageGmtCreate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setImageGmtCreate(String imageGmtCreate)
     */
    @Test
    public void testSetImageGmtCreate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getImageGmtModified()
     */
    @Test
    public void testGetImageGmtModified() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setImageGmtModified(String imageGmtModified)
     */
    @Test
    public void testSetImageGmtModified() throws Exception {
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
