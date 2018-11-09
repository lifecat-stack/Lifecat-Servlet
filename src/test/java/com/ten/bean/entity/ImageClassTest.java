package com.ten.bean.entity;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * ImageClass Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class ImageClassTest {
    private static ImageClass imageClass;

    @BeforeClass
    public static void beforeClass() {
        imageClass = new ImageClass();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() {
        imageClass = null;
    }

    /**
     * Method: getImageClassId()
     */
    @Test
    public void testGetImageClassId() throws Exception {
        imageClass.setImageClassId(17);
        assert imageClass.getImageClassId() == 17;
    }

    /**
     * Method: setImageClassId(Integer imageClassId)
     */
    @Test
    public void testSetImageClassId() throws Exception {
    }

    /**
     * Method: getImageClassName()
     */
    @Test
    public void testGetImageClassName() throws Exception {
        imageClass.setImageClassName("view");
        assertEquals("view", imageClass.getImageClassName());
    }

    /**
     * Method: setImageClassName(String imageClassName)
     */
    @Test
    public void testSetImageClassName() throws Exception {
    }

    /**
     * Method: getImageClassDesc()
     */
    @Test
    public void testGetImageClassDesc() throws Exception {
        imageClass.setImageClassDesc("this is view");
        assertEquals("this is view", imageClass.getImageClassDesc());
    }

    /**
     * Method: setImageClassDesc(String imageClassDesc)
     */
    @Test
    public void testSetImageClassDesc() throws Exception {
    }

    /**
     * Method: getClassGmtCreate()
     */
    @Test
    public void testGetClassGmtCreate() throws Exception {
        imageClass.setClassGmtCreate("2018-06-01 23:59:59");
        assertEquals("2018-06-01 23:59:59", imageClass.getClassGmtCreate());
    }

    /**
     * Method: setClassGmtCreate(String classGmtCreate)
     */
    @Test
    public void testSetClassGmtCreate() throws Exception {
    }

    /**
     * Method: getClassGmtModified()
     */
    @Test
    public void testGetClassGmtModified() throws Exception {
        imageClass.setClassGmtModified("2018-06-01 23:59:59");
        assertEquals("2018-06-01 23:59:59", imageClass.getClassGmtModified());
    }

    /**
     * Method: setClassGmtModified(String classGmtModified)
     */
    @Test
    public void testSetClassGmtModified() throws Exception {
    }


} 
