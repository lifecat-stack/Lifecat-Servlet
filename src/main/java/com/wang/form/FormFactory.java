package com.wang.form;

/**
 * FormFactory: Form工厂
 *
 * @auther ten
 */
public class FormFactory {
    /**
     * @param url *.do
     * @return Form
     * @throws NullPointerException 无此请求对应的Form
     */
    public static Form getFormByName(String url) {
        Form form;

        if ("login.do".equals(url)) {
            form = LoginForm.getForm();

        } else if ("register.do".equals(url)) {
            form = RegisterForm.getForm();

        } else if ("modifypsw.do".equals(url)) {
            form = ModifyPswForm.getForm();

        } else if ("setmsg.do".equals(url)) {
            form = SetMsgForm.getForm();

        } else {
            throw new NullPointerException("Error Form Type");
        }
        return form;
    }
}
