package com.wang.dao.jdbcimpl;

import com.wang.dao.dao.ImageClassDAO;

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
