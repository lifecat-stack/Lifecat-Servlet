package com.wang.bean.dto;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * DiaryDTO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class DiaryDTOTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: compareTo(DiaryDTO diary)
     */
    @Test
    public void testCompareTo() throws Exception {
        DiaryDTO diaryDTO1 = new DiaryDTO.Builder(1).diaryDate("2018-03-01 01:00:00").build();
        DiaryDTO diaryDTO2 = new DiaryDTO.Builder(2).diaryDate("2018-01-01 00:00:00").build();
        assert diaryDTO1.compareTo(diaryDTO2) > 0;
    }

    /**
     * Method: equals(Object obj)
     */
    @Test
    public void testEquals() throws Exception {
        DiaryDTO diaryDTO1 = new DiaryDTO.Builder(1).diaryName("diary").diaryText("text").diaryDate("2018-01-01 00:00:00").build();
        DiaryDTO diaryDTO2 = new DiaryDTO.Builder(1).diaryName("diary").diaryText("text").diaryDate("2018-01-01 00:00:00").build();
        assertEquals(diaryDTO1, diaryDTO2);
    }


    /**
     * Method: hashCode()
     */
    @Test
    public void testHashCode() throws Exception {
        DiaryDTO diaryDTO1 = new DiaryDTO.Builder(1).diaryName("diary").diaryText("text").diaryDate("2018-01-01 00:00:00").build();
        DiaryDTO diaryDTO2 = new DiaryDTO.Builder(1).diaryName("diary").diaryText("text").diaryDate("2018-01-01 00:00:00").build();
        assertEquals(diaryDTO1.hashCode(), diaryDTO2.hashCode());
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
    }

    /**
     * Method: getDiaryId()
     */
    @Test
    public void testGetDiaryId() throws Exception {
        DiaryDTO diaryDTO = new DiaryDTO.Builder(1).diaryName("diary").diaryText("text").diaryDate("2018-01-01 00:00:00").build();
        assert diaryDTO.getDiaryId() == 1;
    }

    /**
     * Method: getDiaryName()
     */
    @Test
    public void testGetDiaryName() throws Exception {
        DiaryDTO diaryDTO = new DiaryDTO.Builder(1).diaryName("diary").diaryText("text").diaryDate("2018-01-01 00:00:00").build();
        assertEquals("diary", diaryDTO.getDiaryName());
    }

    /**
     * Method: getDiaryText()
     */
    @Test
    public void testGetDiaryText() throws Exception {
        DiaryDTO diaryDTO = new DiaryDTO.Builder(1).diaryName("diary").diaryText("text").diaryDate("2018-01-01 00:00:00").build();
        assertEquals("text", diaryDTO.getDiaryText());
    }

    /**
     * Method: getDiaryDate()
     */
    @Test
    public void testGetDiaryDate() throws Exception {
        DiaryDTO diaryDTO = new DiaryDTO.Builder(1).diaryName("diary").diaryText("text").diaryDate("2018-01-01 00:00:00").build();
        assertEquals("2018-01-01 00:00:00", diaryDTO.getDiaryDate());
    }

    /**
     * Method: diaryText(String val)
     */
    @Test
    public void testDiaryText() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: diaryName(String val)
     */
    @Test
    public void testDiaryName() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: diaryDate(String val)
     */
    @Test
    public void testDiaryDate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: build()
     */
    @Test
    public void testBuild() throws Exception {
//TODO: Test goes here... 
    }
}
