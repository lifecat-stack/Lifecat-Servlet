package com.ten.lifecat.servlet.service;

import com.ten.lifecat.servlet.entity.Diary;
import com.ten.lifecat.servlet.service.util.Service;
import com.ten.service.util.Service;

/**
 * 日记上传
 * <p>
 * 失败 Page.PAGE_UPDIARY
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface DiaryUploadService extends Service {

    void uploadDiary(Diary diary);
}
