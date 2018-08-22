package com.ten.filter.form.impl;

import com.ten.filter.form.Form;
import com.ten.filter.form.FormResult;

import javax.servlet.ServletRequest;

/**
 * register.do
 *
 * @auther ten
 */
public class UserRegisterForm extends BaseVerification implements Form {
    private UserRegisterForm() {
    }

    public static Form getForm() {
        return new UserRegisterForm();
    }

    /**
     * 1. username == null
     * 2. password == null
     * 3. password1 != password2
     * 4. username > 10
     * 5. password > 20
     *
     * @param request request
     * @return FormResult
     */
    @Override
    public FormResult validate(ServletRequest request) {
        String rusername = request.getParameter("rUserName");
        String rpassword1 = request.getParameter("rUserPassword1");
        String rpassword2 = request.getParameter("rUserPassword2");

        boolean success = true;
        String errormsg = "";

        if (isNull(rusername)) {
            errormsg += "username is empty";
            success = false;
        }
        if (isNull(rpassword1) || isNull(rpassword2)) {
            errormsg += "password is empty";
            success = false;
        }
        if (isDiff(rpassword1, rpassword2)) {
            errormsg += "password1 != password2";
            success = false;
        }
        if (isTooLong(rusername, 10)) {
            errormsg += "username is too lang > 10";
            success = false;
        }
        if (isTooLong(rpassword1, 20)) {
            errormsg += "password is too lang > 20";
            success = false;
        }

        if (success) {
            return new FormResult.Builder(true).build();
        }

        return new FormResult.Builder(false).errormsg(errormsg).build();
    }
}
