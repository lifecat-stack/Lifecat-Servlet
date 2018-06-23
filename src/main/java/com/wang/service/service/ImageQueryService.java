package com.wang.service.service;

import com.wang.bean.doo.ImageDO;
import com.wang.service.Service;

/**
 * 图片单个查询
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageQueryService extends Service {
    ImageDO queryImage(String imageName);
}
