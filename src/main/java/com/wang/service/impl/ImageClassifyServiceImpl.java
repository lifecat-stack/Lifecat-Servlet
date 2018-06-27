package com.wang.service.impl;

import com.wang.service.ImageClassifyService;
import com.wang.service.util.Service;
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
 class ImageClassifyServiceImpl implements ImageClassifyService {
     private Logger logger = LoggerFactory.getLogger(ImageClassifyServiceImpl.class);

    private ImageClassifyServiceImpl() {
    }

    static Service newService() {
        return new ImageClassifyServiceImpl();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO
        return null;
    }

    @Override
    public void classifyImage() {

    }
}
