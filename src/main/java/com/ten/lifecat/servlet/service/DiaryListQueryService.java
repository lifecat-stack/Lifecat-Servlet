package com.ten.lifecat.servlet.service;

import com.ten.lifecat.servlet.entity.Diary;
import com.ten.lifecat.servlet.service.util.Service;
import com.ten.service.util.Service;

import java.util.List;

/**
 * 日记数据集获取
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_DIARYSHOW
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface DiaryListQueryService extends Service {

    List<Diary> queryDiaryListByUserId(int userId);
}
