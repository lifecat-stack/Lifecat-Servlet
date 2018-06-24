package com.wang.service.util;

import com.wang.service.*;

/**
 * ServiceFactory :
 * <p>
 * 返回相应的service对象
 *
 * @auther ten
 */
public interface ServiceFactory {

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
                service = AdminRegisterService.newService();
                break;

            //user模块

            //用户登录
            case "/user_login":
                service = UserLoginService.newService();
                break;
            //用户注册
            case "/user_register":
                service = UserRegisterService.newService();
                break;
            //用户修改密码
            case "/user_password_update":
                service = UserPswUpdateService.newService();
                break;

            //user_property模块

            //用户资料更新
            case "/user_property_update":
                service = UserPropertyUpdateService.newService();
                break;
            //用户头像更新
            case "/user_icon_update":
                service = UserIconUpdateService.newService();
                break;
            //用户资料查询
            case "/user_property_query":
                service = UserPropertyQueryService.newService();
                break;

            //image模块

            //image上传
            case "/image_upload":
                service = ImageUploadService.newService();
                break;
            //image删除
            case "/image_delete":
                service = ImageDeleteService.newService();
                break;
            //image文本更新
            case "/image_text_update":
                service = ImageTextUpdateService.newService();
                break;
            //image单个获取
            case "/image_query":
                service = ImageQueryService.newService();
                break;
            //image数据集获取
            case "/image_list_query":
                service = ImageListQueryService.newService();
                break;
            //image分类命令
            case "/image_classify":
                service = ImageClassifyService.newService();
                break;
            //image分类数据获取
            case "/image_class_query":
                service = ImageClassQueryService.newService();
                break;

            //diary模块

            //diary上传
            case "/diary_upload":
                service = DiaryUploadService.newService();
                break;
            //diary删除
            case "/diary_delete":
                service = DiaryDeleteService.newService();
                break;
            //diary更新
            case "/diary_update":
                service = DiaryUpdateService.newService();
                break;
            //diary获取
            case "/diary_list_query":
                service = DiaryListQueryService.newService();
                break;

            default:
                service = null;
        }
        return service;
    }
}
