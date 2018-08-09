package com.ten.controller;

import com.meterware.httpunit.WebResponse;
import org.apache.cactus.ServletTestCase;
import org.apache.cactus.WebRequest;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * ActionServlet Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 18, 2018</pre>
 */
public class ActionServletTest extends ServletTestCase {

    private ActionServlet actionServlet;
   /*
     * 由begin开始的方法,都被视为客户端方法,这里的操作 都应该是从
     * 客户端发出的,例如客户端传递给服务端的参数就应该从begin方法
     * 中传入,参数WebRequest为生成request而需要
     */
    public void beginLogin(WebRequest request) {
        // 通过request.addParameter()来添加parameter
        request.addParameter("username", "Ray");
    }

    /*
     * 初始化对象
     */
    public void setUp() {
        actionServlet = new ActionServlet();
    }

    /*
     * 测试doGet方法
     */
    public void testDoGet() throws ServletException, IOException {
        // 注意,此时request和response为ServletTestCase的属性
        actionServlet.doGet(super.request, super.response);
    }

    /*
     * 由end开始的方法,都被视为服务器响应方法,这里操作
     * 的应该是验证服务器传回来的结果,例如返回的JSP是否正确
     * ,参数WebResponse为验证提供了大量的方法,例如getTable
     */
    public void endDoGet(WebResponse response) throws SAXException {
        //返回已编译后的html页面的title
        assertEquals("test", response.getTitle());
        //返回整个html的document
        assertEquals("test", response.getDOM().getElementById("Ray").getNodeValue());
        //返回指定名称的元素
        assertEquals(3, response.getElementsByTagName("input").length);
    }
}


