package com.ten.service.util;

import com.ten.service.impl.ServiceResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Service :执行具体业务逻辑操作
 * <p>
 * MVC-模型层: 处理抽象业务逻辑， 具体的业务逻辑服务层
 * 对request对象进行处理, 转化为DO对象, 将DO对象交给DAOManager
 * 调用DAOManager对逻辑处理进行下沉, 对DO对象执行DAO的逻辑处理
 *
 * @auther ten
 */
public interface Service {

    /**
     * 业务逻辑处理
     *
     * @param req  request 请求
     * @param resp response 响应
     * @return ServiceResult 执行结果
     */
    ServiceResult execute(HttpServletRequest req, HttpServletResponse resp);
}
