package com.ten.dao;

import com.ten.bean.entity.ImageDO;

import java.sql.SQLException;
import java.util.List;

/**
 * dao - image
 *
 * @auther ten
 */
public interface ImageDAO {
    /**
     * 图片上传 :
     * 插入ImageDO到image表
     * 返回自增长主键image_id
     *
     * @param imageDO imageDO
     * @return image_id
     * @throws SQLException e
     */
    int insertImage(ImageDO imageDO) throws SQLException;

    /**
     * 图片删除 :
     * 通过Image_id删除image
     *
     * @param imageId imageId
     * @throws SQLException e
     */
    void deleteImage(int imageId) throws SQLException;

    /**
     * 图片内容更新 :
     * 通过Image_id更新image信息
     *
     * @param imageId imageId
     * @param newText newText
     * @throws SQLException e
     */
    void updateImageText(int imageId, String newText) throws SQLException;

    /**
     * 图片单个查询 :
     * 通过image_id(uk)进行查询
     * 获取数据库image信息
     * image信息封装在ImageDO中返回
     *
     * @param imageId 图片ID
     * @return ImageDO ImageDO
     * @throws SQLException         e
     * @throws NullPointerException 记录不存在
     */
    ImageDO queryImage(int imageId) throws SQLException;

    /**
     * 图片全部查询 :
     * 通过user_id进行查询
     * 获取数据库imagelist信息
     * imagelist信息封装在{@literal List<ImageDO>}中返回
     *
     * @param userId 用户ID
     * @return {@literal List<ImageDO> List}
     * @throws SQLException         e
     * @throws NullPointerException 记录不存在
     */
    List<ImageDO> queryImageList(int userId) throws SQLException;

    /**
     * 图片分类查询 :
     * 通过user_id和class_id进行查询
     * 获取数据库imagelist信息
     * imagelist信息封装在{@literal List<ImageDO>}中返回
     *
     * @param userId  用户ID
     * @param classId 图片类别ID
     * @return {@literal List<ImageDO> List}
     * @throws SQLException         e
     * @throws NullPointerException 记录不存在
     */
    List<ImageDO> queryImageClass(int userId, int classId) throws SQLException;
}
