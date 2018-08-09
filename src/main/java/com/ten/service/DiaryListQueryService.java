package com.ten.service;

import com.ten.bean.entity.DiaryDO;
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
    List<DiaryDO> queryDiaryListByUserId(int userId);
}
