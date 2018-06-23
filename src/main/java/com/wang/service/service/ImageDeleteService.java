package com.wang.service.service;

import com.wang.service.Service;

/**
 * 图片删除
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageDeleteService extends Service {
    void deleteImageById(int imageId);
}
