package com.wang.dao.jdbcimpl;

import com.wang.dao.dao.ImageTypeDAO;
import com.wang.bean.doo.ImageTypeDO;

import java.sql.SQLException;
import java.util.List;
/**
 * ImageTypeDAO -- jdbc实现类
 *
 * @auther ten
 */
public class ImageTypeDAOImpl extends AbstractDAO implements ImageTypeDAO {
     private ImageTypeDAOImpl() {
    }

    static ImageTypeDAO newImageTypeDAO() {
        return new ImageTypeDAOImpl();
    }

    @Override
    public void insertImageType(ImageTypeDO imageTypeDO) throws SQLException {

    }

    @Override
    public List<Integer> queryImageType(int userId, int classId) throws SQLException {
        return null;
    }

    @Override
    public void updateImageType(int imageId, int classId) throws SQLException {

    }
}
