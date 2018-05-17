package com.wang.dao;

/**
 * DAOFactory: 提供全局的DAO获取
 *
 * @auther ten
 */
public class DAOFactory {
    /**
     * 获取DAO
     *
     * @param name DAO Name
     * @throws IllegalArgumentException DAO Name 不符合
     */
    public static DAO getDAOByName(String name) {
        DAO DAO;
        switch (name) {
            case "UserDAO":
                DAO = UserDAO.newUserDAO();
                break;
            case "UserMsgDAO":
                DAO = UserMsgDAO.newUserMsgDAO();
                break;
            case "ImageDAO":
                DAO = ImageDAO.newImageDAO();
                break;
            case "DiaryDAO":
                DAO = DiaryDAO.newDiaryDAO();
                break;
            default:
                throw new IllegalArgumentException("DAOFactory cannot create " + name);
        }
        return DAO;
    }
}
