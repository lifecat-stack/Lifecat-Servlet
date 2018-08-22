package com.ten.filter.form.impl;

import com.ten.filter.form.Form;
import com.ten.filter.form.FormResult;

import javax.servlet.ServletRequest;

/**
 * user_login.do
 *
 * @auther ten
 */
public class UserLoginForm extends BaseVerification implements Form {
    private UserLoginForm() {
    }

    public static Form getForm() {
        return new UserLoginForm();
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
        String username = request.getParameter("userName");
        String password = request.getParameter("userPassword");

        System.out.println(username);
        System.out.println(password);

        String errormsg = "";
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
