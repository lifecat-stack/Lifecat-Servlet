package com.wang.form;

/**
 * FormSelector: Form工厂
 *
 * @auther ten
 */
public class FormSelector {
    /**
     * @param action *.do
     * @return Form
     * @throws NullPointerException 无此请求对应的Form
     */
    public static Form select(String action) {
        Form form;
        switch (action) {
            case "login.do":
                form = LoginForm.getForm();
                break;
            case "register.do":
                form = RegisterForm.getForm();
                break;
            case "modifypsw.do":
                form = ModifyPswForm.getForm();
                break;
            case "setmsg.do":
                form = SetMsgForm.getForm();
                break;

            default:
                throw new NullPointerException("Error Form Type");
        }
        return form;
    }
}
