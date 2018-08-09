package com.ten.bean.entity;

/**
 * DO :user_icon
 *
 * @auther ten
 */
public class UserIconDO {

    private Integer userId;
    private String iconPath;
    private String iconGmtCreate;
    private String iconGmtModified;

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

    /**
     * @return UserIconDO@1234{UserID:'',Path:'',Create:'',Modified:''}
     */
    @Override
    public String toString() {
        return "UserIconDO@" + userId
                + "{UserID:" + userId
                + ",Path:" + iconPath
                + ",Create:" + iconGmtCreate
                + ",Modified:" + iconGmtModified
                + "}";
    }
}


