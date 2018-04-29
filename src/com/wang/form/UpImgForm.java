package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * @name UpImgForm
 * @description 上传图片表单验证
 * @auther ten
 */
public class UpImgForm implements MyForm {
    @Override
    public FormResult validate(ServletRequest req) {
        FormResult result = new FormResult();
        /* 图片名称为空 */
        if (req.getParameter("imagename") == null) {
            result.setError("imagename is null");
        }
        /* 图片内容为空 */
        else if (req.getParameter("imagedescription") == null) {
            result.setError("imagedescription is empty");
        }
        /* 正确 */
        else {
            result.setTrue();
        }

        return result;
    }
}
