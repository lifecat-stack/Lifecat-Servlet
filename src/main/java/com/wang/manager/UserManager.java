package com.wang.manager;

import com.wang.bean.doo.UserDO;
import com.wang.bean.doo.UserIconDO;
import com.wang.bean.doo.UserPropertyDO;
import com.wang.bean.dto.UserDTO;
import com.wang.bean.dto.UserPropertyDTO;

/**
 * User模块管理器
 *
 * @date 2018/6/29
 * @auther ten
 */
public interface UserManager extends Manager {
    /**
     * 用户登录
     *
     * @param userDO UserDO
     * @return UserDTO UserDTO
     * @throws
     */
    public UserDTO userLogin(UserDO userDO);

    /**
     * 用户注册
     *
     * @param userDO 用户名+用户密码
     * @return UserDTO UserDTO
     * @throws
     */
    public UserDTO userRegister(UserDO userDO);

    /**
     * 用户更新信息
     *
     * @param
     * @throws
     */
    public void userPropertyUpdate(UserPropertyDO userPropertyDO);

    /**
     * 用户更新密码
     *
     * @param
     * @throws
     */
    public void userPswUpdate(UserDO userDO);

    /**
     * 用户更新头像
     *
     * @param
     * @throws
     */
    public void userIconUpdate(UserIconDO userIconDO);

    /**
     * 用户资料查询
     *
     * @param
     * @return UserPropertyDTO UserPropertyDTO
     * @throws
     */
    public UserPropertyDTO userPropertyQuery(int userId);

}
