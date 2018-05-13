package com.wang.domodel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MyModel: Model接口
 *
 * @auther ten
 */
public interface MyModel {

    /**
     * Model执行
     *
     * @param req  request
     * @param resp response
     * @return FormResult
     */
    ModelResult execute(HttpServletRequest req, HttpServletResponse resp);
}
