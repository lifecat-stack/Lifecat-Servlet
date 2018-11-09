package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.Diary;
import com.ten.dao.DAOFactory;
import com.ten.dao.DiaryDAO;
import com.ten.dao.JdbcDAOFactory;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * DiaryDAOImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 6, 2018</pre>
 */
public class DiaryDAOImplTest {

    private static DAOFactory daoFactory;
    private DiaryDAO dao;

    @BeforeClass
    public static void beforeClass() throws Exception {
        daoFactory = new JdbcDAOFactory();
    }

    @Before
    public void before() throws Exception {
        dao = (DiaryDAO) daoFactory.getDaoByTableName("diary");
        assertNotNull(dao);
    }

    @After
    public void after() throws Exception {
        dao = null;
    }

    @AfterClass
    public static void afterClass() throws Exception {
        daoFactory = null;
    }

    /**
     * Method: insertDiary(Diary diaryDO)
     */
    @Test
    public void testInsertDiary() throws Exception {
        Diary diary = new Diary();
        assertNotNull(diary);

        diary.setdiaryText("this is test diary");
        diary.setUserId(1);
        diary.setDeleted(1);
        diary.setDiaryName("this is test diary");
        diary.setdiaryGmtCreate("2019-01-01 00:00:00");
        diary.setdiaryGmtModified("2019-01-01 00:00:00");

        int key = dao.insertDiary(diary);
        assertNotEquals(key, 0);
    }

    /**
     * Method: updateDiary(Diary diaryDO)
     */
    @Test
    public void testUpdateDiary() throws Exception {
        Diary diary = new Diary();
        assertNotNull(diary);

        diary.setDiaryId(10);
        diary.setdiaryText("this is update diary");
        diary.setDiaryName("this is test diary");
        diary.setdiaryGmtModified("2019-01-01 00:00:00");

        dao.updateDiary(diary);
    }

    /**
     * Method: deleteDiary(Integer diaryId)
     */
    @Test
    public void testDeleteDiary() throws Exception {
        dao.deleteDiary(10);
    }

    /**
     * Method: queryDiary(String diaryName)
     */
    @Test
    public void testQueryDiary() throws Exception {
        Diary diary = dao.queryDiary("diary01");

        assertNotNull(diary.getDiaryId());
        assertNotNull(diary.getDiaryName());
        assertNotNull(diary.getdiaryText());
        assertNotNull(diary.getdiaryGmtModified());
    }

    /**
     * Method: queryDiaryList(Integer userId)
     */
    @Test
    public void testQueryDiaryList() throws Exception {
        DiaryDAOImpl dao = new DiaryDAOImpl();
        List<Diary> list = dao.queryDiaryList(1);

        assert list.size() >= 1;
    }


} 
