package com.ten.lifecat.servlet.service;

import com.ten.lifecat.servlet.entity.Diary;
import com.ten.lifecat.servlet.service.util.Service;
import com.ten.service.util.Service;

/**
 * 日记内容更新
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface DiaryUpdateService extends Service {

    void updateDiary(Diary diary);
}
