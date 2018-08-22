package com.ten.constant;

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
    public static final String PAGE_INDEX = "/index.jsp";
    public static final String WELCOME = "/lifecatweb" + PAGE_INDEX;
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/userhome.jsp
     */
    public static final String PAGE_USERHOME = "/WEB-INF/jsp/" + "userhome.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/upimage.jsp
     */
    public static final String PAGE_UPIMAGE = "/WEB-INF/jsp/" + "upimage.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/updiary.html
     */
    public static final String PAGE_UPDIARY = "/WEB-INF/jsp/" + "updiary.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/imageshow.jsp
     */
    public static final String PAGE_IMAGESHOW = "/WEB-INF/jsp/" + "imageshow.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/imageshow2.jsp
     */
    public static final String PAGE_IMAGESHOW2 = "/WEB-INF/jsp/" + "imageshow2.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/imageshow2.jsp
     */
    public static final String PAGE_DIARYSHOW = "/WEB-INF/jsp/" + "diaryshow.jsp";
    /**
     * http:xxx.xxx.xxx.xxx:8080/lifecatweb/error.jsp
     */
    public static final String PAGE_ERROR = "/WEB-INF/jsp/" + "error.jsp";
}
