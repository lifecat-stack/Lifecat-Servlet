package com.ten.lifecat.servlet.service;

import com.ten.lifecat.servlet.entity.User;
import com.ten.lifecat.servlet.service.util.Service;

/**
 * 用户登录
 * <p>
 * 失败 Page.PAGE_INDEX
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserLoginService extends Service {
    /**
     * 查询账号是否存在
     *
     * @param
     * @throws
     */
    boolean isUserExisted(String userName);

    /**
     * 查询用户信息
     *
     * @param
     * @throws
     */
    User queryUserByName(String userName);
}

