package com.wang.service.service;

import com.wang.bean.doo.ImageDO;
import com.wang.service.Service;

import java.util.List;

/**
 * 图片集合获取
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_IMAGESHOW
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageListQueryService extends Service {
    List<ImageDO> queryImageListByUserId(int userId);
}
