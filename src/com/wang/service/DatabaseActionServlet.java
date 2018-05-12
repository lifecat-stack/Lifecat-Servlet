package com.wang.service;

import com.wang.model.ModelResult;
import com.wang.model.ModelSelector;
import com.wang.model.MyModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Database Servlet
 * <p>
 * 对数据库的操作
 *
 * @auther ten
 */
public class DatabaseActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    /**
     * 1. 获取action类型
     * 2. 执行model.execute()
     * 3. 获取返回结果ModelResult
     * 4. 检查异常
     * 5. 跳转
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page;

        //提取请求信息
        String action = req.getParameter("action");

        //model
        MyModel model = ModelSelector.select(action);

        ModelResult result = model.execute(req, resp);

        //error == false
        if (!result.error()) {
            page = result.getPage();
        }
        //error == true
        else {
            page = req.getRequestURI();
            req.setAttribute("errormsg", result.getErrormsg());
        }

        //执行跳转
        req.getRequestDispatcher(page).forward(req, resp);
    }
}

