package com.ten.service;

import com.ten.bean.entity.Image;
import com.ten.service.util.Service;

/**
 * 图片单个查询
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageQueryService extends Service {

    Image queryImage(String imageName);
}
