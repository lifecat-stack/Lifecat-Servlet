package com.wang.form;

import javax.servlet.ServletRequest;

/**
 * @name UpDiaryForm
 * @description 上传日记表单验证、
 * @auther ten
 */
public class UpDiaryForm implements MyForm {
    @Override
    public FormResult validate(ServletRequest req) {
        FormResult result = new FormResult();
        /* 日记名称为空 */
        if (req.getParameter("diaryname") == null) {
            result.setError("diaryname is empty");
        }
        /* 日记内容为空 */
        else if (req.getParameter("diarydescription") == null) {
            result.setError("diarydescription is empty");
        }
        /* 正确 */
        else {
            result.setTrue();
        }

        return result;
    }
}
