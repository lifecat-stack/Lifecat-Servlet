package com.ten.bean.entity;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Diary Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÎåÔÂ 20, 2018</pre>
 */
public class DiaryTest {
    private static Diary diary;

    @BeforeClass
    public static void beforeClass() {
        diary = new Diary();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() {
        diary = null;
    }

    /**
     * Method: getDiaryId()
     */
    @Test
    public void testGetDiaryId() throws Exception {
        diary.setDiaryId(17);
        assert diary.getDiaryId() == 17;
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
        diary.setUserId(17);
        assert diary.getUserId() == 17;
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
        diary.setDiaryName("diary");
        assertEquals("diary", diary.getDiaryName());
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
        diary.setdiaryText("this is text");
        assertEquals("this is text", diary.getdiaryText());
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
        diary.setDeleted(1);
        assert diary.getDeleted() == 1;
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
        diary.setdiaryGmtCreate("2018-01-01 23:59:59");
        assertEquals("2018-01-01 23:59:59", diary.getdiaryGmtCreate());
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
        diary.setdiaryGmtModified("2018-01-01 23:59:59");
        assertEquals("2018-01-01 23:59:59", diary.getdiaryGmtModified());
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
        System.out.println("Diary:" + diary.toString());
    }
} 
