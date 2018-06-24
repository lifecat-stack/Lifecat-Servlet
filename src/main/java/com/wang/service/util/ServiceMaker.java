package com.wang.service.util;

import com.wang.service.impl.ServiceResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 允许通过static newService()获取Service实例
 *
 * @date 2018/6/23
 * @auther ten
 */
public interface ServiceMaker {
    public static Service newService() {
        return new Service() {
            @Override
            public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
                return null;
            }
        };
    }
}
