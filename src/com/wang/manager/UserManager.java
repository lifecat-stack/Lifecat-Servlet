package com.wang.manager;

import com.wang.bean.User;

import java.sql.SQLException;

/**
 * UserManager: user表逻辑操作
 * <p>
 * 访问范围: 全局
 * 调用者: Service
 * 异常检测: 确保DAO参数无差错
 * <p>
 * 1. 查询user queryUser(user_id)
 * 2. 注册user insertUser(User)
 * 3. 更新user密码 updateUserPsw(password)
 * 4. 判断用户名是否存在 isUserNameExited(user_id)
 *
 * @auther ten
 */
public class UserManager implements Manager {

    private UserManager() {}

    static Manager getUserModel() {
        return new UserManager();
    }

    /**
     * 查询user
     *
     * @return user 数据库返回User对象
     * @throws SQLException         queryUser()异常
     * @throws NullPointerException 数据库查询为空
     */
    public User queryUser() throws SQLException {
        logger.info("queryUserMsg()");

        return dao.queryUser(userid);
    }

    /**
     * 插入user
     *
     * @throws SQLException             insertUser()异常
     * @throws IllegalArgumentException user属性为空
     */
    public void insertUser(User user) throws SQLException {
        logger.info("inserUser()");

        final boolean isNull = user.getName() == null || user.getPassword() == null || user.getLevel() == null;

        if (isNull) {
            throw new IllegalArgumentException("user argument is null");
        }

        dao.insertUser(user);
    }

    /**
     * 更新密码
     *
     * @param oldpassword oldpassword
     * @param newpassword newpassword
     * @throws SQLException             SQL异常
     * @throws IllegalArgumentException 原密码错误
     */
    public void updateUserPsw(String oldpassword, String newpassword) throws SQLException {
        logger.info("updateUserPsw()");

        String old = dao.queryUserPsw(userid);

        if (!oldpassword.equals(old)) {
            throw new IllegalArgumentException("原密码错误");
        }

        dao.updateUserPsw(userid, newpassword);
    }

    /**
     * 判断用户名是否存在 isUserNameExited(user_id)
     *
     * @throws SQLException             SQL异常
     */
    public boolean isUserNameExited() throws SQLException {
        logger.info("isUserNameExited()");

        String name = dao.queryUserName(userid);

        return name != null;
    }
}
