package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.Diary;
import com.ten.dao.BaseDAO;
import com.ten.dao.DiaryDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDAO -- jdbc实现类
 *
 * @auther ten
 */
public class DiaryDAOImpl extends BaseDAO implements DiaryDAO {
    public DiaryDAOImpl() {
    }

    @Override
    public int insertDiary(Diary diary) throws SQLException {
        String sql = "INSERT INTO diary(diary_name, diary_text, is_deleted, user_id, diary_gmt_create, diary_gmt_modified) " +
                "VALUES( ?,?,?,?,?,?)";
        Object[] args = {
                diary.getDiaryName(),
                diary.getdiaryText(),
                diary.getDeleted(),
                diary.getUserId(),
                diary.getdiaryGmtCreate(),
                diary.getdiaryGmtModified()
        };

        return insertAndReturnKey(sql, args);
    }

    @Override
    public void updateDiary(Diary diary) throws SQLException {
        int diaryId = diary.getDiaryId();
        String diaryName = diary.getDiaryName();
        String diaryText = diary.getdiaryText();
        String modifiedTime = diary.getdiaryGmtModified();
        String sql = "UPDATE diary set diary_name = '" + diaryName + "'," +
                "diary_text='" + diaryText + "'," +
                "diary_gmt_modified='" + modifiedTime + "' " +
                "where diary_id = '" + diaryId + "'";
        update(sql);
    }

    @Override
    public void deleteDiary(Integer diaryId) throws SQLException {
        String sql = "UPDATE diary set is_deleted = '0' where diary_id = '" + diaryId + "'";
        delete(sql);
    }

    @Override
    public void deleteAllDiary(Integer userId) throws SQLException {
        String sql = "UPDATE diary set is_deleted = '0' where user_id = '" + userId + "'";
        delete(sql);
    }

    @Override
    public Diary queryDiary(String diaryName) throws SQLException {
        String sql = "SELECT diary_id,diary_name,diary_text,diary_gmt_modified from diary where diary_name = '" + diaryName + "' and is_deleted = '1'";
        ResultSet rs = query(sql);
        rs.next();
        Diary diary = new Diary();
        diary.setDiaryId(rs.getInt("diary_id"));
        diary.setDiaryName(rs.getString("diary_name"));
        diary.setdiaryText(rs.getString("diary_text"));
        diary.setdiaryGmtModified(rs.getString("diary_gmt_modified"));

        return diary;
    }

    @Override
    public List<Diary> queryDiaryList(Integer userId) throws SQLException {
        String sql = "SELECT diary_id,diary_name,diary_text,diary_gmt_modified from diary where user_id = '" + userId + "' and is_deleted = '1'";
        ResultSet rs = query(sql);
        List<Diary> list = new ArrayList<>();
        while (rs.next()) {
            Diary diary = new Diary();
            diary.setDiaryId(rs.getInt("diary_id"));
            diary.setDiaryName(rs.getString("diary_name"));
            diary.setdiaryText(rs.getString("diary_text"));
            diary.setdiaryGmtModified(rs.getString("diary_gmt_modified"));
            list.add(diary);
        }
        return list;
    }
}
