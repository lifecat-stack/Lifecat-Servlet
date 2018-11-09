package com.ten.bean.entity;

/**
 * admin
 *
 * @auther ten
 */
public class Admin {

    private Integer adminId;
    private String adminName;
    private String adminPassword;
    private String adminLevel;
    private String adminGmtCreate;
    private String adminGmtModified;

    @Override
    public String toString() {
        return "Admin@"
                + "{ID:" + adminId
                + ",Name:" + adminName
                + ",Password:" + adminPassword
                + ",Level:" + adminLevel
                + ",Create:" + adminGmtCreate
                + ",Modified:" + adminGmtModified
                + "}";
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }

    public String getAdminGmtCreate() {
        return adminGmtCreate;
    }

    public void setAdminGmtCreate(String adminGmtCreate) {
        this.adminGmtCreate = adminGmtCreate;
    }

    public String getAdminGmtModified() {
        return adminGmtModified;
    }

    public void setAdminGmtModified(String adminGmtModified) {
        this.adminGmtModified = adminGmtModified;
    }
}
