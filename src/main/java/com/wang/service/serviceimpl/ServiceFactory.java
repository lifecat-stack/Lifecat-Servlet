package com.wang.service.serviceimpl;

import com.wang.service.service.Service;

/**
 * ServiceFactory :
 * <p>
 * 由controller调用, 根据url请求, 返回相应的service对象
 *
 * @auther ten
 */
public class ServiceFactory {

    public static Service getServiceByUrl(String url) {
        Service service;

        switch (url) {
            //admin模块

            //管理员登录
            case "/admin_login":
                service = AdminLogin.newService();
                break;
            //管理员注册
            case "/admin_register":
                service = AdminRegister.newService();
                break;

            //user模块

            //用户登录
            case "/user_login":
                service = UserLogin.newService();
                break;
            //用户注册
            case "/user_register":
                service = UserRegister.newService();
                break;
            //用户修改密码
            case "/user_password_update":
                service = UserPswUpdate.newService();
                break;

            //user_property模块

            //用户资料更新
            case "/user_property_update":
                service = UserPropertyUpdate.newService();
                break;
            //用户头像更新
            case "/user_icon_update":
                service = UserIconUpdate.newService();
                break;
            //用户资料查询
            case "/user_property_query":
                service = UserPropertyQuery.newService();
                break;

            //image模块

            //image上传
            case "/image_upload":
                service = ImageUpload.newService();
                break;
            //image删除
            case "/image_delete":
                service = ImageDelete.newService();
                break;
            //image文本更新
            case "/image_text_update":
                service = ImageTextUpdate.newService();
                break;
            //image单个获取
            case "/image_query":
                service = ImageQuery.newService();
                break;
            //image数据集获取
            case "/image_list_query":
                service = ImageListQuery.newService();
                break;
            //image分类命令
            case "/image_classify":
                service = ImageClassify.newService();
                break;
            //image分类数据获取
            case "/image_class_query":
                service = ImageClassQuery.newService();
                break;

            //diary模块

            //diary上传
            case "/diary_upload":
                service = DiaryUpload.newService();
                break;
            //diary删除
            case "/diary_delete":
                service = DiaryDelete.newService();
                break;
            //diary更新
            case "/diary_update":
                service = DiaryUpdate.newService();
                break;
            //diary获取
            case "/diary_list_query":
                service = DiaryListQuery.newService();
                break;

            default:
                service = null;
        }
        return service;
    }
}
