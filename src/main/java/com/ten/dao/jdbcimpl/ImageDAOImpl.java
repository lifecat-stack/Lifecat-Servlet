package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.ImageDO;
import com.ten.dao.BaseDAO;
import com.ten.dao.ImageDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDAO -- jdbc实现类
 *
 * @auther ten
 */
public class ImageDAOImpl extends BaseDAO implements ImageDAO {

    public  ImageDAOImpl() {
    }


    @Override
    public int insertImage(ImageDO imageDO) throws SQLException {
        String sql = "INSERT INTO image(image_text, image_path, is_deleted, user_id, class_id, image_gmt_create, image_gmt_modified) " +
                "VALUES( ?,?,?,?,?,?,?)";
        Object[] args = {
                imageDO.getImageText(),
                imageDO.getImagePath(),
                imageDO.getDeleted(),
                imageDO.getUserId(),
                imageDO.getClassId(),
                imageDO.getImageGmtCreate(),
                imageDO.getImageGmtModified()
        };

        return insertAndReturnKey(sql, args);
    }

    @Override
    public void deleteImage(int imageId) throws SQLException {
        String sql = "UPDATE image set is_deleted = '0' where image_id = '" + imageId + "'";
        delete(sql);
    }

    @Override
    public void updateImageText(int imageId, String newText) throws SQLException {
        String sql = "UPDATE image set image_text = '" + newText + "' where image_id = '" + imageId + "'";
        update(sql);
    }

    @Override
    public ImageDO queryImage(int imageId) throws SQLException {
        String sql = "SELECT image_text,image_path,image_gmt_create from image where image_id = '" + imageId + "' and is_deleted = '1'";
        ResultSet rs = query(sql);
        rs.next();
        ImageDO imageDO = new ImageDO();
        imageDO.setImageId(imageId);
        imageDO.setImageText(rs.getString("image_text"));
        imageDO.setImagePath(rs.getString("image_path"));
        imageDO.setImageGmtCreate(rs.getString("image_gmt_create"));
        return imageDO;
    }

    @Override
    public List<ImageDO> queryImageList(int userId) throws SQLException {
        String sql = "SELECT image_id,image_text,image_path,image_gmt_create from image where user_id = '" + userId + "' and is_deleted = '1'";
        ResultSet rs = query(sql);
        List<ImageDO> list = new ArrayList<>();
        while (rs.next()) {
            ImageDO imageDO = new ImageDO();
            imageDO.setImageId(rs.getInt("image_id"));
            imageDO.setImageText(rs.getString("image_text"));
            imageDO.setImagePath(rs.getString("image_path"));
            imageDO.setImageGmtCreate(rs.getString("image_gmt_create"));
            list.add(imageDO);
        }
        return list;
    }

    @Override
    public List<ImageDO> queryImageClass(int userId, int classId) throws SQLException {
        String sql = "SELECT image_id,image_text,image_path,image_gmt_create from image where user_id = '" + userId + "' and class_id = '" + classId + "' and is_deleted = '1'";
        ResultSet rs = query(sql);
        List<ImageDO> list = new ArrayList<>();
        while (rs.next()) {
            ImageDO imageDO = new ImageDO();
            imageDO.setImageId(rs.getInt("image_id"));
            imageDO.setImageText(rs.getString("image_text"));
            imageDO.setImagePath(rs.getString("image_path"));
            imageDO.setImageGmtCreate(rs.getString("image_gmt_create"));
            list.add(imageDO);
        }
        return list;
    }
}
