package com.wang.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServiceModel: 执行具体业务逻辑操作
 * <p>
 * 访问范围: 全局
 * <p>
 * 对具体业务逻辑进行处理
 * 调用DAOModel从而对数据库进行操作
 *
 * @auther ten
 */
public interface ServiceModel {
    /**
     * 业务逻辑处理
     *
     * @param req  request 请求
     * @param resp response 请求
     * @return ModelResult 处理结果对象
     */
    public ModelResult execute(HttpServletRequest req, HttpServletResponse resp);
}
