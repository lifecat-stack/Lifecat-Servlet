package com.wang.form;

/**
 * @name FormSelector
 * @description 工厂模式:根据action选择返回对应的Form
 * @auther ten
 */
public class FormSelector {
    public static MyForm select(String action) {
        MyForm form;
        switch (action) {
            case "Login":
                form = new LoginForm();
                break;
            case "Register":
                form = new RegisterForm();
                break;
            case "ModifyPsw":
                form = new ModifyPswForm();
                break;
            case "SetMsg":
                form = new SetMsgForm();
                break;
            case "UpImg":
                form = new UpImgForm();
                break;
            case "UpDiary":
                form = new UpDiaryForm();
                break;
            default:
                System.out.println("FormSelector没有此表单项");
                form = null;
        }
        return form;
    }
}
