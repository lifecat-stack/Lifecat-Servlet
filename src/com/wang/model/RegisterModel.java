package com.wang.model;

import com.wang.bean.User;
import com.wang.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * @name RegisterModel
 * @description 注册，对应表单Register，对应页面index.jsp->userhome.jsp
 * @auther
 */
public class RegisterModel extends MyModel {
    private UserDAO dao;
    private User bean;

    /* 初始化 */
    public RegisterModel() {
        dao = new UserDAO();
        bean = new User();
        errorMsg = new ErrorMsg();
    }

    /**
     * @name
     * @description Form保证用户名和密码不为空 且 两次密码相同
     */
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        /* 获取表单的提交数据 */
        String rusername = (String) req.getParameter("rusername");
        String rpassword1 = (String) req.getParameter("rpassword1");
        String rpassword2 = (String) req.getParameter("rpassword2");

        /* 根据hashcode获取用户的id */
        int userid = dao.queryId(rusername);

        /* 设置一个新的数据库Bean对象 */
        bean.setId(userid);
        bean.setName(rusername);
        bean.setPassword(rpassword1);
        bean.setLevel("user");

        /* 重定向页面 */
        String page = null;

        boolean success = dao.insertUser(bean);


        /* 若创建成功 */
        if (success) {
            System.out.println("注册成功");
            page = host_userhome;
            req.getSession().setAttribute("User", bean);

        }
        /* 注册失败 */
        else {
            System.out.println("注册失败");
            page = host_index;
        }
        try {
            resp.sendRedirect(page);
        } catch (IOException e) {
            e.printStackTrace();
            errorMsg.printError("注册成功，跳转到userhome ");
        }
    }
}