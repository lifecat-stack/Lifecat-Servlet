package com.ten.service.impl;

import com.ten.service.ImageDeleteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 图片删除
 *
 * @date 2018/5/24
 * @auther ten
 */
public class ImageDeleteServiceImpl implements ImageDeleteService {
     private Logger logger = LoggerFactory.getLogger(ImageDeleteServiceImpl.class);

    public ImageDeleteServiceImpl() {
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO
        return null;
    }

    @Override
    public void deleteImageById(int imageId) {

    }
}
