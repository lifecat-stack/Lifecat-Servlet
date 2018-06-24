package com.wang.service;

import com.wang.bean.doo.UserPropertyDO;
import com.wang.service.util.Service;

/**
 * 查询用户资料
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserPropertyQueryService extends Service {
    UserPropertyDO queryUserProperty(int userId);
}