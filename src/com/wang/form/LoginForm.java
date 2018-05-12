package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * login.do
 *
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
        FormResult result = new FormResult();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null) {
            result.setError("username is empty");
        } else if (password == null) {
            result.setError("password is empty");
        } else if (username.length() > 10) {
            result.setError("username is too lang > 10");
        } else if (password.length() > 20) {
            result.setError("password is too lang > 20");
        } else {
            result.setTrue();
        }

        return result;
    }
}
