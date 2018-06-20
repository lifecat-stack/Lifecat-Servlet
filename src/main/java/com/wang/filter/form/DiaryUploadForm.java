package com.wang.filter.form;

import javax.servlet.ServletRequest;

public class DiaryUploadForm extends BaseVerification implements Form {
    private DiaryUploadForm() {
    }

    static Form getForm() {
        return new DiaryUploadForm();
    }

    @Override
    public FormResult validate(ServletRequest request) {

        boolean success = true;
        String errormsg = "";

        if (success) {
            return new FormResult.Builder(true).build();
        }

        return new FormResult.Builder(false).errormsg(errormsg).build();

    }
}
