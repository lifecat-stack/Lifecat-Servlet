package com.ten.service;

import com.ten.bean.entity.DiaryDO;
import com.ten.service.util.Service;

/**
 * 日记内容更新
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface DiaryUpdateService extends Service {
    void updateDiary(DiaryDO diaryDO);
}
