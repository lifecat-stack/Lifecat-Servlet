package com.ten.filter.form.impl;

import com.ten.filter.form.Form;
import com.ten.filter.form.FormResult;

import javax.servlet.ServletRequest;

public class DiaryUploadForm extends BaseVerification implements Form {
    private DiaryUploadForm() {
    }

    public static Form getForm() {
        return new DiaryUploadForm();
    }

    @Override
    public FormResult validate(ServletRequest request) {
        return new FormResult.Builder(true).build();
    }
}
