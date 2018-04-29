package com.wang.model;

import com.wang.bean.Image;
import com.wang.bean.User;
import com.wang.dao.ImageDAO;
import com.wang.db.MyDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @name UpImgModel
 * @description 上传图片，对应表单UpImg，对应页面uploadimage.jsp
 * @auther ten
 */
public class UpImgModel extends MyModel {
    private ImageDAO dao;
    private Image bean;

    /* 初始化 */
    public UpImgModel() {
        dao = new ImageDAO();
        bean = new Image();
        errorMsg = new ErrorMsg();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        /* 获取表单的提交数据 */
        String imagename = (String) req.getParameter("imagename");
        String imagedescription = (String) req.getParameter("imagedescription");

        String imagedate = MyDate.GetNowDate();
        String imagepath = "http://"+ip+":8080/lifecatweb/upimage";

        /* 获取session中的user对象 */
        User user = (User) req.getSession().getAttribute("User");
        /* 获取用户id */
        int userid=0;
        if (user!=null) {
            userid = user.getId();
        }

        bean.setId(userid);
        bean.setImagename(imagename);
        bean.setImagedescription(imagedescription);
        bean.setImagedate(imagedate);
        bean.setImagepath(imagepath);

        String page = host_userhome;

        boolean success = dao.uploadImage(bean);

        /* 若设置成功 */
        if (success) {
            System.out.println("上传图片成功");
        }
        /* 设置失败 */
        else {
            System.out.println("上传图片失败");
        }
        try {
            resp.sendRedirect(page);
        } catch (IOException e) {
            System.out.println("上传图片后跳转失败");
            e.printStackTrace();
        }
    }
}
