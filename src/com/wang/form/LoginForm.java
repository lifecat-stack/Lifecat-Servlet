package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * login.do
 * <p>
 * 访问权限: 包访问
 *
 * @auther ten
 */
class LoginForm implements MyForm {

    private LoginForm() {
    }

    static MyForm getForm() {
        return new LoginForm();
    }

    /**
     * 1. username == null
     * 2. password == null
     * 3. username > 10
     * 4. password > 20
     *
     * @param request request
     * @return FormResult
     */
    @Override
    public FormResult validate(ServletRequest request) {
        String errormsg;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null) {
            errormsg = "username is empty";
        } else if (password == null) {
            errormsg = "password is empty";
        } else if (username.length() > 10) {
            errormsg = "username is too lang > 10";
        } else if (password.length() > 20) {
            errormsg = "password is too lang > 20";
        } else {
            return new FormResult.Builder(false).build();
        }

        return new FormResult.Builder(true).errormsg(errormsg).build();
    }
}
