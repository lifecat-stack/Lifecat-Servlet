package com.wang.dao;

import com.wang.bean.Image;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @name ImageDAO
 * @description upimage数据库操作
 * @auther ten
 */
public class ImageDAO extends BaseDAO implements DAO {

    private static final String imagename = "imagename";
    private static final String imagedescription = "imagedescription";
    private static final String imagedate = "imagedate";
    private static final String imagepath = "imagepath";
    private static final String table = "upimage";

    /* 上传form内容到数据库 */
    public boolean uploadImage(Image image) {
        Object[] attributes = new Object[5];
        attributes[0] = image.getId();
        attributes[1] = image.getImagename();
        attributes[2] = image.getImagedescription();
        attributes[3] = image.getImagedate();
        attributes[4] = image.getImagepath();
        return this.exeInsert(table, attributes);
    }

    /* 根据用户ID获取image数据集 */
    public ArrayList getImageList(int id) {
        ArrayList<Image> images = new ArrayList<>();
        ResultSet resultSet = exeSelect("*", table, id);
        System.out.println("image成功获取到resultset");
        try {
            while (resultSet.next()) {
                Image image = new Image();
                image.setImagename(resultSet.getString(imagename));
                image.setImagedescription(resultSet.getString(imagedescription));
                image.setImagedate(resultSet.getString(imagedate));
                image.setImagepath(resultSet.getString(imagepath));
                images.add(image);
            }
        } catch (SQLException e) {
            System.out.println("读取image的时候出错");
            e.printStackTrace();
        }
        return images;
    }

}
