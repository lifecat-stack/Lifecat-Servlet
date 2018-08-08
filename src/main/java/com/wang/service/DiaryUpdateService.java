package com.wang.service;

import com.wang.bean.entity.DiaryDO;
import com.wang.service.util.Service;

/**
 * 日记内容更新
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface DiaryUpdateService extends Service {
    void updateDiary(DiaryDO diaryDO);
}
