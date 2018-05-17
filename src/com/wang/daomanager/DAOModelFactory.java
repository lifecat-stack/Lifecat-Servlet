package com.wang.daomanager;

/**
 * DAOModelFactory: 提供全局的Model获取
 *
 * @auther ten
 */
public class DAOModelFactory {
    /**
     * 获取Model
     *
     * @param userid userid
     * @param name   model name
     * @throws IllegalArgumentException id 不符合
     */
    public static DAOModel getDAOModelByName(int userid, String name) {
        if (userid <= 0) {
            throw new IllegalArgumentException("Id is Error");
        }

        DAOModel DAOModel;
        switch (name) {
            case "UserDAOModel":
                DAOModel = UserDAOModel.getUserModel(userid);
                break;
            case "UserMsgDAOModel":
                DAOModel = UserMsgDAOModel.getUserMsgModel(userid);
                break;
            case "ImageDAOModel":
                DAOModel = ImageDAOModel.getImageModel(userid);
                break;
            case "DiaryDAOModel":
                DAOModel = DiaryDAOModel.getUserDiaryModel(userid);
                break;
            default:
                DAOModel = null;
        }

        return DAOModel;
    }
}
