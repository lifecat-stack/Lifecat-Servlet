package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * @name SetMsgForm
 * @description 个人信息表单验证
 * @auther ten
 */
public class SetMsgForm implements MyForm {
    @Override
    public FormResult validate(ServletRequest req) {
        FormResult result = new FormResult();

        /* 昵称为空 */
        if (req.getParameter("nickname") == null) {
            result.setError("nickname is empty");
        }
        /* 性别为空 */
        else if (req.getParameter("sex") == null) {
            result.setError("sex is empty");
        }
        /* 年龄为空 */
        else if (req.getParameter("age") == null) {
            result.setError("age is empty");
        }
        /* 生日为空 */
        else if (req.getParameter("birthday") == null) {
            result.setError("birthday is empty");
        }
        /* 邮箱为空 */
        else if (req.getParameter("email") == null) {
            result.setError("email is empty");
        }
        /* 正确 */
        else {
            result.setTrue();
        }

        return result;
    }
}
