package com.ten.service;

import com.ten.bean.entity.Image;
import com.ten.service.util.Service;

import java.util.List;

/**
 * 图片分类查询
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageClassQueryService extends Service {
    List<Image> queryImageByClass(int userId, int classId);
}
