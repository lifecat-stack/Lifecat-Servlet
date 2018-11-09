package com.ten.bean.entity;

/**
 * user_icon
 *
 * @auther ten
 */
public class UserIcon {

    private Integer userId;
    private String iconPath;
    private String iconGmtCreate;
    private String iconGmtModified;

    @Override
    public String toString() {
        return "UserIcon@"
                + "{UserID:" + userId
                + ",Path:" + iconPath
                + ",Create:" + iconGmtCreate
                + ",Modified:" + iconGmtModified
                + "}";
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getIconGmtCreate() {
        return iconGmtCreate;
    }

    public void setIconGmtCreate(String iconGmtCreate) {
        this.iconGmtCreate = iconGmtCreate;
    }

    public String getIconGmtModified() {
        return iconGmtModified;
    }

    public void setIconGmtModified(String iconGmtModified) {
        this.iconGmtModified = iconGmtModified;
    }
}


