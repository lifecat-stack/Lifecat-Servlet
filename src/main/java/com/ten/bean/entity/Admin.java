package com.ten.bean.entity;

public class Admin {

    private Integer id;
    private String adminName;
    private String adminPassword;
    private String adminLevel;
    private String createTime;
    private String updateTime;
    private Integer isDeleted;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminLevel='" + adminLevel + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public String getAdminName() {
        return adminName;
    }

    public Admin setAdminName(String adminName) {
        this.adminName = adminName;
        return this;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public Admin setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
        return this;
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public Admin setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Admin setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public Admin setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Admin setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public Admin setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }
}
