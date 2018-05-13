package com.wang.domodel;

/**
 * ModelSelector: Model工厂
 *
 * @auther ten
 */
public class ModelSelector {
    public static MyModel select(String action) {
        MyModel model;
        switch (action) {
            case "login":
                model = LoginModel.getModel();
                break;
            case "register":
                model = RegisterModel.getModel();
                break;
            case "modifypsw":
                model = ModifyPswModel.getModel();
                break;
            case "setmsg":
                model = SetMsgModel.getModel();
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
