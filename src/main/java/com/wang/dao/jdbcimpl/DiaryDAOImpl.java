package com.wang.dao.jdbcimpl;

import com.wang.bean.doo.DiaryDO;
import com.wang.dao.DiaryDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDAO -- jdbc实现类
 *
 * @auther ten
 */
class DiaryDAOImpl extends AbstractDAO implements DiaryDAO {
    public DiaryDAOImpl() {
    }

    @Override
    public int insertDiary(DiaryDO diaryDO) throws SQLException {
        String sql = "INSERT INTO diary(diary_name, diary_text, is_deleted, user_id, diary_gmt_create, diary_gmt_modified) " +
                "VALUES( ?,?,?,?,?,?)";
        Object[] args = {
                diaryDO.getDiaryName(),
                diaryDO.getdiaryText(),
                diaryDO.getDeleted(),
                diaryDO.getUserId(),
                diaryDO.getdiaryGmtCreate(),
                diaryDO.getdiaryGmtModified()
        };

        return insertAndReturnKey(sql, args);
    }

    @Override
    public void updateDiary(DiaryDO diaryDO) throws SQLException {

    }

    @Override
    public void deleteDiary(Integer diaryId) throws SQLException {

    }

    @Override
    public DiaryDO queryDiary(String diaryName) throws SQLException {
        return null;
    }

    @Override
    public List<DiaryDO> queryDiaryList(Integer userId) throws SQLException {
         String sql = "SELECT diary_id,diary_name,diary_text,diary_gmt_modified from diary where user_id = '" + userId + "' and is_deleted = '1'";
        ResultSet rs = query(sql);
        List<DiaryDO> list = new ArrayList<>();
        while (rs.next()) {
            DiaryDO diaryDO = new DiaryDO();
            diaryDO.setDiaryId(rs.getInt("diary_id"));
            diaryDO.setDiaryName(rs.getString("diary_name"));
            diaryDO.setdiaryText(rs.getString("diary_text"));
            diaryDO.setdiaryGmtModified(rs.getString("diary_gmt_modified"));
            list.add(diaryDO);
        }
        return list;
    }
}
