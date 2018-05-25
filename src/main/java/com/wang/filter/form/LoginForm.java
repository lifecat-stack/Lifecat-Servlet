package com.wang.filter.form;

import javax.servlet.ServletRequest;

/**
 * user_login.do
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
        String errormsg = "";

        String username = request.getParameter("userName");
        String password = request.getParameter("userPassword");

        boolean success = true;
        if (isNull(username)) {
            errormsg += "username is empty ";
            success = false;
        }

        if (isNull(password)) {
            errormsg += "password is empty ";
            success = false;
        }

        if (isTooLong(username, 10)) {
            errormsg += "username is too lang > 10 ";
            success = false;
        }

        if (isTooLong(password, 20)) {
            errormsg += "password is too lang > 20 ";
            success = false;
        }

        if (success) {
            return new FormResult.Builder(true).build();
        }

        return new FormResult.Builder(false).errormsg(errormsg).build();
    }
}
