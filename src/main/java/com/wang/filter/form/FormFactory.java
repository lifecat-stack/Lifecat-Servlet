package com.wang.filter.form;

/**
 * FormFactory: Form工厂
 *
 * @auther ten
 */
public class FormFactory {
    /**
     * @param url *
     * @return Form
     * @throws NullPointerException 无此请求对应的Form
     */
    public static Form getFormByName(String url) {
        Form form;

        if ("user_login".equals(url)) {
            form = LoginForm.getForm();

        } else if ("user_register".equals(url)) {
            form = RegisterForm.getForm();

        } else if ("modifypsw.do".equals(url)) {
            form = ModifyPswForm.getForm();

        } else if ("setmsg.do".equals(url)) {
            form = SetMsgForm.getForm();

        } else {
            form = null;
        }
        return form;
    }
}
