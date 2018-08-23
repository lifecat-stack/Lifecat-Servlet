package com.ten.service;

import com.ten.service.util.Service;

/**
 * 日记删除
 * <p>
 * 失败 Page.PAGE_DIARYSHOW
 * 成功 Page.PAGE_DIARYSHOW
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface DiaryDeleteService extends Service {
    void deleteDiary(int diaryId);
}
