package com.ten.service;

import com.ten.bean.entity.UserIconDO;
import com.ten.service.util.Service;

import javax.servlet.http.HttpServletRequest;

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

    void writeUserIcon(HttpServletRequest req);
}
