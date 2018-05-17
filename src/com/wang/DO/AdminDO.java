package com.wang.DO;

/**
 * DO :admin
 *
 * @auther ten
 */
public class AdminDO {

    private int admin_id;
    private String admin_name;
    private String admin_password;
    private String admin_level;
    private String admin_gmt_create;
    private String admin_gmt_modified;

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_level() {
        return admin_level;
    }

    public void setAdmin_level(String admin_level) {
        this.admin_level = admin_level;
    }

    public String getAdmin_gmt_create() {
        return admin_gmt_create;
    }

    public void setAdmin_gmt_create(String admin_gmt_create) {
        this.admin_gmt_create = admin_gmt_create;
    }

    public String getAdmin_gmt_modified() {
        return admin_gmt_modified;
    }

    public void setAdmin_gmt_modified(String admin_gmt_modified) {
        this.admin_gmt_modified = admin_gmt_modified;
    }
}
