package com.wang.openfunc.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AndroidUpImageServletImpl:
 * <p>
 * function:
 * Android端通过POST二进制方式传输Image数据
 * 将Image写入文件服务器, 将path写入数据库
 * argument:
 * Form表单: username password imageByteIO
 * <p>
 * TODO:
 *
 * @auther ten
 */
public class AndroidUpImageServletImpl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}
