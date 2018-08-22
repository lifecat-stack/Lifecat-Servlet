package com.ten.service.impl;

import com.ten.bean.entity.ImageDO;
import com.ten.service.ImageQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 图片单个查询
 *
 * @date 2018/5/24
 * @auther ten
 */
public class ImageQueryServiceImpl implements ImageQueryService {
    private Logger logger = LoggerFactory.getLogger(ImageQueryServiceImpl.class);

    public ImageQueryServiceImpl() {
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    @Override
    public ImageDO queryImage(String imageName) {
        return null;
    }
}
