package com.ten.lifecat.servlet.dao;

import com.ten.lifecat.servlet.entity.Diary;

import java.util.List;

public interface DiaryDao {

    int insert(Diary pojo);

    int insertList(List<Diary> pojo);

    List<Diary> select(Diary pojo);

    int update(Diary pojo);

}
