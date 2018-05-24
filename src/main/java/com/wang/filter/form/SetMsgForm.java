package com.wang.filter.form;

import javax.servlet.ServletRequest;

/**
 * setmsg.do
 * <p>
 * 访问权限: 包访问
 *
 * @auther ten
 */
class SetMsgForm extends BaseVerification implements Form {
    private SetMsgForm() {
    }

    static Form getForm() {
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

        if (isNull(nickname)) {
            errormsg = "nickname is empty";
        }
        if (isNull(sex)) {
            errormsg = "sex is empty";
        }
        if (isNull(age)) {
            errormsg = "age is empty";
        }
        if (birthday == null) {
            errormsg = "birthday is empty";
        }
        if (email == null) {
            errormsg = "email is empty";
        }
        if (nickname.length() > 20) {
            errormsg = "nickname is too lang > 20";
        }
        if (!sex.equals("男") && !sex.equals("女")) {
            errormsg = "sex must be 男 or 女";
        }
        if (Integer.valueOf(age) < 0 || Integer.valueOf(age) > 100) {
            errormsg = "age must be 0 ~ 100";
        }

        return new FormResult.Builder(false).build();


    }
}
