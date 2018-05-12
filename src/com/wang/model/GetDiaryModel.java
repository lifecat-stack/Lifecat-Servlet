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
class  GetDiaryModel implements MyModel {
        private GetDiaryModel() {
    }

    static MyModel getModel() {
        return new GetDiaryModel();
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
