package com.wang.service;

import com.wang.bean.doo.UserDO;
import com.wang.service.util.Service;

/**
 * 用户注册
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserRegisterService extends Service {

    boolean isUserExisted(String userName);

    void insertUserToDatabase(UserDO userDO);
}