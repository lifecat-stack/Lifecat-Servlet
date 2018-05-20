package com.wang.doo;

/**
 * DO :user
 *
 * @auther ten
 */
public class UserDO {

    private int user_id;
    private String user_name;
    private String user_password;
    private String user_gmt_create;
    private String user_gmt_modified;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_gmt_create() {
        return user_gmt_create;
    }

    public void setUser_gmt_create(String user_gmt_create) {
        this.user_gmt_create = user_gmt_create;
    }

    public String getUser_gmt_modified() {
        return user_gmt_modified;
    }

    public void setUser_gmt_modified(String user_gmt_modified) {
        this.user_gmt_modified = user_gmt_modified;
    }
}
