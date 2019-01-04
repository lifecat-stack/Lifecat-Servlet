package com.ten.lifecat.servlet.service;

import com.ten.lifecat.servlet.entity.User;
import com.ten.lifecat.servlet.service.util.Service;
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