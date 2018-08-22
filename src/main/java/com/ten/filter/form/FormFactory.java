package com.ten.filter.form;

import com.ten.filter.form.impl.*;

/**
 * FormFactory: Form工厂
 *
 * @auther ten
 */
public class FormFactory {
    /**
     * @param url *
     * @return Form
     * @throws NullPointerException 无此请求对应的Form
     */
    public static Form getFormByName(String url) {
        Form form = null;

        if ("user_login".equals(url)) {
            form = UserLoginForm.getForm();
        } else if ("user_register".equals(url)) {
            form = UserRegisterForm.getForm();
        } else if ("admin_login".equals(url)) {
            // TODO
        } else if ("admin_register".equals(url)) {
            // TODO
        } else if ("user_property_update".equals(url)) {
            form = UserPropertyUpdateForm.getForm();
        } else if ("user_password_update".equals(url)) {
            form = UserPswUpdateForm.getForm();
        } else if ("image_upload".equals(url)) {
            form = ImageUploadForm.getForm();
        } else if ("diary_upload".equals(url)) {
            form = DiaryUploadForm.getForm();
        }

        return form;
    }
}
