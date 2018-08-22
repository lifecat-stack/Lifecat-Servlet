package com.ten.filter.form.impl;

import com.ten.filter.form.Form;
import com.ten.filter.form.FormResult;

import javax.servlet.ServletRequest;

public class ImageUploadForm extends BaseVerification implements Form {
    private ImageUploadForm() {
    }

    public static Form getForm() {
        return new ImageUploadForm();
    }

    @Override
    public FormResult validate(ServletRequest request) {
        return new FormResult.Builder(true).build();
    }
}
