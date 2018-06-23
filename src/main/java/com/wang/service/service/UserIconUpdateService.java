package com.wang.service.service;

import com.wang.bean.doo.UserIconDO;
import com.wang.service.Service;

/**
 * 用户头像上传
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface UserIconUpdateService extends Service {
    void updateUserIcon(UserIconDO userIconDO);
}
