package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * setmsg.do
 *
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
        FormResult result = new FormResult();

        String nickname = request.getParameter("nickname");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");

        if (nickname == null) {
            result.setError("nickname is empty");
        } else if (sex == null) {
            result.setError("sex is empty");
        } else if (age == null) {
            result.setError("age is empty");
        } else if (birthday == null) {
            result.setError("birthday is empty");
        } else if (email == null) {
            result.setError("email is empty");
        } else if (nickname.length() > 20) {
            result.setError("nickname is too lang > 20");
        } else if (!sex.equals("男") && !sex.equals("女")) {
            result.setError("sex must be 男 or 女");
        } else if (Integer.valueOf(age) < 0 || Integer.valueOf(age) > 100) {
            result.setError("age must be 0 ~ 100");
        } else {
            result.setTrue();
        }

        return result;
    }
}
