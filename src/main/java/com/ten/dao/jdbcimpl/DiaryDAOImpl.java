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
        String sql = "INSERT INTO diary(diary_name, diary_text, is_deleted, user_id, create_time, update_time) " +
                "VALUES( ?,?,?,?,?,?)";
        Object[] args = {
                diary.getDiaryName(),
                diary.getdiaryText(),
                diary.getIsDeleted(),
                diary.getUserId(),
                diary.getCreateTime(),
                diary.getUpdateTime()
        };

        return insertAndReturnKey(sql, args);
    }

    @Override
    public int updateDiary(Diary diary) throws SQLException {
        int diaryId = diary.getId();
        String diaryName = diary.getDiaryName();
        String diaryText = diary.getdiaryText();
        String modifiedTime = diary.getdiaryGmtModified();
        String sql = "UPDATE diary set diary_name = '" + diaryName + "'," +
                "diary_text='" + diaryText + "'," +
                "update_time='" + modifiedTime + "' " +
                "where id = '" + diaryId + "'";
        update(sql);
        return diaryId;
    }

    @Override
    public int deleteDiary(Integer diaryId) throws SQLException {
        String sql = "UPDATE diary set is_deleted = '1' where id = '" + diaryId + "'";
        delete(sql);
        return 1;
    }

    @Override
    public int deleteAllDiary(Integer userId) throws SQLException {
        String sql = "UPDATE diary set is_deleted = '1' where user_id = '" + userId + "'";
        delete(sql);
        return 1;
    }

    @Override
    public Diary queryDiary(String diaryName) throws SQLException {
        String sql = "SELECT id,diary_name,diary_text,update_time from diary where diary_name = '" + diaryName + "' and is_deleted = '0'";
        ResultSet rs = query(sql);
        rs.next();
        Diary diary = new Diary();
        diary.setId(rs.getInt("id"));
        diary.setDiaryName(rs.getString("diary_name"));
        diary.setdiaryText(rs.getString("diary_text"));
        diary.setdiaryGmtModified(rs.getString("update_time"));

        return diary;
    }

    @Override
    public List<Diary> queryDiaryList(Integer userId) throws SQLException {
        String sql = "SELECT id,diary_name,diary_text,update_time from diary where user_id = '" + userId + "' and is_deleted = '0'";
        ResultSet rs = query(sql);
        List<Diary> list = new ArrayList<>();
        while (rs.next()) {
            Diary diary = new Diary();
            diary.setId(rs.getInt("id"));
            diary.setDiaryName(rs.getString("diary_name"));
            diary.setdiaryText(rs.getString("diary_text"));
            diary.setdiaryGmtModified(rs.getString("update_time"));
            list.add(diary);
        }
        return list;
    }
}
