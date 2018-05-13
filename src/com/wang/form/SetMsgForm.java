package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * setmsg.do
 * <p>
 * 访问权限: 包访问
 *
 * @auther ten
 */
class SetMsgForm implements MyForm {
    private SetMsgForm() {
    }

    static MyForm getForm() {
        return new SetMsgForm();
    }

    /**
     * 1. nickname == null
     * 2. sex == null
     * 3. age == null
     * 4. birthday == null
     * 5. email == null
     * <p>
     * 6. nickname > 20
     * 7. sex != '男' && sex != "女
     * 8. {@literal age < 0 || age > 100}
     *
     * @param request request
     * @return FormResult
     */
    @Override
    public FormResult validate(ServletRequest request) {
        String errormsg;

        String nickname = request.getParameter("nickname");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");

        if (nickname == null) {
            errormsg = "nickname is empty";
        } else if (sex == null) {
            errormsg = "sex is empty";
        } else if (age == null) {
            errormsg = "age is empty";
        } else if (birthday == null) {
            errormsg = "birthday is empty";
        } else if (email == null) {
            errormsg = "email is empty";
        } else if (nickname.length() > 20) {
            errormsg = "nickname is too lang > 20";
        } else if (!sex.equals("男") && !sex.equals("女")) {
            errormsg = "sex must be 男 or 女";
        } else if (Integer.valueOf(age) < 0 || Integer.valueOf(age) > 100) {
            errormsg = "age must be 0 ~ 100";
        } else {
            return new FormResult.Builder(false).build();
        }

        return new FormResult.Builder(true).errormsg(errormsg).build();
    }
}
