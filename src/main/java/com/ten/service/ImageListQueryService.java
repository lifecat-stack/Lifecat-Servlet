package com.ten.service;

import com.ten.bean.entity.Image;
import com.ten.service.util.Service;

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
    List<Image> queryImageListByUserId(int userId);
}
