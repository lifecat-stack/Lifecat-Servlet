package com.wang.service;

import com.wang.db.HOST;
import com.wang.form.FormResult;
import com.wang.model.ModelSelector;
import com.wang.model.MyModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @name ActionServlet
 * @description 控制器:处理业务逻辑,调用模型model
 * @auther ten
 */
public class ActionServlet extends HttpServlet implements HOST {
    private static int flag=0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service 接收到请求");
        /* 检查过滤器是否为空 */
        if (req.getAttribute("result")!=null) {

            /* 验证filter是否检查出错误 */
            FormResult result = (FormResult) req.getAttribute("result");

            /* 若有错误，转发到请求页面page */
            if (result.getIsError()) {
                String page = req.getRequestURI();
                page=host_index;

                //测试request.getRequestURI()能否重定向回请求界面
                System.out.println("测试:请求URI为-->" + page);

                req.getSession().setAttribute("errormsg", result.getErrorMsg());
                resp.sendRedirect(page);
            }

            /* Form通过 */
            /* 调用模型进行DAO处理  */
            else {
                /* 提取请求信息 */
                String action_type = (String) req.getParameter("action");

                /* 转发到Model,获取对应Model对象 */
                MyModel model = ModelSelector.select(action_type);

                try {
                    /* 转发行为在model中实现 */
                    model.execute(req, resp);
                } catch (Exception e) {
                    /* 若Model未发生转发:异常情况 */
                    System.out.println("model未执行转发 : ");
                    e.printStackTrace();
                    String page = req.getRequestURI();
                    req.getRequestDispatcher(page).forward(req, resp);
                }
            }
        }else {
            System.out.println("post 请求为 null");
            if (flag==0) {
                resp.sendRedirect(host_index);
                flag++;
            }
        }
    }
}
