package com.ten.service;

import com.ten.bean.entity.UserProperty;
import com.ten.service.util.Service;

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
    UserProperty queryUserProperty(int userId);

    String  queryUserIcon(int userId);
}