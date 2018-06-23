package com.wang.service.serviceimpl;

import com.wang.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 图片分类查询
 *
 * @date 2018/5/24
 * @auther ten
 */
class ImageClassQueryServiceImpl implements ImageClassQueryService {
    private Logger logger = LoggerFactory.getLogger(ImageClassQueryServiceImpl.class);

    private ImageClassQueryServiceImpl() {
    }

    static Service newService() {
        return new ImageClassQueryServiceImpl();
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
}
