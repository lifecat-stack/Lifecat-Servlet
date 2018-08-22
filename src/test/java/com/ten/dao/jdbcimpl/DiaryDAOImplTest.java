package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.DiaryDO;
import com.ten.dao.DAOFactory;
import com.ten.dao.DiaryDAO;
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
     * Method: insertDiary(DiaryDO diaryDO)
     */
    @Test
    public void testInsertDiary() throws Exception {
        DiaryDO diaryDO = new DiaryDO();
        assertNotNull(diaryDO);

        diaryDO.setdiaryText("this is test diary");
        diaryDO.setUserId(1);
        diaryDO.setDeleted(1);
        diaryDO.setDiaryName("this is test diary");
        diaryDO.setdiaryGmtCreate("2019-01-01 00:00:00");
        diaryDO.setdiaryGmtModified("2019-01-01 00:00:00");

        int key = dao.insertDiary(diaryDO);
        assertNotEquals(key, 0);
    }

    /**
     * Method: updateDiary(DiaryDO diaryDO)
     */
    @Test
    public void testUpdateDiary() throws Exception {
        DiaryDO diaryDO = new DiaryDO();
        assertNotNull(diaryDO);

        diaryDO.setDiaryId(10);
        diaryDO.setdiaryText("this is update diary");
        diaryDO.setDiaryName("this is test diary");
        diaryDO.setdiaryGmtModified("2019-01-01 00:00:00");

        dao.updateDiary(diaryDO);
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
        DiaryDO diaryDO = dao.queryDiary("diary01");

        assertNotNull(diaryDO.getDiaryId());
        assertNotNull(diaryDO.getDiaryName());
        assertNotNull(diaryDO.getdiaryText());
        assertNotNull(diaryDO.getdiaryGmtModified());
    }

    /**
     * Method: queryDiaryList(Integer userId)
     */
    @Test
    public void testQueryDiaryList() throws Exception {
        DiaryDAOImpl dao = new DiaryDAOImpl();
        List<DiaryDO> list = dao.queryDiaryList(1);

        assert list.size() >= 1;
    }


} 
