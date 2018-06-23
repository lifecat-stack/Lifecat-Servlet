package com.wang.dao.jdbcimpl;

import com.wang.dao.DAOFactory;
import com.wang.dao.dao.*;

/**
 * JdbcDAOFactory :
 * 获取jdbc包的DAO接口实现实例
 *
 * @auther ten
 */
public class JdbcDAOFactory implements DAOFactory {

    public static AdminDAO getAdminDAO() {
        return AdminDAOImpl.newAdminDAO();
    }

    public static DiaryDAO getDiaryDAO() {
        return DiaryDAOImpl.newDiaryDAO();
    }

    public static ImageDAO getImageDAO() {
        return ImageDAOImpl.newImageDAO();
    }

    public static ImageFeatureDAO getImageFeatureDAO() {
        return ImageFeatureDAOImpl.newImageFeatureDAO();
    }

    public static ImageClassDAO getImageClassDAO() {
        return ImageClassDAOImpl.newImageClassDAO();
    }

    public static UserDAO getUserDAO() {
        return UserDAOImpl.newUserDAO();
    }

    public static UserIconDAO getUserIconDAO() {
        return UserIconDAOImpl.newUserIconDAO();
    }

    public static UserPropertyDAO getUserPropertyDAO() {
        return UserPropertyDAOImpl.newUserPropertyDAO();
    }
}
