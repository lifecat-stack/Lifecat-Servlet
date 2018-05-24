package com.wang.service.serviceimpl;

import com.wang.service.service.Service;
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
public class ImageDelete implements Service {
     private Logger logger = LoggerFactory.getLogger(ImageDelete.class);

    private ImageDelete() {
    }

    static Service newService() {
        return new ImageDelete();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO
        return null;
    }
}
