package com.wang.dao.mybatisimpl;

import com.wang.dao.ImageFeatureDAO;

/**
 * UserDAO -- jdbc实现类
 *
 * @auther ten
 */
class ImageFeatureDAOImpl extends AbstractDAO implements ImageFeatureDAO {
    private ImageFeatureDAOImpl() {
    }

    static ImageFeatureDAO newImageFeatureDAO() {
        return new ImageFeatureDAOImpl();
    }
}
