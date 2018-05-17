package com.wang.service;

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
                service = UserLogin.getModel();
                break;
            //管理员注册
            case "/admin_register":
                service = UserRegister.getModel();
                break;

            //user模块

            //用户登录
            case "/user_login":
                service = UserPswUpdate.getModel();
                break;
            //用户注册
            case "/user_register":
                service = UserPropertyUpdate.getModel();
                break;
            //用户修改密码
            case "/user_password_update":
                service = UserPropertyUpdate.getModel();
                break;

            //user_property模块

            //用户资料更新
            case "/user_property_update":
                service = DiaryUpload.getModel();
                break;
            //用户头像更新
            case "/user_icon_update":
                service = DiaryUpload.getModel();
                break;
            //用户资料查询
            case "/user_property_query":
                service = DiaryUpload.getModel();
                break;

            //image模块

            //image上传
            case "/image_upload":
                service = DiaryUpload.getModel();
                break;
            //image删除
            case "/image_delete":
                service = DiaryUpload.getModel();
                break;
            //image文本更新
            case "/image_text_update":
                service = DiaryUpload.getModel();
                break;
            //image单个获取
            case "/image_query":
                service = DiaryUpload.getModel();
                break;
            //image数据集获取
            case "/image_list_query":
                service = DiaryUpload.getModel();
                break;
            //image分类命令
            case "/image_classify":
                service = DiaryUpload.getModel();
                break;
            //image分类数据获取
            case "/image_class_query":
                service = DiaryUpload.getModel();
                break;

            //diary模块

            //diary上传
            case "/diary_upload":
                service = DiaryUpload.getModel();
                break;
            //diary删除
            case "/diary_delete":
                service = DiaryUpload.getModel();
                break;
            //diary更新
            case "/diary_update":
                service = DiaryUpload.getModel();
                break;
            //diary获取
            case "/diary_list_query":
                service = DiaryUpload.getModel();
                break;

            default:
                service = null;
        }
        return service;
    }
}
