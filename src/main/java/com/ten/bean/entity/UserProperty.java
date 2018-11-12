package com.ten.bean.entity;

public class UserProperty {

    private Integer id;
    private Integer userId;
    private String userName;
    private String nickname;
    private String signature;
    private String sex;
    private String email;
    private String location;
    private String birthday;
    private String createTime;
    private String updateTime;
    private Integer isDeleted;

    @Override
    public String toString() {
        return "UserProperty@{"
                + "id:" + id
                + ",userId:" + userId
                + ",userName:" + userName
                + ",nickname:" + nickname
                + ",signature:" + signature
                + ",sex:" + sex
                + ",email:" + email
                + ",location:" + location
                + ",birthday:" + birthday
                + ",createTime:" + createTime
                + ",updateTime:" + updateTime
                + "}";
    }

    public Integer getId() {
        return id;
    }

    public UserProperty setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserProperty setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public UserProperty setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public UserProperty setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public UserProperty setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public UserProperty setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public UserProperty setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserProperty setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public UserProperty setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public UserProperty setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public UserProperty setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public UserProperty setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
