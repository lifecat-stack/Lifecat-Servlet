package com.ten.service.impl;

import com.ten.service.ImageClassifyService;
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
public class ImageClassifyServiceImpl implements ImageClassifyService {
    private Logger logger = LoggerFactory.getLogger(ImageClassifyServiceImpl.class);

    public ImageClassifyServiceImpl() {
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
