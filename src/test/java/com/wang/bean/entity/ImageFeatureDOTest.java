package com.wang.bean.entity;

import org.junit.*;

/**
 * ImageFeatureDO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class ImageFeatureDOTest {
    private static ImageFeatureDO imageFeatureDO;

    @BeforeClass
    public static void beforeClass() {
        imageFeatureDO = new ImageFeatureDO();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() {
        imageFeatureDO = null;
    }

    /**
     * Method: getImageId()
     */
    @Test
    public void testGetImageId() throws Exception {
        imageFeatureDO.setImageId(17);
        assert imageFeatureDO.getImageId() == 17;
    }

    /**
     * Method: setImageId(Integer imageId)
     */
    @Test
    public void testSetImageId() throws Exception {
    }

    /**
     * Method: getImageClass()
     */
    @Test
    public void testGetImageClass() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setImageClass(Integer imageClass)
     */
    @Test
    public void testSetImageClass() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getImageFeaturePath()
     */
    @Test
    public void testGetImageFeaturePath() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setImageFeaturePath(String imageFeaturePath)
     */
    @Test
    public void testSetImageFeaturePath() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getFeatureGmtCreate()
     */
    @Test
    public void testGetFeatureGmtCreate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setFeatureGmtCreate(String featureGmtCreate)
     */
    @Test
    public void testSetFeatureGmtCreate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getFeatureGmtModified()
     */
    @Test
    public void testGetFeatureGmtModified() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setFeatureGmtModified(String featureGmtModified)
     */
    @Test
    public void testSetFeatureGmtModified() throws Exception {
//TODO: Test goes here... 
    }
} 
