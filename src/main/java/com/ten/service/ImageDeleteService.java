package com.ten.service;

import com.ten.service.util.Service;

/**
 * 图片删除
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageDeleteService extends Service {
    void deleteImageById(int imageId);
}
