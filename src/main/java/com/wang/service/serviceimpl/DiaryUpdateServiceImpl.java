package com.wang.service.serviceimpl;

import com.wang.service.Service;
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
 class DiaryUpdateServiceImpl implements DiaryUpdateService {
     private Logger logger = LoggerFactory.getLogger(DiaryUpdateServiceImpl.class);

    private DiaryUpdateServiceImpl() {
    }

    static Service newService() {
        return new DiaryUpdateServiceImpl();
    }
    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO
        return null;
    }
}
