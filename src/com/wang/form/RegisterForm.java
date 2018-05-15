package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * register.do
 * <p>
 * 访问权限: 包访问
 *
 * @auther ten
 */
class RegisterForm implements Form {
    private RegisterForm() {
    }

    static Form getForm() {
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
        String errormsg;

        String rusername = request.getParameter("rusername");
        String rpassword1 = request.getParameter("rpassword1");
        String rpassword2 = request.getParameter("rpassword2");

        if (rusername == null) {
            errormsg = "username is empty";
        } else if (rpassword1 == null || rpassword2 == null) {
            errormsg = "password is empty";
        } else if (!rpassword1.equals(rpassword2)) {
            errormsg = "password1 != password2";
        } else  if (rusername.length() > 10) {
            errormsg = "username is too lang > 10";
        } else if (rpassword1.length() > 20) {
            errormsg = "password is too lang > 20";
        } else {
            return new FormResult.Builder(false).build();
        }

        return new FormResult.Builder(true).errormsg(errormsg).build();
    }
}
