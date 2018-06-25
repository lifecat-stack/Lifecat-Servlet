package com.wang.filter.form.impl;

import com.wang.filter.form.Form;

import javax.servlet.ServletRequest;

public class ImageUploadForm extends BaseVerification implements Form {
    private ImageUploadForm() {
    }

    static Form getForm() {
        return new ImageUploadForm();
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
