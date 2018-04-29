package com.wang.model;

import com.wang.bean.Bean;
import com.wang.dao.DAO;
import com.wang.db.HOST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @name MyModel
 * @description 接收req, resp对象，实现转发
 * @auther ten
 */
public abstract class MyModel implements HOST {
    /**
     * 数据库操作:dao
     * Bean实体:bean
     * 错误信息:errorMsg
     */
//    DAO dao = null;
//    Bean bean = null;
    ErrorMsg errorMsg = null;

    public abstract void execute(HttpServletRequest req, HttpServletResponse resp);
}
