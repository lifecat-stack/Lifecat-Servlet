package com.wang.service.serviceimpl;

import com.wang.service.Service;
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
class ImageQuery implements Service {
    private Logger logger = LoggerFactory.getLogger(ImageQuery.class);

    private ImageQuery() {
    }

    static Service newService() {
        return new ImageQuery();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
}
