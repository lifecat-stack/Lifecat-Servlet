package com.wang.dto;

import com.wang.constant.HOST;
import com.wang.util.MyBuilder;

/**
 * DTO :UserProperty用户个人资料
 * <p>
 * 构建可变属性集，设置了默认参数
 *
 * @auther ten
 */
public class UserPropertyDTO {

    private final int userId;
    private String nickname;
    private String signature;
    private String email;
    private String sex;
    private String location;
    private String birthday;
    private String iconPath;

    private UserPropertyDTO(UserPropertyDTO.Builder builder) {
        userId = builder.userId;
        nickname = builder.nickname;
        signature = builder.signature;
        email = builder.email;
        sex = builder.sex;
        location = builder.location;
        birthday = builder.birthday;
        iconPath = builder.iconPath;
    }

    public static class Builder implements MyBuilder<UserPropertyDTO> {
        //NOT NULL
        private final int userId;

        private String nickname = "lifecat";
        private String signature = "记录成长的感动";
        private String email = "lifecat@gmail.com";
        private String sex = "lovely";
        private String location = "无锡, 中国";
        private String birthday = "2018-01-01";
        private String iconPath = HOST.IMAGE_PATH;

        public Builder(int user_id) {
            this.userId = user_id;
        }

        public UserPropertyDTO.Builder nickname(String val) {
            nickname = val;
            return this;
        }

        public UserPropertyDTO.Builder signature(String val) {
            signature = val;
            return this;
        }

        public UserPropertyDTO.Builder email(String val) {
            email = val;
            return this;
        }

        public UserPropertyDTO.Builder sex(String val) {
            sex = val;
            return this;
        }

        public UserPropertyDTO.Builder location(String val) {
            location = val;
            return this;
        }

        public UserPropertyDTO.Builder birthday(String val) {
            birthday = val;
            return this;
        }

        public UserPropertyDTO.Builder iconPath(String val) {
            iconPath = val;
            return this;
        }

        @Override
        public UserPropertyDTO build() {
            return new UserPropertyDTO(this);
        }
    }

    //UserProperty@1234{nickname:'',signature:'',email:'',sex:'',location:'',birthday:'',iconPath:''}
    @Override
    public String toString() {
        return "UserProperty@" + userId + "{"
                + "nickname:" + nickname + ","
                + "signature" + signature + ","
                + "email" + email + ","
                + "sex" + sex + ","
                + "location" + location + ","
                + "birthday" + birthday + ","
                + "iconPath" + iconPath + "}";
    }

    //getter
    public int getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSignature() {
        return signature;
    }

    public String getEmail() {
        return email;
    }

    public String getSex() {
        return sex;
    }

    public String getLocation() {
        return location;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getIconPath() {
        return iconPath;
    }
}
