package com.ten.service;

import com.ten.service.util.Service;

/**
 * 更新用户密码
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserPswUpdateService extends Service {
    void updateUserPassword(int userId, String newpassword);
}

