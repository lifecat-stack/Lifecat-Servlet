package com.wang.filter.form;

import javax.servlet.ServletRequest;

/**
 * modifypsw.do
 * <p>
 * 访问权限: 包访问
 *
 * @auther ten
 */
class UserPswUpdateForm extends BaseVerification implements Form {
    private UserPswUpdateForm() {
    }

    static Form getForm() {
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
        String oldpassword = request.getParameter("oldpassword");
        String newpassword1 = request.getParameter("newpassword1");
        String newpassword2 = request.getParameter("newpassword2");

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
