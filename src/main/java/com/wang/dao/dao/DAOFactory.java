package com.wang.dao.dao;

/**
 * DAO抽象工厂
 *
 * @date 2018/5/23
 * @auther ten
 */
public interface DAOFactory {
    AdminDAO getAdminDAO();

    DiaryDAO getDiaryDAO();

    ImageDAO getImageDAO();

    ImageFeatureDAO getImageFeatureDAO();

    ImageClassDAO getImageClassDAO();

    UserDAO getUserDAO();

    UserIconDAO getUserIconDAO();

    UserPropertyDAO getUserPropertyDAO();
}
