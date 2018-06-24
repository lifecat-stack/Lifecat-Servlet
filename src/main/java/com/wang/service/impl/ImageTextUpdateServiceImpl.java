package com.wang.service.impl;

import com.wang.service.util.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 更新图片信息
 *
 * @date 2018/5/24
 * @auther ten
 */
 class ImageTextUpdateServiceImpl implements ImageTextUpdateService {
     private Logger logger = LoggerFactory.getLogger(ImageTextUpdateServiceImpl.class);

    private ImageTextUpdateServiceImpl() {
    }

    static Service newService() {
        return new ImageTextUpdateServiceImpl();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO
        return null;
    }
}
