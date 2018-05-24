package com.wang.bean.dto;


import com.wang.bean.MyBuilder;

/**
 * DTO :User用户账号
 * <p>
 * 覆盖equals() hashCode()
 *
 * @auther ten
 */
public class UserDTO {


    private final int userId;
    private final String userName;

    /**
     * hashCode缓存
     */
    private volatile int hashCode;

    private UserDTO(UserDTO.Builder builder) {
        userId = builder.userId;
        userName = builder.userName;
    }

    public static class Builder implements MyBuilder<UserDTO> {

        private final int userId;
        private final String userName;

        public Builder(int user_id, String user_name) {
            this.userId = user_id;
            this.userName = user_name;
        }

        @Override
        public UserDTO build() {
            return new UserDTO(this);
        }
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
        if (this.userId != ((UserDTO) obj).getUserId()) {
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

    //User@1234{wang}
    @Override
    public String toString() {
        return "User@" + userId + "{" + userName + "}";
    }

    //getter方法
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
