package com.wang.dao.jdbcimpl;

import com.wang.bean.doo.DiaryDO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * DiaryDAOImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 6, 2018</pre>
 */
public class DiaryDAOImplTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: newDiaryDAO()
     */
    @Test
    public void testNewDiaryDAO() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: insertDiary(DiaryDO diaryDO)
     */
    @Test
    public void testInsertDiary() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: updateDiary(DiaryDO diaryDO)
     */
    @Test
    public void testUpdateDiary() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteDiary(Integer diaryId)
     */
    @Test
    public void testDeleteDiary() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: queryDiary(String diaryName)
     */
    @Test
    public void testQueryDiary() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: queryDiaryList(Integer userId)
     */
    @Test
    public void testQueryDiaryList() throws Exception {
        DiaryDAOImpl dao = new DiaryDAOImpl();
        List<DiaryDO> list = dao.queryDiaryList(1);
        System.out.println(list.size());
    }


} 
