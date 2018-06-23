package com.wang.service.serviceimpl;

import com.wang.service.Service;
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
 class ImageDeleteServiceImpl implements ImageDeleteService {
     private Logger logger = LoggerFactory.getLogger(ImageDeleteServiceImpl.class);

    private ImageDeleteServiceImpl() {
    }

    static Service newService() {
        return new ImageDeleteServiceImpl();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO
        return null;
    }
}
