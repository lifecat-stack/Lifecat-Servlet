//package com.wang.manager;
//
///**
// * ManagerFactory :
// *
// * 由Service调用, 根据Manager名称, 返回Manager对象
// * @auther ten
// */
//public class ManagerFactory {
//
//    public static Manager getManagerByName(String name) {
//
//        Manager manager;
//
//        switch (name) {
//            case "AdminManager":
//                manager = UserManager.getUserModel(userid);
//                break;
//            case "UserManager":
//                manager = UserManager.getUserModel(userid);
//                break;
//            case "UserPropertyManager":
//                manager = UserManager.getUserModel(userid);
//                break;
//            case "UserIconManager":
//                manager = UserManager.getUserModel(userid);
//                break;
//            case "ImageManager":
//                manager = UserManager.getUserModel(userid);
//                break;
//            case "ImageTypeManager":
//                manager = UserManager.getUserModel(userid);
//                break;
//            default:
//                manager = null;
//        }
//
//        return manager;
//    }
//}
