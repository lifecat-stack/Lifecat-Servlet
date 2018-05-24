//package com.wang.openfunc;
//
//import com.wang.bean.Image;
//import com.wang.bean.User;
//import com.wang.manager.ManagerFactory;
//import com.wang.manager.ImageManager;
//import com.wang.constant.HOST;
//import com.wang.util.ImageWriter;
//import com.wang.util.MyDate;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.sql.SQLException;
//
///**
// * AndroidUpImage:
// * <p>
// * function:
// * Android端通过POST二进制方式传输Image数据
// * 将Image写入文件服务器, 将path写入数据库
// * argument:
// * Form表单: username password imageByteIO
// * <p>
// * TODO:
// *
// * @auther ten
// */
//public class AndroidUpImage extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
//
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        User user = new User.Builder(username, password).build();
//
//        //tomcat/webapps/image/userid/image/
//        String directory_path = HOST.IMAGE_PATH + user.getId() + "/image/";
//
//        //检查目录是否存在
//        File directory = new File(directory_path);
//        if (!directory.exists()) {
//            directory.mkdir();
//        }
//
//        //设置图片信息
//        String image_date = MyDate.getInstance().getCurrentTime();
//        String image_name = MyDate.getInstance().getCurrentTime() + ".jpg";
//        String image_path = directory_path + image_name;
//        ImageWriter writer = ImageWriter.newImageWriter(image_path);
//
//        //1. 将图片写入服务器
//        try {
//            writer.writeImage(req.getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //设置Image对象
//        Image image = new Image.Builder(image_path).image_date(image_date).image_name(image_name).image_type("image").build();
//        ImageManager daoModel = (ImageManager) ManagerFactory.getManagerByName(user.getId(), "ImageManager");
//
//        //2. 将路径写入数据库
//        try {
//            daoModel.insertImage(image);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
