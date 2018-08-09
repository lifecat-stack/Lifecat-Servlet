package com.ten.dao.mybatisimpl;

import com.ten.bean.entity.DiaryDO;

import java.util.List;
import java.util.Map;

public interface DiaryMapper {

    List<DiaryDO> selectDiaryListByUserId(int userId);

    DiaryDO selectDiaryByDiaryName(Map<String, String> map);

    int insertDiary(DiaryDO diaryDO);

    int updateDiary(DiaryDO diaryDO);

    int deleteDiaryById(int diaryId);
}
