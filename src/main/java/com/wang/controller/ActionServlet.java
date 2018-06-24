package com.wang.controller;

import com.wang.constant.Page;
import com.wang.filter.form.FormResult;
import com.wang.service.util.Service;
import com.wang.service.impl.ServiceFactory;
import com.wang.service.impl.ServiceResult;
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
    private static Logger logger = LoggerFactory.getLogger(ActionServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求URL /lifecatweb/index.jsp/user_login.do
        String path = req.getRequestURI();

        FormResult formResult = (FormResult) req.getAttribute("formResult");

        // 验证未通过 转发回请求界面
        if (formResult != null && !formResult.isSuccess()) {
            logger.warn("Form Filter Failure");

            // 获取请求界面信息
            String jspUrl = path.substring(11, path.lastIndexOf("/"));

            logger.debug(formResult.getErrormsg());

            dispatcher(jspUrl, req, resp);
        }
        // 验证通过
        else {
            logger.info("Form Filter Success");

            // 提取url请求信息 /xxx
            String url = path.substring(path.lastIndexOf("/"), path.lastIndexOf("."));

            logger.debug("request url is :{}", url);

            // 根据请求信息 调用相应的service
            Service service = ServiceFactory.getServiceByUrl(url);

            // 需转发界面
            String page;

            // service无对应请求 进入错误界面 error.jsp
            if (service == null) {
                logger.info("service is null");
                page = Page.PAGE_ERROR;
                req.setAttribute("errorMsg", "没有此请求");
                req.getRequestDispatcher(page).forward(req, resp);
            }

            // service执行操作 返回Result结果
            assert service != null;
            ServiceResult result = service.execute(req, resp);

            // Result 跳转到响应界面
            logger.info("service execute {}", result.isSuccess());
            req.setAttribute("errorMsg", result.getErrormsg());

            page = result.getPage();

            dispatcher(page, req, resp);
        }
    }

    /**
     * 执行转发
     *
     * @param url 请求的页面链接
     * @throws ServletException 转发时异常
     */
    private void dispatcher(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("dispatcher url: {}" , url);
        // webapp目录下 执行客户端转发
        if ("/index.jsp".equals(url)) {
            url = "http://localhost:8080/lifecatweb/index.jsp";
            resp.sendRedirect(url);
        }
        // WEB-INF目录下 执行服务器转发
        else {
            req.getRequestDispatcher(url).forward(req, resp);
        }
    }
}

