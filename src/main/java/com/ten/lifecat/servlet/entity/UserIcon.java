package com.ten.lifecat.servlet.entity;

public class UserIcon {

    private Integer id;
    private Integer userId;
    private String iconPath;
    private String createTime;
    private String updateTime;
    private Integer isDeleted;

    @Override
    public String toString() {
        return "UserIcon{" +
                "id=" + id +
                ", userId=" + userId +
                ", iconPath='" + iconPath + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public UserIcon setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public UserIcon setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public UserIcon setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getIconPath() {
        return iconPath;
    }

    public UserIcon setIconPath(String iconPath) {
        this.iconPath = iconPath;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public UserIcon setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public UserIcon setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}


