package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * modifypsw.do
 * <p>
 * 访问权限: 包访问
 *
 * @auther ten
 */
class ModifyPswForm implements MyForm {
    private ModifyPswForm() {
    }

    static MyForm getForm() {
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
        FormResult result = new FormResult();

        String oldpassword = request.getParameter("oldpassword");
        String newpassword1 = request.getParameter("newpassword1");
        String newpassword2 = request.getParameter("newpassword2");

        if (oldpassword == null) {
            result.setError("oldpassword is empty");
        } else if (newpassword1 == null || newpassword2 == null) {
            result.setError("newpassword is empty");
        } else if (!newpassword1.equals(newpassword2)) {
            result.setError("newpassword1 != newpassword2");
        } else if (newpassword1.length() > 20) {
            result.setError("newpassword is too lang > 20");
        } else {
            result.setTrue();
        }

        return result;
    }
}
