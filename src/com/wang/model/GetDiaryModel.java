package com.wang.model;

import com.wang.bean.Diary;
import com.wang.bean.User;
import com.wang.dao.DiaryDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @name GetDiaryModel
 * @description 获取用户日记信息
 * @auther ten
 */
public class GetDiaryModel extends MyModel {
    private DiaryDAO dao;
    private ArrayList<Diary> diaries;

    /* 初始化 */
    public GetDiaryModel() {
        dao = new DiaryDAO();
        diaries = new ArrayList<>();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
    }

    /* 获取用户日记列表 */
    public ArrayList<Diary> getDiaries(int id) {
        diaries = dao.getDiaryList(id);
        return diaries;
    }
}
