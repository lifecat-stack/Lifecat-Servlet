package com.ten.lifecat.servlet.service;

import com.ten.lifecat.servlet.entity.Image;
import com.ten.lifecat.servlet.service.util.Service;

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
