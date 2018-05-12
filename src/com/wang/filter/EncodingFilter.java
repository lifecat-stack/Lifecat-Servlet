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
 * Filter:Encoding
 * <p>
 * 编码为utf-8
 *
 * @auther ten
 */
public class EncodingFilter implements Filter {

    private static Logger logger = Logger.getLogger("EncodingFilter");

    /**
     * doFilter
     *
     * @throws IOException      IO failure
     * @throws ServletException servlet failure
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        logger.info("EncodingFilter doFilter()");

        //检查异常
        if (chain == null) {
            throw new NullPointerException("EncodingFilter is null");
        }

        request.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }

    /**
     * filter.init()
     *
     * @throws ServletException filter init failure
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        logger.config("EncodingFilter init()");
    }

    /**
     * filter.destroy()
     */
    @Override
    public void destroy() {
        logger.config("EncodingFilter destroy()");
    }
}