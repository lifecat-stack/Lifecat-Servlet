package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * modifypsw.do
 * <p>
 * 访问权限: 包访问
 *
 * @auther ten
 */
class ModifyPswForm extends BaseVerification implements Form {
    private ModifyPswForm() {
    }

    static Form getForm() {
        return new ModifyPswForm();
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
        String errormsg;

        String oldpassword = request.getParameter("oldpassword");
        String newpassword1 = request.getParameter("newpassword1");
        String newpassword2 = request.getParameter("newpassword2");

        if (oldpassword == null) {
            errormsg = "oldpassword is empty";
        } else if (newpassword1 == null || newpassword2 == null) {
            errormsg = "newpassword is empty";
        } else if (!newpassword1.equals(newpassword2)) {
            errormsg = "newpassword1 != newpassword2";
        } else if (newpassword1.length() > 20) {
            errormsg = "newpassword is too lang > 20";
        } else {
            return new FormResult.Builder(false).build();
        }

        return new FormResult.Builder(true).errormsg(errormsg).build();
    }
}
