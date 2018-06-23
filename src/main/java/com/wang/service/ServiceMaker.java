package com.wang.service;

import com.wang.service.serviceimpl.ServiceResult;

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
