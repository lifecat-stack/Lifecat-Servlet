package com.ten.manager;

import com.ten.bean.entity.UserDO;
import com.ten.bean.entity.UserIconDO;
import com.ten.bean.entity.UserPropertyDO;
import com.ten.bean.vo.UserPropertyVO;
import com.ten.bean.vo.UserVO;

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
     * @return UserVO UserVO
     * @throws
     */
    public UserVO userLogin(UserDO userDO);

    /**
     * 用户注册
     *
     * @param userDO 用户名+用户密码
     * @return UserVO UserVO
     * @throws
     */
    public UserVO userRegister(UserDO userDO);

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
     * @return UserPropertyVO UserPropertyVO
     * @throws
     */
    public UserPropertyVO userPropertyQuery(int userId);

}
