package com.wang.bean.dto;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * DiariesDTO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 17, 2018</pre>
 */
public class DiariesDTOTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: newDiaries(int userId)
     */
    @Test
    public void testNewDiaries() throws Exception {
        DiariesDTO diariesDTO1 = DiariesDTO.newDiaries(17);
        DiariesDTO diariesDTO2 = DiariesDTO.newDiaries(17);
        assertEquals(diariesDTO1.toString(), diariesDTO2.toString());
    }

    /**
     * Method: addDiary(DiaryDTO diary)
     */
    @Test
    public void testAddDiary() throws Exception {
        DiariesDTO diariesDTO = DiariesDTO.newDiaries(17);
        DiaryDTO diaryDTO = new DiaryDTO.Builder(1).build();
        diariesDTO.addDiary(diaryDTO);
        assertEquals(diaryDTO, diariesDTO.getDiaryList().get(0));
    }

    /**
     * Method: getDiaryList()
     */
    @Test
    public void testGetDiaryList() throws Exception {
        DiariesDTO diariesDTO = DiariesDTO.newDiaries(17);
        DiaryDTO diaryDTO = new DiaryDTO.Builder(1).build();
        diariesDTO.addDiary(diaryDTO);
        assertEquals(diaryDTO, diariesDTO.getDiaryList().get(0));
        assert diariesDTO.getDiaryList().size() == 1;
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
    }
} 
