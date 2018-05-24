package com.wang.service.serviceimpl;

import com.wang.service.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 日记内容更新
 *
 * @date 2018/5/24
 * @auther ten
 */
 class DiaryUpdate implements Service {
     private Logger logger = LoggerFactory.getLogger(DiaryUpdate.class);

    private DiaryUpdate() {
    }

    static Service newService() {
        return new DiaryUpdate();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO
        return null;
    }
}
