package com.wang.model;

import com.wang.bean.User;
import com.wang.bean.UserMsg;
import com.wang.dao.DAO;
import com.wang.dao.UserMsgDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * @name SetMsgModel
 * @description 设置个人信息，对应表单SetMsg，对应页面userhome.jsp
 * @auther ten
 */
public class SetMsgModel extends MyModel {
    private UserMsgDAO dao;
    private UserMsg bean;

    /* 初始化 */
    public SetMsgModel() {
        dao = new UserMsgDAO();
        bean = new UserMsg();
        errorMsg = new ErrorMsg();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        /* 获取表单的提交数据 */
        String nickname = (String) req.getParameter("nickname");
        String sex = (String) req.getParameter("sex");
        String age = (String) req.getParameter("age");
        String birthday = (String) req.getParameter("birthday");
        String email = (String) req.getParameter("email");

        /* 获取session中的user对象 */
        User user = (User) req.getSession().getAttribute("User");

        /* 获取用户id */
        int userid=0;
        if (user!=null) {
            userid = user.getId();
        }

        /* 设置一个新的数据库Bean对象 */
        bean.setId(userid);
        bean.setNickname(nickname);
        bean.setSex(sex);
        bean.setAge(age);
        bean.setBirthday(birthday);
        bean.setEmail(email);

        String page = host_userhome;

        boolean success = dao.insertUser(bean);

        /* 若设置成功 */
        if (success) {
            System.out.println("设置个人信息成功");
            req.getSession().setAttribute("UserMsg", bean);
        }
        /* 设置失败 */
        else {
            System.out.println("设置失败");
        }
        try {
            resp.sendRedirect(page);
        } catch (IOException e) {
            System.out.println("设置信息后跳转失败");
            e.printStackTrace();
        }
    }
}
