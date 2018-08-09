package com.ten.bean.entity;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * ImageClassDO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class ImageClassDOTest {
    private static ImageClassDO imageClassDO;

    @BeforeClass
    public static void beforeClass() {
        imageClassDO = new ImageClassDO();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() {
        imageClassDO = null;
    }

    /**
     * Method: getImageClassId()
     */
    @Test
    public void testGetImageClassId() throws Exception {
        imageClassDO.setImageClassId(17);
        assert imageClassDO.getImageClassId() == 17;
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
        imageClassDO.setImageClassName("view");
        assertEquals("view", imageClassDO.getImageClassName());
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
        imageClassDO.setImageClassDesc("this is view");
        assertEquals("this is view", imageClassDO.getImageClassDesc());
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
        imageClassDO.setClassGmtCreate("2018-06-01 23:59:59");
        assertEquals("2018-06-01 23:59:59", imageClassDO.getClassGmtCreate());
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
        imageClassDO.setClassGmtModified("2018-06-01 23:59:59");
        assertEquals("2018-06-01 23:59:59", imageClassDO.getClassGmtModified());
    }

    /**
     * Method: setClassGmtModified(String classGmtModified)
     */
    @Test
    public void testSetClassGmtModified() throws Exception {
    }


} 
