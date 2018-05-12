package com.wang.model;

/**
 * Model工厂
 *
 * @auther ten
 */
public class ModelSelector {
    public static MyModel select(String action) {
        MyModel model;
        switch (action) {
            case "login":
                model = new LoginModel();
                break;
            case "register":
                model = new RegisterModel();
                break;
            case "modifypsw":
                model = new ModifyPswModel();
                break;
            case "setmsg":
                model = new SetMsgModel();
                break;

            default:
                model = null;
        }
        return model;
    }
}
