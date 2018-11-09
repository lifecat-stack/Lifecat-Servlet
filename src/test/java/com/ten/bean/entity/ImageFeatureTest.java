package com.ten.bean.entity;

import org.junit.*;

/**
 * ImageFeature Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class ImageFeatureTest {
    private static ImageFeature imageFeature;

    @BeforeClass
    public static void beforeClass() {
        imageFeature = new ImageFeature();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() {
        imageFeature = null;
    }

    /**
     * Method: getImageId()
     */
    @Test
    public void testGetImageId() throws Exception {
        imageFeature.setImageId(17);
        assert imageFeature.getImageId() == 17;
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
