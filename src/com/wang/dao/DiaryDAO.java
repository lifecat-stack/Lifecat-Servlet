package com.wang.dao;

import com.wang.bean.Diary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @name DiaryDAO
 * @description 对diary数据库进行操作
 * @auther ten
 */
public class DiaryDAO extends BaseDAO implements DAO {
    private static final String diaryname = "diaryname";
    private static final String diarydescription = "diarydescription";
    private static final String diarydate = "diarydate";
    private static final String diarypath = "diarypath";
    private static final String table = "diary";

    /* 上传form内容到数据库 */
    public boolean uploadDiary(Diary diary) {
        Object[] attributes = new Object[5];
        attributes[0] = diary.getId();
        attributes[1] = diary.getName();
        attributes[2] = diary.getDescription();
        attributes[3] = diary.getDate();
        attributes[4] = diary.getPath();
        return this.exeInsert(table, attributes);
    }

    /* 根据用户ID获取diary数据集 */
    public ArrayList<Diary> getDiaryList(int id) {
        ArrayList<Diary> diaries = new ArrayList<>();
        ResultSet resultSet = exeSelect("*", table, id);
        System.out.println("diary成功获取到resultset");
        try {
            while (resultSet.next()) {
                Diary diary=new Diary();
                diary.setName(resultSet.getString(diaryname));
                diary.setDescription(resultSet.getString(diarydescription));
                diary.setDate(resultSet.getString(diarydate));
                diary.setPath(resultSet.getString(diarypath));
                diaries.add(diary);
            }
        } catch (SQLException e) {
            System.out.println("读取diary的时候出错");
            e.printStackTrace();
        }
        return diaries;
    }
}
