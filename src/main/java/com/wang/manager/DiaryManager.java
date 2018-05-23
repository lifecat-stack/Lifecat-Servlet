package com.wang.manager;

import com.wang.bean.Diary;
import com.wang.dao.jdbcimpl.DAOFactory;
import com.wang.dao.jdbcimpl.DiaryDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * DiaryManager: diary表操作
 * <p>
 * 访问范围: 全局
 * 调用者: Service
 * 异常检测: 确保DAO参数无差错
 * <p>
 * 1. 查询diary queryDiary(diary_id)
 * 2. 插入diary insertDiary(Diary)
 * 3. 获取diaries queryDiaries(user_id)
 *
 * @auther ten
 */
public class DiaryManager implements Manager {
    private final int userid;
    private final DiaryDAO dao;
    private final Logger logger;

    private DiaryManager(int userid) {
        this.userid = userid;
        this.dao = (DiaryDAO) DAOFactory.getDAOByName("DiaryDAO");
        this.logger = Logger.getLogger("DiaryManager@" + userid);
    }

    static Manager getUserDiaryModel(int userid) {
        return new DiaryManager(userid);
    }

    /**
     * 查询diary by diary_id
     *
     * @param diary_id diary_id
     * @throws SQLException         queryDiary()异常
     * @throws NullPointerException 数据库查询为空
     */
    public Diary queryDiary(int diary_id) throws SQLException {
        logger.info("queryDiary()");

        return dao.queryDiary(userid, diary_id);
    }

    /**
     * 插入diary to (diary)
     *
     * @throws SQLException             insertDiary()异常
     * @throws IllegalArgumentException diary属性为空
     */
    public void insertDiary(Diary diary) throws SQLException {
        logger.info("insertDiary()");

        final boolean isNull = diary.getDiary_name() == null || diary.getDiary_date() == null || diary.getDiary_desc() == null;

        if (isNull) {
            throw new IllegalArgumentException("diary argument is null");
        }

        dao.insertDiary(userid, diary);
    }

    /**
     * 获取diaries by user_id
     *
     * @return List Diary集合
     * @throws SQLException         queryDiaries()异常
     * @throws NullPointerException 数据库查询为空
     */
    public List<Diary> queryDiaries(int user_id) throws SQLException {
        logger.info("queryDiaries()");

        List<Diary> list;

        list = dao.queryDiaries(user_id);

        //若List为空, 用空集合代替Null
        if (list.size() == 0) {
            return new ArrayList<>();
        }

        return list;
    }
}
