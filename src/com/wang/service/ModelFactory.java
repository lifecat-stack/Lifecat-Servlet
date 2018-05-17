package com.wang.service;

/**
 * ModelFactory: 提供全局的Model获取
 *
 * @auther ten
 */
public class ModelFactory {
    /**
     * 获取ServiceModel
     *
     * @param action action
     * @throws IllegalArgumentException id 不符合
     */
    public static ServiceModel getModelByAction(String action) {
        ServiceModel model;
        switch (action) {
            case "login":
                model = UserLoginModel.getModel();
                break;
            case "register":
                model = UserRegisterModel.getModel();
                break;
            case "uppsw":
                model = UpUserPswModel.getModel();
                break;
            case "setmsg":
                model = SetUserMsgModel.getModel();
                break;
            case "updiary":
                model = UpDiaryModel.getModel();
                break;

            default:
                model = null;
        }
        return model;
    }
}
