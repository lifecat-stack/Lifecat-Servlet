package com.wang.constant;

/**
 * 页面服务器URL
 *
 * @date 2018/5/24
 * @auther ten
 */
public class Page {
    private Page() {
        throw new AssertionError();
    }

    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/index.jsp
     */
    public static final String PAGE_INDEX = HOST.PROJECT_CONTEXT + "index.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/userhome.jsp
     */
    public static final String PAGE_USERHOME = "/WEB-INF/jsp/" + "userhome.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/upimage.jsp
     */
    public static final String PAGE_UPIMAGE = HOST.PROJECT_CONTEXT + "upimage.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/updiary.jsp
     */
    public static final String PAGE_UPDIARY = HOST.PROJECT_CONTEXT + "updiary.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/imageshow.jsp
     */
    public static final String PAGE_IMAGESHOW = HOST.PROJECT_CONTEXT + "imageshow.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/imageshow2.jsp
     */
    public static final String PAGE_IMAGESHOW2 = HOST.PROJECT_CONTEXT + "imageshow2.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/imageshow2.jsp
     */
    public static final String PAGE_DIARYSHOW = HOST.PROJECT_CONTEXT + "diaryshow.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/error.jsp
     */
    public static final String PAGE_ERROR = HOST.PROJECT_CONTEXT + "jsp/" + "error.jsp";
}
