package com.wang.dao.jdbcimpl;

import com.wang.bean.doo.ImageDO;
import com.wang.dao.dao.ImageDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * UserDAO -- jdbc实现类
 *
 * @auther ten
 */
class ImageDAOImpl extends AbstractDAO implements ImageDAO {

    private ImageDAOImpl() {
    }

    static ImageDAO newImageDAO() {
        return new ImageDAOImpl();
    }

    @Override
    public int insertImage(ImageDO imageDO) throws SQLException {
        return 0;
    }

    @Override
    public void deleteImage(int imageId) throws SQLException {

    }

    @Override
    public void updateImageText(int imageId, String newText) throws SQLException {

    }

    @Override
    public ImageDO queryImage(String imageName) throws SQLException {
        return null;
    }

    @Override
    public List<ImageDO> queryImageList(int userId) throws SQLException {
        return null;
    }

    @Override
    public List<ImageDO> queryImageClass(int userId, int classId) throws SQLException {
        return null;
    }
}
