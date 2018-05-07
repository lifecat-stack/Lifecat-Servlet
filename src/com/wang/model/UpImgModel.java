package com.wang.model;

import com.wang.bean.Image;
import com.wang.dao.ImageDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    }
}
