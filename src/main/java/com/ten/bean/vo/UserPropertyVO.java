package com.ten.bean.vo;

/**
 * DTO :UserProperty用户个人资料
 * <p>
 * 构建可变属性集，设置了默认参数
 *
 * @auther ten
 */
public class UserPropertyVO {

    private Integer userId;
    private String nickname;
    private String signature;
    private String email;
    private String sex;
    private String location;
    private String birthday;
    private String iconPath;

    public UserPropertyVO(Integer userId) {
        this.userId = userId;
    }

    public UserPropertyVO nickname(String val) {
        this.nickname = val;
        return this;
    }

    public UserPropertyVO signature(String val) {
        this.signature = val;
        return this;
    }

    public UserPropertyVO email(String val) {
        this.email = val;
        return this;
    }

    public UserPropertyVO sex(String val) {
        this.sex = val;
        return this;
    }

    public UserPropertyVO location(String val) {
        this.location = val;
        return this;
    }

    public UserPropertyVO birthday(String val) {
        this.birthday = val;
        return this;
    }

    public UserPropertyVO iconPath(String val) {
        this.iconPath = val;
        return this;
    }

    /**
     * UserProperty@1234{nickname:'',signature:'',email:'',sex:'',location:'',birthday:'',iconPath:''}
     */
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

    /**
     * getter
     */
    public Integer getUserId() {
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
