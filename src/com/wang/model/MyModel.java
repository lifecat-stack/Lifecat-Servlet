package com.wang.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Model接口
 *
 * @auther ten
 */
public interface MyModel {

    static MyModel getModel() {
        return null;
    }

    /**
     * Model执行
     *
     * @param req  request
     * @param resp response
     * @return FormResult
     */
    ModelResult execute(HttpServletRequest req, HttpServletResponse resp);
}
