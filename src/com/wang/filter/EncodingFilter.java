package com.wang.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @name EncodingFilter
 * @description 字符格式统一为 UTF-8
 * @auther ten
 */
public class EncodingFilter implements Filter {

    private static Logger logger=Logger.getLogger("EncodingFilter");

    @Override
    public void destroy() {
    }

    /* 转换格式 */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        logger.info("EncodingFilter doFilter()");

        request.setCharacterEncoding("UTF-8");

        logger.info("EncodinFilter执行完毕");

        if (chain==null){
            logger.warning("encoding chain null 异常");
        }else {
             chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("EncodingFilter init()");
    }

}