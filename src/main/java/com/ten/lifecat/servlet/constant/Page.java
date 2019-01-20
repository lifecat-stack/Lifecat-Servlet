package com.ten.lifecat.servlet.constant;

/**
 * 页面服务器URL
 */
public class Page {

    private Page() {
        throw new AssertionError();
    }


    /**
     * http:xxx.xxx.xxx.xxx:8080/servlet/index.jsp
     */
    public static final String PAGE_INDEX = "/index.jsp";
    public static final String WELCOME = "/servlet" + PAGE_INDEX;
    /**
     * http:xxx.xxx.xxx.xxx:8080/servlet/userhome.jsp
     */
    public static final String PAGE_USERHOME = "/WEB-INF/jsp/" + "userhome.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/servlet/upimage.jsp
     */
    public static final String PAGE_UPIMAGE = "/WEB-INF/jsp/" + "upimage.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/servlet/updiary.html
     */
    public static final String PAGE_UPDIARY = "/WEB-INF/jsp/" + "updiary.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/servlet/imageshow.jsp
     */
    public static final String PAGE_IMAGESHOW = "/WEB-INF/jsp/" + "imageshow.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/servlet/imageshow2.jsp
     */
    public static final String PAGE_IMAGESHOW2 = "/WEB-INF/jsp/" + "imageshow2.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/servlet/imageshow2.jsp
     */
    public static final String PAGE_DIARYSHOW = "/WEB-INF/jsp/" + "diaryshow.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/servlet/error.jsp
     */
    public static final String PAGE_ERROR = "/WEB-INF/jsp/" + "error.jsp";
}
