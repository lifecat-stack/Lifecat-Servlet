package com.ten.dao.jdbcimpl;

import com.ten.dao.ImageClassDAO;

/**
 * UserDAO -- jdbc实现类
 *
 * @auther ten
 */
class ImageClassDAOImpl extends AbstractDAO implements ImageClassDAO {

     private ImageClassDAOImpl(){}

    static ImageClassDAO newImageClassDAO() {
        return new ImageClassDAOImpl();
    }
}
