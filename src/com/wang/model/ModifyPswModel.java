package com.wang.model;

import com.wang.bean.User;
import com.wang.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * @name ModifyPswModel
 * @description 修改密码，对应表单ModifyPsw，对应页面userhome.jsp，对应bean是user
 * @auther
 */
public class ModifyPswModel extends MyModel {
    private UserDAO dao;
    private User bean;

    /* 初始化 */
    public ModifyPswModel() {
        dao = new UserDAO();
        bean = new User();
        errorMsg = new ErrorMsg();
    }

    /**
     * @name
     * @description 两次密码不同的情况已经由Form处理，保证model中两次密码相同且不为空
     */
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        /* 获取表单的提交数据 */
        String oldpassword = (String) req.getParameter("oldpassword");
        String newpassword1 = (String) req.getParameter("newpassword1");
        String newpassword2 = (String) req.getParameter("newpassword2");

        /* 获取session中的user对象 */
        bean = (User) req.getSession().getAttribute("User");

        /* 获取用户id */
        int userid=0;
        if (bean!=null) {
            userid = bean.getId();
        }

        String page = host_userhome;

        /* 获取数据库中对应的bean */
        String db_password = dao.queryPassword(userid);

        /* 原密码错误 */
        if (!db_password.equals(oldpassword)) {
            errorMsg.setError("原密码错误");
        } else {
            /* 更新密码 */
            dao.updatePassword(newpassword1, userid);
            /* 获取新的User bean */
            bean = dao.queryUser(userid);
            /* 设置好user */
            req.getSession().setAttribute("User", bean);
        }
        try {
            resp.sendRedirect(page);
        } catch (IOException e) {
            e.printStackTrace();
            errorMsg.printError("修改密码 ");
        }
    }
}
