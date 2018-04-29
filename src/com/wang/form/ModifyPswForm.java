package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * @name ModifyPswForm
 * @description 修改密码表单验证
 * @auther ten
 */
public class ModifyPswForm implements MyForm {
    @Override
    public FormResult validate(ServletRequest req) {
        FormResult result = new FormResult();

        /* 原密码为空 */
        if (req.getParameter("oldpassword") == null) {
            result.setError("oldpassword is empty");
        }
        /* 新密码为空 */
        else if (req.getParameter("newpassword1") == null || req.getParameter("newpassword2") == null) {
            result.setError("newpassword is empty");
        }
        /* 两次新密码不一致 */
        else if (!req.getParameter("newpassword1").equals(req.getParameter("newpassword2"))) {
            result.setError("两次新密码不一致");
        }
        /* 正确 */
        else {
            result.setTrue();
        }

        return result;
    }
}
