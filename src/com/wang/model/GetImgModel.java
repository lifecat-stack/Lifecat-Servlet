package com.wang.model;

import com.wang.bean.Image;
import com.wang.dao.ImageDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * @name GetImgModel
 * @description 获取图片列表
 * @auther ten
 */
public class GetImgModel extends MyModel {
    private ImageDAO dao;
    private ArrayList<Image> images;

    /* 初始化 */
    public GetImgModel() {
        dao = new ImageDAO();
        images = new ArrayList<>();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
    }

    /* 获取用户日记列表 */
    public ArrayList<Image> getImages(int id) {
        images = dao.getImageList(id);
        return images;
    }
}
