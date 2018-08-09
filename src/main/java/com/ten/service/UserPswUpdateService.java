package com.ten.service;

import com.ten.bean.entity.UserDO;
import com.ten.service.util.Service;

/**
 * 更新用户密码
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserPswUpdateService extends Service {
    void updateUserPassword(UserDO userDO);
}

