package com.wang.service;

import com.wang.bean.User;
import com.wang.daomodel.UserDAOModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * UserServlet: user表操作
 * <p>
 * post
 * 1. 登录 login.do
 * 2. 注册 register.do
 * 3. 修改密码 uppsw.do
 *
 * @auther ten
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        System.out.println("URI:" + req.getRequestURI());
        System.out.println("URL:" + req.getRequestURL());

        UserDAOModel model;

        final boolean isLogin = action.equals("login.do");

        if () {
            String name = req.getParameter("username");
            String password = req.getParameter("password");

            User user


        } else if (action.equals("register.do")) {
            String rusername = req.getParameter("rusername");
            String rpassword1 = req.getParameter("rpassword1");
            String rpassword2 = req.getParameter("rpassword2");

        } else if (action.equals("uppsw.do")) {
            String oldpassword = req.getParameter("oldpassword");
            String newpassword1 = req.getParameter("newpassword1");
            String newpassword2 = req.getParameter("newpassword2");

        } else {

        }
    }
}
