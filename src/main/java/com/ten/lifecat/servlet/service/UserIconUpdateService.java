package com.ten.lifecat.servlet.service;

import com.ten.lifecat.servlet.entity.UserIcon;
import com.ten.lifecat.servlet.service.util.Service;

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

    void updateUserIcon(UserIcon userIcon);

    void writeUserIcon(HttpServletRequest req);
}
