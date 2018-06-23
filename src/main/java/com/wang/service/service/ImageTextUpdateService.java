package com.wang.service.service;

import com.wang.bean.doo.ImageDO;
import com.wang.service.Service;
import com.wang.service.ServiceMaker;

/**
 * 更新图片信息
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageTextUpdateService extends Service, ServiceMaker {
    void updateImageText(ImageDO imageDO);
}
