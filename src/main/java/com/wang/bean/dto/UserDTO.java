package com.wang.bean.dto;


/**
 * DTO :User用户账号
 * <p>
 * 覆盖equals() hashCode()
 *
 * @auther ten
 */
public class UserDTO {

    private Integer userId;
    private String userName;

    /**
     * hashCode缓存
     */
    private volatile int hashCode;

    public UserDTO(Integer userId, String userName) {
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
        if (!(obj instanceof UserDTO)) {
            return false;
        }
        //参数检测
        if (!this.userId.equals(((UserDTO) obj).getUserId())) {
            return false;
        }
        if (!this.userName.equals(((UserDTO) obj).getUserName())) {
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
