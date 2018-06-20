package com.wang.service.serviceimpl;

import com.wang.service.Service;
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
 class ImageTextUpdate implements Service {
     private Logger logger = LoggerFactory.getLogger(ImageTextUpdate.class);

    private ImageTextUpdate() {
    }

    static Service newService() {
        return new ImageTextUpdate();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO
        return null;
    }
}
