package com.wang.form;

/**
 * Form工厂
 *
 * @auther ten
 */
public class FormSelector {
    /**
     * @param action post.do类型
     * @return form
     */
    public static MyForm select(String action) {
        MyForm form;
        switch (action) {
            case "login":
                form = LoginForm.getForm();
                break;
            case "register":
                form = RegisterForm.getForm();
                break;
            case "modifypsw":
                form = ModifyPswForm.getForm();
                break;
            case "setmsg":
                form = SetMsgForm.getForm();
                break;

            default:
                throw new NullPointerException("Error Form Type");
        }
        return form;
    }
}
