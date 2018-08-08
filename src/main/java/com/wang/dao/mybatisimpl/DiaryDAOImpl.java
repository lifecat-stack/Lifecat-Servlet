package com.wang.dao.mybatisimpl;

import com.wang.bean.entity.DiaryDO;
import com.wang.dao.DiaryDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * UserDAO -- jdbc实现类
 *
 * @auther ten
 */
class DiaryDAOImpl extends AbstractDAO implements DiaryDAO {
    private DiaryDAOImpl() {
    }

    static DiaryDAO newDiaryDAO() {
        return new DiaryDAOImpl();
    }

    @Override
    public int insertDiary(DiaryDO diaryDO) throws SQLException {
        return 0;

    }

    @Override
    public void updateDiary(DiaryDO diaryDO) throws SQLException {

    }

    @Override
    public void deleteDiary(Integer diaryId) throws SQLException {

    }

    @Override
    public void deleteAllDiary(Integer userId) throws SQLException {

    }

    @Override
    public DiaryDO queryDiary(String diaryName) throws SQLException {
        return null;
    }

    @Override
    public List<DiaryDO> queryDiaryList(Integer userId) throws SQLException {
        return null;
    }
}
