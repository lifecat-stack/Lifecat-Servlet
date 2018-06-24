package com.wang.service.impl;

import com.wang.service.util.Service;
import com.wang.service.util.ServiceMaker;

/**
 * ServiceFactory :
 * <p>
 * 返回相应的service对象
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
                service = ServiceMaker.newService();
                break;
            //管理员注册
            case "/admin_register":
                service = AdminRegisterServiceImpl.newService();
                break;

            //user模块

            //用户登录
            case "/user_login":
                service = UserLoginServiceImpl.newService();
                break;
            //用户注册
            case "/user_register":
                service = UserRegisterServiceImpl.newService();
                break;
            //用户修改密码
            case "/user_password_update":
                service = UserPswUpdateServiceImpl.newService();
                break;

            //user_property模块

            //用户资料更新
            case "/user_property_update":
                service = UserPropertyUpdateServiceImpl.newService();
                break;
            //用户头像更新
            case "/user_icon_update":
                service = UserIconUpdateServiceImpl.newService();
                break;
            //用户资料查询
            case "/user_property_query":
                service = UserPropertyQueryServiceImpl.newService();
                break;

            //image模块

            //image上传
            case "/image_upload":
                service = ImageUploadServiceImpl.newService();
                break;
            //image删除
            case "/image_delete":
                service = ImageDeleteServiceImpl.newService();
                break;
            //image文本更新
            case "/image_text_update":
                service = ImageTextUpdateServiceImpl.newService();
                break;
            //image单个获取
            case "/image_query":
                service = ImageQueryServiceImpl.newService();
                break;
            //image数据集获取
            case "/image_list_query":
                service = ImageListQueryServiceImpl.newService();
                break;
            //image分类命令
            case "/image_classify":
                service = ImageClassifyServiceImpl.newService();
                break;
            //image分类数据获取
            case "/image_class_query":
                service = ImageClassQueryServiceImpl.newService();
                break;

            //diary模块

            //diary上传
            case "/diary_upload":
                service = DiaryUploadServiceImpl.newService();
                break;
            //diary删除
            case "/diary_delete":
                service = DiaryDeleteServiceImpl.newService();
                break;
            //diary更新
            case "/diary_update":
                service = DiaryUpdateServiceImpl.newService();
                break;
            //diary获取
            case "/diary_list_query":
                service = DiaryListQueryServiceImpl.newService();
                break;

            default:
                service = null;
        }
        return service;
    }
}
