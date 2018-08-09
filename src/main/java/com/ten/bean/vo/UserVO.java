package com.ten.bean.vo;


/**
 * DTO :User用户账号
 * <p>
 * 覆盖equals() hashCode()
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
        //引用检测
        if (obj == this) {
            return true;
        }
        //类型检测
        if (!(obj instanceof UserVO)) {
            return false;
        }
        //参数检测
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

    /**
     * User@1234{wang}
     */
    @Override
    public String toString() {
        return "User@" + userId + "{" + userName + "}";
    }

    /**
     * getter方法
     */
    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
