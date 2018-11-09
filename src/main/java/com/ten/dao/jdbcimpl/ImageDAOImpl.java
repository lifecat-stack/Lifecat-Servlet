package com.ten.dao.jdbcimpl;

import com.ten.bean.entity.Image;
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
    public int insertImage(Image image) throws SQLException {
        String sql = "INSERT INTO image(image_text, image_path, is_deleted, user_id, class_id, image_gmt_create, image_gmt_modified) " +
                "VALUES( ?,?,?,?,?,?,?)";
        Object[] args = {
                image.getImageText(),
                image.getImagePath(),
                image.getDeleted(),
                image.getUserId(),
                image.getClassId(),
                image.getImageGmtCreate(),
                image.getImageGmtModified()
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
    public Image queryImage(int imageId) throws SQLException {
        String sql = "SELECT image_text,image_path,image_gmt_create from image where image_id = '" + imageId + "' and is_deleted = '1'";
        ResultSet rs = query(sql);
        rs.next();
        Image image = new Image();
        image.setImageId(imageId);
        image.setImageText(rs.getString("image_text"));
        image.setImagePath(rs.getString("image_path"));
        image.setImageGmtCreate(rs.getString("image_gmt_create"));
        return image;
    }

    @Override
    public List<Image> queryImageList(int userId) throws SQLException {
        String sql = "SELECT image_id,image_text,image_path,image_gmt_create from image where user_id = '" + userId + "' and is_deleted = '1'";
        ResultSet rs = query(sql);
        List<Image> list = new ArrayList<>();
        while (rs.next()) {
            Image image = new Image();
            image.setImageId(rs.getInt("image_id"));
            image.setImageText(rs.getString("image_text"));
            image.setImagePath(rs.getString("image_path"));
            image.setImageGmtCreate(rs.getString("image_gmt_create"));
            list.add(image);
        }
        return list;
    }

    @Override
    public List<Image> queryImageClass(int userId, int classId) throws SQLException {
        String sql = "SELECT image_id,image_text,image_path,image_gmt_create from image where user_id = '" + userId + "' and class_id = '" + classId + "' and is_deleted = '1'";
        ResultSet rs = query(sql);
        List<Image> list = new ArrayList<>();
        while (rs.next()) {
            Image image = new Image();
            image.setImageId(rs.getInt("image_id"));
            image.setImageText(rs.getString("image_text"));
            image.setImagePath(rs.getString("image_path"));
            image.setImageGmtCreate(rs.getString("image_gmt_create"));
            list.add(image);
        }
        return list;
    }
}
