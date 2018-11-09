package com.ten.bean.vo;


/**
 * User用户账号
 *
 * @auther ten
 */
public class UserVO {

    private Integer userId;
    private String userName;

    /**
     * hashCode缓存
     */
    private volatile int hashCode;

    public UserVO(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserVO)) {
            return false;
        }
        if (!this.userId.equals(((UserVO) obj).getUserId())) {
            return false;
        }
        if (!this.userName.equals(((UserVO) obj).getUserName())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + userId;
            result = 31 * result + userName.hashCode();
            hashCode = result;
        }
        return result;
    }

    @Override
    public String toString() {
        return "User@" + "{" + userName + "}";
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
