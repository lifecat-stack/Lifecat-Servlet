package com.ten.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * filter - Encoding
 * <p>
 * 设置编码为utf-8
 *
 * @auther ten
 */
public class EncodingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(EncodingFilter.class);

    /**
     * doFilter
     *
     * @throws IOException          IO failure
     * @throws ServletException     servlet failure
     * @throws NullPointerException 过滤器链异常
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        // 检查NPE
        if (chain == null) {
            throw new NullPointerException("EncodingFilter is null");
        }

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        logger.info("EncodingFilter doFilter()");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

    /**
     * init()
     *
     * @throws ServletException filter init failure
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        logger.info("EncodingFilter init()");
    }

    /**
     * destroy()
     */
    @Override
    public void destroy() {
        logger.info("EncodingFilter destroy()");
    }
}