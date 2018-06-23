package com.wang.service.service;

import com.wang.bean.doo.DiaryDO;
import com.wang.service.Service;

/**
 * 日记内容更新
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface DiaryUpdateService extends Service {
    void updateDiary(DiaryDO diaryDO);
}
