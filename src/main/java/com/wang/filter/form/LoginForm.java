package com.wang.filter.form;

import javax.servlet.ServletRequest;

/**
 * login.do
 * <p>
 * 访问权限: 包访问
 *
 * @auther ten
 */
class LoginForm extends BaseVerification implements Form {

    private LoginForm() {
    }

    static Form getForm() {
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

        if (isNull(username)) {
            errormsg = "username is empty";
        }
   
        if (isNull(password)) {
            errormsg = "password is empty";
        }

        if (isTooLong(username, 10)) {
            errormsg = "username is too lang > 10";
        }

        if (isTooLong(password, 20)) {
            errormsg = "password is too lang > 20";
        }


        return new FormResult.Builder(false).build();


    }
}
