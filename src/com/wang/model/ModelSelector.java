package com.wang.model;
/**
 * @name ModelSelector
 * @description 选择模型
 * @auther ten
 */
public class ModelSelector {
    public static MyModel select(String action) {
        MyModel model;
        switch (action) {
            case "Login":
                model = new LoginModel();
                break;
            case "Register":
                model = new RegisterModel();
                break;
            case "ModifyPsw":
                model = new ModifyPswModel();
                break;
            case "SetMsg":
                model = new SetMsgModel();
                break;
            case "UpImg":
                model = new UpImgModel();
                break;
            case "UpDiary":
                model = new UpDiaryModel();
                break;
            /* Get模型,由jsp调用 */
            case "GetDiary":
                model = new GetDiaryModel();
                break;
            case "GetImg":
                model = new GetImgModel();
                break;
            case "GetMsg":
                model = new GetMsgModel();
                break;
            default:
                System.out.println("ModelSelector没有此表单项");
                model = null;
        }
        return model;
    }
}
