package com.wang.domodel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @name LoginModel
 * @description 验证登录 对应表单LoginForm
 * @auther ten
 */
class LoginModel implements MyModel {
    private LoginModel() {
    }


    public static MyModel getModel() {
        return new LoginModel();
    }


    /**
     * @name excute
     * @description 登录操作
     */
    @Override
    public ModelResult execute(HttpServletRequest req, HttpServletResponse resp) {

        /* 获取表单的提交数据 */
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("PASSWORD");

        System.out.println("获取的username " + username);
        System.out.println("获取的password " + password);

        //TODO 在高层进行异常的检查，确保低层代码成功执行

        //TODO 添加异常细节，包含对异常有贡献的域和值 super()

        //TODO 努力使异常保持原子性, 若失败 不影响对象状态

        /* 根据hashcode获取用户的id */
        int userid = dao.queryId(username);

        System.out.printl n("userid : " + userid);

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
            page = page_index;
        }
        /* 密码错误 */
        else if (!bean.getPassword().equals(password)) {
            errorMsg.setError("密码错误");
            page = page_index;
        }
        /* username password通过验证 */
        else {
            /* 转发到userhome.jsp */
            page = page_userhome;
            req.getSession().setAttribute("User", bean);
            success = true;
        }
        try {
            resp.sendRedirect(page);
        } catch (IOException e) {
            e.printStackTrace();
            errorMsg.printError("登录成功 ");
        }
        return null;
    }
}

