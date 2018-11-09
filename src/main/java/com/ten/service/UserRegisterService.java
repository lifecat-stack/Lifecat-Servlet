package com.ten.service;

import com.ten.bean.entity.User;
import com.ten.service.util.Service;

/**
 * 用户注册
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserRegisterService extends Service {

    boolean isUserExisted(String userName);

    int insertUserToDatabase(User user);
}