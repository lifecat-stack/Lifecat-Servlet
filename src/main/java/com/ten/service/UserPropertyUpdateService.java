package com.ten.service;

import com.ten.bean.entity.UserPropertyDO;
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

    void updateUserProperty(UserPropertyDO userPropertyDO);
}