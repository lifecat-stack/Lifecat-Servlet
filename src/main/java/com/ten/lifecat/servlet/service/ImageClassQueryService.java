package com.ten.lifecat.servlet.service;

import com.ten.lifecat.servlet.entity.Image;
import com.ten.lifecat.servlet.service.util.Service;
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
