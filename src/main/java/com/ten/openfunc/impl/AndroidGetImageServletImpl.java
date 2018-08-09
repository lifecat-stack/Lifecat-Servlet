package com.ten.openfunc.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AndroidGetImageServletImpl:
 * <p>
 * function:
 * Android端发送GET请求, 根据?userid=获取用户所有Image信息, 并将信息发送给Android端
 * <p>
 * TODO: GET方式?userid= to POST方式User对象
 *
 * @auther ten
 */
public class AndroidGetImageServletImpl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
