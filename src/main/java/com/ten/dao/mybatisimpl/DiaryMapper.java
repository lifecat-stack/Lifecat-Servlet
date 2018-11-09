package com.ten.dao.mybatisimpl;

import com.ten.bean.entity.Diary;

import java.util.List;
import java.util.Map;

public interface DiaryMapper {

    List<Diary> selectDiaryListByUserId(int userId);

    Diary selectDiaryByDiaryName(Map<String, String> map);

    int insertDiary(Diary diary);

    int updateDiary(Diary diary);

    int deleteDiaryById(int diaryId);
}
