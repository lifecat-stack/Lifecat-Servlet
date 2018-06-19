package com.wang.controller;

import com.wang.constant.Page;
import com.wang.filter.form.FormResult;
import com.wang.service.service.Service;
import com.wang.service.serviceimpl.ServiceFactory;
import com.wang.service.serviceimpl.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求处理层 (Web层) :MVC-Controller
 * <p>
 * 对访问控制进行转发, 调用相应Service, 执行逻辑处理
 * 获取Service返回对象ServiceResult, 根据结果执行页面转发
 *
 * @auther ten
 */
public class ActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // slf4j日志
        Logger logger = LoggerFactory.getLogger(ActionServlet.class);

        // 获取请求界面信息
        String path = req.getRequestURI();
        String jspUrl = path.substring(12, path.lastIndexOf("/"));
        logger.info("jsp is :{}", jspUrl);

        // 验证未通过 转发回请求界面
        FormResult formResult = (FormResult) req.getAttribute("formResult");
        if (formResult != null && !formResult.isSuccess()) {
            logger.warn("Form Filter Failure");
            req.setAttribute("formResult", formResult);
            req.getRequestDispatcher(jspUrl).forward(req, resp);
        }

        logger.info("Form Filter Success");

        // 提取url请求信息 /xxx
        String url = path.substring(path.lastIndexOf("/"), path.lastIndexOf("."));
        logger.info("request url is :{}", url);

        // 根据请求信息 调用相应的service
        Service service = ServiceFactory.getServiceByUrl(url);

        // 需转发界面
        String page = jspUrl;

        // 无对应请求 进入错误界面 error.jsp
        if (service == null) {
            logger.info("service is null");
            page = Page.PAGE_ERROR;
            req.setAttribute("errorMsg", "没有此请求");
            req.getRequestDispatcher(page).forward(req, resp);
        }

        // service执行操作 返回Result结果
        assert service != null;
        ServiceResult result = service.execute(req, resp);

        // Result 执行成功 跳转到响应界面
        if (result.isSuccess()) {
            logger.info("service execute success");
            page = result.getPage();
        }
        // Result 执行错误 跳转到error.jsp
        else {
            logger.info("service execute failure");
            page = Page.PAGE_ERROR;
            req.setAttribute("errorMsg", result.getErrormsg());
        }

        logger.info("dispatcher page:" + page);
        req.getRequestDispatcher(page).forward(req, resp);
    }
}

