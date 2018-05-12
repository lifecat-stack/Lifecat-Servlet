package com.wang.filter;

import com.wang.form.FormResult;
import com.wang.form.FormSelector;
import com.wang.form.MyForm;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Form Filter
 * <p>
 * 对POST请求提交的表单进行验证
 *
 * @auther ten
 */
public class FormFilter implements Filter {

    private static Logger logger = Logger.getLogger("FormFilter");

    /**
     * Form表单验证
     * <p>
     * 1. 获取action
     * 2. 获取对应form对象
     * 3. 执行validate(),获取返回结果
     * 4. 分析返回结果
     * 5. 若验证通过,执行转发到相应servlet
     *
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //1. 获取action
        String action = request.getParameter("action");
        logger.info("action:" + action);

        //检查异常
        if (chain == null) {
            throw new NullPointerException("FormFilter is null");
        }

        /*
         * action != null: url is (设置对应form项) post
         * action == null: url is get or (未设置对应form项) post
         */
        if (action != null) {
            //2. 获取对应form对象
            MyForm form = FormSelector.select(action);

            //3. 执行validate(),获取返回结果
            FormResult result = form.validate(request);

            //5. 若验证通过,执行转发到相应servlet
            if (!result.error()) {
                chain.doFilter(req, resp);
            }

            //验证未通过,将ErrorMsg发送回请求界面
            request.setAttribute("errormsg", result.getErrormsg());
            request.getRequestDispatcher(String.valueOf(request.getRequestURL())).forward(req, resp);
        }

        //action == null : do nothing
    }

    /**
     * filter.init()
     *
     * @throws ServletException filter init failure
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        logger.config("FormFilter init()");
    }

    /**
     * filter.destroy()
     */
    @Override
    public void destroy() {
        logger.config("FormFilter destroy()");
    }
}
