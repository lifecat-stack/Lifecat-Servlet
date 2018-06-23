package com.wang.service.service;

import com.wang.service.Service;

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
    // TODO
    void deleteDiary();
}
