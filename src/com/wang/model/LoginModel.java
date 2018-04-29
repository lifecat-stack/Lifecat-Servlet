package com.wang.model;

import com.wang.bean.Bean;
import com.wang.bean.User;
import com.wang.dao.BaseDAO;
import com.wang.dao.UserDAO;
import com.wang.db.HOST;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * @name LoginModel
 * @description 验证登录 对应表单LoginForm
 * @auther ten
 */
public class LoginModel extends MyModel{
    private UserDAO dao;
    private User bean;

    /* 初始化 */
    public LoginModel() {
        dao = new UserDAO();
        bean = new User();
        errorMsg = new ErrorMsg();
    }

    /**
     * @name excute
     * @description 登录操作
     */
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        /* 获取表单的提交数据 */
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");

        System.out.println("获取的username " + username);
        System.out.println("获取的password " + password);

        /* 根据hashcode获取用户的id */
        int userid = dao.queryId(username);

        System.out.println("userid : " + userid);

        /* 获取数据库中对应的bean */
        bean = dao.queryUser(userid);

        if (bean != null) {
            System.out.println("成功获取用户bean:" + bean.getName() + "," + bean.getPassword());
        } else {
            System.out.println("获取用户bean失败！！！");
        }

        /* 重定向页面 */
        String page;
        boolean success = false;

        /* 用户名不存在 */
        if (bean.getName() == null) {
            errorMsg.setError("用户名不存在");
            page = host_index;
        }
        /* 密码错误 */
        else if (!bean.getPassword().equals(password)) {
            errorMsg.setError("密码错误");
            page = host_index;
        }
        /* username password通过验证 */
        else {
            /* 转发到userhome.jsp */
            page = host_userhome;
            req.getSession().setAttribute("User", bean);
            success = true;
        }
        try {
            resp.sendRedirect(page);
        } catch (IOException e) {
            e.printStackTrace();
            errorMsg.printError("登录成功 ");
        }
    }
}

