package com.ten.bean.entity;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * DiaryDO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÎåÔÂ 20, 2018</pre>
 */
public class DiaryDOTest {
    private static DiaryDO diaryDO;

    @BeforeClass
    public static void beforeClass() {
        diaryDO = new DiaryDO();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() {
        diaryDO = null;
    }

    /**
     * Method: getDiaryId()
     */
    @Test
    public void testGetDiaryId() throws Exception {
        diaryDO.setDiaryId(17);
        assert diaryDO.getDiaryId() == 17;
    }

    /**
     * Method: setDiaryId(Integer diaryId)
     */
    @Test
    public void testSetDiaryId() throws Exception {
    }

    /**
     * Method: getUserId()
     */
    @Test
    public void testGetUserId() throws Exception {
        diaryDO.setUserId(17);
        assert diaryDO.getUserId() == 17;
    }

    /**
     * Method: setUserId(Integer userId)
     */
    @Test
    public void testSetUserId() throws Exception {
    }

    /**
     * Method: getDiaryName()
     */
    @Test
    public void testGetDiaryName() throws Exception {
        diaryDO.setDiaryName("diary");
        assertEquals("diary", diaryDO.getDiaryName());
    }

    /**
     * Method: setDiaryName(String diaryName)
     */
    @Test
    public void testSetDiaryName() throws Exception {
    }

    /**
     * Method: getdiaryText()
     */
    @Test
    public void testGetdiaryText() throws Exception {
        diaryDO.setdiaryText("this is text");
        assertEquals("this is text", diaryDO.getdiaryText());
    }

    /**
     * Method: setdiaryText(String diaryText)
     */
    @Test
    public void testSetdiaryText() throws Exception {
    }

    /**
     * Method: getDeleted()
     */
    @Test
    public void testGetDeleted() throws Exception {
        diaryDO.setDeleted(1);
        assert diaryDO.getDeleted() == 1;
    }

    /**
     * Method: setDeleted(String deleted)
     */
    @Test
    public void testSetDeleted() throws Exception {
    }


    /**
     * Method: getdiaryGmtCreate()
     */
    @Test
    public void testGetdiaryGmtCreate() throws Exception {
        diaryDO.setdiaryGmtCreate("2018-01-01 23:59:59");
        assertEquals("2018-01-01 23:59:59", diaryDO.getdiaryGmtCreate());
    }

    /**
     * Method: setdiaryGmtCreate(String diaryGmtCreate)
     */
    @Test
    public void testSetdiaryGmtCreate() throws Exception {
    }

    /**
     * Method: getdiaryGmtModified()
     */
    @Test
    public void testGetdiaryGmtModified() throws Exception {
        diaryDO.setdiaryGmtModified("2018-01-01 23:59:59");
        assertEquals("2018-01-01 23:59:59", diaryDO.getdiaryGmtModified());
    }

    /**
     * Method: setdiaryGmtModified(String diaryGmtModified)
     */
    @Test
    public void testSetdiaryGmtModified() throws Exception {
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("DiaryDO:" + diaryDO.toString());
    }
} 
