package com.wang.dao.dao;

import com.wang.doo.ImageTypeDO;

import java.sql.SQLException;
import java.util.List;

/**
 * dao - image type
 *
 * @auther ten
 */
public interface ImageTypeDAO {
    /**
     * 图片上传 :
     * 上传图片类别信息
     * 插入ImageTypeDO到Image_type
     *
     * @param imageTypeDO imageTypeDO
     * @throws SQLException e
     */
    void insertImageType(ImageTypeDO imageTypeDO) throws SQLException;

    /**
     * 图片分类查询 :
     * 根据User_id以及class_id
     * 获取此分类的所有图片id
     *
     * @param userId  userId
     * @param classId classId
     * @throws SQLException         e
     * @throws NullPointerException 记录不存在
     */
    List<Integer> queryImageType(int userId, int classId) throws SQLException;

    /**
     * 图片类别更新 :
     * 根据Image_id修改其分类数据
     *
     * @param imageId imageId
     * @param classId classId
     * @throws SQLException e
     */
    void updateImageType(int imageId, int classId) throws SQLException;
}
