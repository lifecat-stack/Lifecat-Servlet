package com.ten.filter.form.impl;

import com.ten.filter.form.Form;
import com.ten.filter.form.FormResult;

import javax.servlet.ServletRequest;

/**
 * setmsg.do
 *
 * @auther ten
 */
public class UserPropertyUpdateForm extends BaseVerification implements Form {
    private UserPropertyUpdateForm() {
    }

    public static Form getForm() {
        return new UserPropertyUpdateForm();
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
        String nickname = request.getParameter("nickname");
        String signature = request.getParameter("signature");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        String location = request.getParameter("location");
        String birthday = request.getParameter("birthday");

        boolean success = true;
        String errormsg = "";

        if (isTooLong(nickname, 20)) {
            errormsg += "nickname is too lang";
            success = false;
        }
        if (isTooLong(signature, 50)) {
            errormsg += "signature is too lang";
            success = false;
        }
        if (isTooLong(sex, 10)) {
            errormsg += "sex is too lang";
            success = false;
        }
        if (isTooLong(email, 30)) {
            errormsg += "email is too lang";
            success = false;
        }
        if (isTooLong(location, 30)) {
            errormsg += "location is too lang";
            success = false;
        }
        if (isTooLong(birthday, 30)) {
            errormsg += "birthday is too lang";
            success = false;
        }

        if (success) {
            return new FormResult.Builder(true).build();
        }

        return new FormResult.Builder(false).errormsg(errormsg).build();
    }
}
