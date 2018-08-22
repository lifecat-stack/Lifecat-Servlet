package com.ten.filter.form.impl;

import com.ten.filter.form.Form;
import com.ten.filter.form.FormResult;

import javax.servlet.ServletRequest;

/**
 * modifypsw.do
 *
 * @auther ten
 */
public class UserPswUpdateForm extends BaseVerification implements Form {
    private UserPswUpdateForm() {
    }

    public static Form getForm() {
        return new UserPswUpdateForm();
    }

    /**
     * 1. oldpassword == null
     * 2. newpassword == null
     * 3. newpassword1 != newpassword2
     * 4. newpassword > 20
     *
     * @param request request
     * @return FormResult
     */
    @Override
    public FormResult validate(ServletRequest request) {
        String oldpassword = request.getParameter("oldPassword");
        String newpassword1 = request.getParameter("newPassword1");
        String newpassword2 = request.getParameter("newPassword2");

        boolean success = true;
        String errormsg = "";

        if (isNull(oldpassword)) {
            errormsg += "oldpassword is empty";
            success = false;
        }
        if (isNull(newpassword1) || isNull(newpassword2)) {
            errormsg += "newpassword is empty";
            success = false;
        }
        if (isDiff(newpassword1, newpassword2)) {
            errormsg += "newpassword1 != newpassword2";
            success = false;
        }
        if (isTooLong(newpassword1, 20)) {
            errormsg += "newpassword is too lang > 20";
            success = false;
        }

        if (success) {
            return new FormResult.Builder(true).build();
        }

        return new FormResult.Builder(false).errormsg(errormsg).build();
    }
}
