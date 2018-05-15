package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * Form: Form接口
 *
 * 1. 检查格式
 * 2. 检查字符串长度
 * 3.
 *
 * 不进行逻辑判断
 *
 * @auther ten
 */
public interface Form {
    static Form getForm() {
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
