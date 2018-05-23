package com.wang.dao.jdbcimpl;

import com.wang.dao.dao.*;

/**
 * JdbcDAOFactory :
 * 获取jdbc包的DAO接口实现实例
 *
 * @auther ten
 */
public class JdbcDAOFactory implements DAOFactory {

    @Override
    public AdminDAO getAdminDAO() {
        return AdminDAOImpl.newAdminDAO();
    }

    @Override
    public DiaryDAO getDiaryDAO() {
        return DiaryDAOImpl.newDiaryDAO();
    }

    @Override
    public ImageDAO getImageDAO() {
        return ImageDAOImpl.newImageDAO();
    }

    @Override
    public ImageFeatureDAO getImageFeatureDAO() {
        return ImageFeatureDAOImpl.newImageFeatureDAO();
    }

    @Override
    public ImageTypeDAO getImageTypeDAO() {
        return ImageTypeDAOImpl.newImageTypeDAO();
    }

    @Override
    public ImageClassDAO getImageClassDAO() {
        return ImageClassDAOImpl.newImageClassDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return UserDAOImpl.newUserDAO();
    }

    @Override
    public UserIconDAO getUserIconDAO() {
        return UserIconDAOImpl.newUserIconDAO();
    }

    @Override
    public UserPropertyDAO getUserPropertyDAO() {
        return UserPropertyDAOImpl.newUserPropertyDAO();
    }
}
