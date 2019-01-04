package com.ten.lifecat.servlet.service;

import com.ten.lifecat.servlet.entity.UserProperty;
import com.ten.lifecat.servlet.service.util.Service;
import com.ten.service.util.Service;

/**
 * 用户资料更新
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserPropertyUpdateService extends Service {

    void updateUserProperty(UserProperty userProperty);
}