package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * @name LoginForm
 * @description 登录表单验证
 * @auther ten
 */
public class LoginForm implements MyForm {
    @Override
    public FormResult validate(ServletRequest req) {
        FormResult result = new FormResult();

        /* 用户名为空 */
        if (req.getParameter("username") == null) {
            result.setError("username is empty");
        }
        /* 密码为空 */
        else if (req.getParameter("password") == null) {
            result.setError("password is empty");
        }
        /* 正确 */
        else {
            result.setTrue();
        }

        return result;
    }
}
