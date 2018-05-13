package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * MyForm: Form接口
 *
 * @auther ten
 */
public interface MyForm {
    static MyForm getForm() {
        return null;
    }

    /**
     * 验证表单
     *
     * @param request request
     * @return FormResult
     */
    FormResult validate(ServletRequest request);
}
