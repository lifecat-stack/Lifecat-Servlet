package com.ten.lifecat.servlet.service;

import com.ten.lifecat.servlet.entity.Image;
import com.ten.lifecat.servlet.service.util.Service;
import com.ten.service.util.Service;

/**
 * 更新图片信息
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageTextUpdateService extends Service {

    void updateImageText(Image image);
}
