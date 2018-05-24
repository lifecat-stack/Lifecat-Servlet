package com.wang.service.serviceimpl;

import com.wang.service.service.Service;
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
public class ImageClassQuery implements Service {
     private Logger logger = LoggerFactory.getLogger(ImageClassQuery.class);

    private ImageClassQuery() {
    }

    static Service newService() {
        return new ImageClassQuery();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {



        return null;
    }
}
