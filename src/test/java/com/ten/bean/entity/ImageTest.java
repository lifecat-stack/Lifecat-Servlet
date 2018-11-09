package com.ten.bean.entity;

import org.junit.*;

/**
 * Image Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÎåÔÂ 20, 2018</pre>
 */
public class ImageTest {
    private static Image image;

    @BeforeClass
    public static void beforeClass() {
        image = new Image();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() {
        image = null;
    }

    /**
     * Method: getImageId()
     */
    @Test
    public void testGetImageId() throws Exception {
        image.setImageId(17);
        assert image.getImageId() == 17;
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
        image.setUserId(17);
        assert image.getUserId() == 17;
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
        image.setClassId(17);
        assert image.getClassId() == 17;
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
