package com.ten.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Action转发
 * <p>
 * 根据*.action的get请求
 * 通过请求服务端转发
 * 访问WEB-INF下的jsp页面
 *
 * @date 2018/6/18
 * @auther ten
 */
public class DispatcherAction extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherAction.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取要访问的jsp页面名
        String uri = req.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));

        String url;
        // 生成WEB-INF路径
        if (uri.contains("tap")) {
            url = "/WEB-INF/jsp/mainPage/" + action + ".jsp";
        } else {
            url = "/WEB-INF/jsp/" + action + ".jsp";
        }

        // 执行转发
        req.getRequestDispatcher(url).forward(req, resp);
    }
}
