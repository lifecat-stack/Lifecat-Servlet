package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * @name RegisterForm
 * @description 注册表单验证
 * @auther ten
 */
public class RegisterForm implements MyForm {
    @Override
    public FormResult validate(ServletRequest req) {
        FormResult result = new FormResult();

        /* 用户名为空 */
        if (req.getParameter("rusername") == null) {
            result.setError("username is empty");
        }
        /* 密码为空 */
        else if (req.getParameter("rpassword1") == null || req.getParameter("rpassword2") == null) {
            result.setError("password is empty");
        }
        /* 两次密码不一致 */
        else if (!req.getParameter("rpassword1").equals(req.getParameter("rpassword2"))) {
            result.setError("两次密码不一致");
        }
        /* 正确 */
        else {
            result.setTrue();
        }

        return result;
    }
}
