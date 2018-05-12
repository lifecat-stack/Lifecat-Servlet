package com.wang.form;

import javax.servlet.ServletRequest;
import java.util.logging.Logger;

/**
 * Form接口
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
