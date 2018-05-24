package com.wang.service.serviceimpl;

import com.wang.service.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 图片分类
 *
 * @date 2018/5/24
 * @auther ten
 */
 class ImageClassify implements Service {
     private Logger logger = LoggerFactory.getLogger(ImageClassify.class);

    private ImageClassify() {
    }

    static Service newService() {
        return new ImageClassify();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO
        return null;
    }
}
