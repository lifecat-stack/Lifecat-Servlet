package com.ten.filter.form;

import javax.servlet.ServletRequest;

/**
 * Form: Form接口
 * <p>
 * 1. 检查格式
 * 2. 检查字符串长度
 * 3. 检查两次输入是否相同
 * <p>
 * 不进行逻辑判断
 *
 * @date 2018/5/20
 * @auther ten
 */
public interface Form {
    /**
     * 验证表单
     *
     * @param request request
     * @return FormResult
     */
    FormResult validate(ServletRequest request);
}
