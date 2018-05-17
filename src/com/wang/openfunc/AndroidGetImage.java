package com.wang.openfunc;

import com.wang.bean.Image;
import com.wang.manager.ManagerFactory;
import com.wang.manager.ImageManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * AndroidGetImage:
 * <p>
 * function:
 * Android端发送GET请求, 根据?userid=获取用户所有Image信息, 并将信息发送给Android端
 * <p>
 * TODO: GET方式?userid= to POST方式User对象
 *
 * @auther ten
 */
public class AndroidGetImage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();

        int userid = Integer.parseInt(uri.substring(uri.lastIndexOf("?userid=")));

        ImageManager dao = (ImageManager) ManagerFactory.getManagerByName(userid, "ImageManager");

        //获取数据库Image信息
        try {
            List<Image> images = dao.queryImages(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
