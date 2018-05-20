package com.wang.daoimpl;

/**
 * DAOFactory :
 * <p>
 * 由Manager调用, 返回具体数据表的DAO对象
 *
 * @auther ten
 */
public class DAOFactory {

    public static DAO getDAOByName(String name) {
        DAO dao;
        switch (name) {
            case "AdminDAOImpl":
                dao = AdminDAOImpl.newAdminDAO();
                break;
            case "UserDAO":
                dao = UserDAO.newUserDAO();
                break;
            case "UserPropertyDAO":
                dao = UserPropertyDAO.newUserMsgDAO();
                break;
            case "UserIconDAO":
                dao = UserIconDAO.newUserIconDAO();
                break;
            case "ImageDAO":
                dao = ImageDAO.newImageDAO();
                break;
            case "ImageTypeDAO":
                dao = ImageTypeDAO.newImageTypeDAO();
                break;
            case "ImageClassDAO":
                dao = ImageClassDAO.newImageClassDAO();
                break;
            case "ImageFeatureDAO":
                dao = ImageFeatureDAO.newImageFeatureDAO();
                break;
            case "DiaryDAO":
                dao = DiaryDAO.newDiaryDAO();
                break;

            default:
                dao = null;
        }
        return dao;
    }
}
