package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * register.do
 *
 * 访问权限: 包访问
 *
 * @auther ten
 */
class RegisterForm implements MyForm {
    private RegisterForm() {
    }

    static MyForm getForm() {
        return new RegisterForm();
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
        FormResult result = new FormResult();
        String rusername = request.getParameter("rusername");
        String rpassword1 = request.getParameter("rpassword1");
        String rpassword2 = request.getParameter("rpassword2");

        if (rusername == null) {
            result.setError("username is empty");
        } else if (rpassword1 == null || rpassword2 == null) {
            result.setError("password is empty");
        } else if (!rpassword1.equals(rpassword2)) {
            result.setError("password1 != password2");
        } else if (rusername.length() > 10) {
            result.setError("username is too lang > 10");
        } else if (rpassword1.length() > 20) {
            result.setError("password is too lang > 20");
        } else {
            result.setTrue();
        }

        return result;
    }
}
