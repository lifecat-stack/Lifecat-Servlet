package com.wang.imgmodel;

import com.wang.domodel.ModelResult;
import com.wang.domodel.MyModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @name UpImgModel
 * @description 上传图片，对应表单UpImg，对应页面uploadimage.jsp
 * @auther ten
 */
 class UpImgModel implements MyModel {

    private UpImgModel() {
    }

    static MyModel getModel() {
        return new UpImgModel();
    }

    @Override
    public ModelResult execute(HttpServletRequest req, HttpServletResponse resp) {

        return null;
    }
}
