package com.wang.DO;

/**
 * DO :user_icon
 *
 * @auther ten
 */
public class UserIconDO {

    private int user_id;
    private String icon_path;
    private String icon_gmt_create;
    private String icon_gmt_modified;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getIcon_path() {
        return icon_path;
    }

    public void setIcon_path(String icon_path) {
        this.icon_path = icon_path;
    }

    public String getIcon_gmt_create() {
        return icon_gmt_create;
    }

    public void setIcon_gmt_create(String icon_gmt_create) {
        this.icon_gmt_create = icon_gmt_create;
    }

    public String getIcon_gmt_modified() {
        return icon_gmt_modified;
    }

    public void setIcon_gmt_modified(String icon_gmt_modified) {
        this.icon_gmt_modified = icon_gmt_modified;
    }
}
