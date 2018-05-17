package com.wang.doo;

/**
 * DO :user_property
 *
 * @auther ten
 */
public class UserPropertyDO {

    private int user_id;
    private String property_nickname;
    private String property_signature;
    private String property_email;
    private String property_Location;
    private String property_birthday;
    private String property_gmt_create;
    private String property_gmt_modified;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getProperty_nickname() {
        return property_nickname;
    }

    public void setProperty_nickname(String property_nickname) {
        this.property_nickname = property_nickname;
    }

    public String getProperty_signature() {
        return property_signature;
    }

    public void setProperty_signature(String property_signature) {
        this.property_signature = property_signature;
    }

    public String getProperty_email() {
        return property_email;
    }

    public void setProperty_email(String property_email) {
        this.property_email = property_email;
    }

    public String getProperty_Location() {
        return property_Location;
    }

    public void setProperty_Location(String property_Location) {
        this.property_Location = property_Location;
    }

    public String getProperty_birthday() {
        return property_birthday;
    }

    public void setProperty_birthday(String property_birthday) {
        this.property_birthday = property_birthday;
    }

    public String getProperty_gmt_create() {
        return property_gmt_create;
    }

    public void setProperty_gmt_create(String property_gmt_create) {
        this.property_gmt_create = property_gmt_create;
    }

    public String getProperty_gmt_modified() {
        return property_gmt_modified;
    }

    public void setProperty_gmt_modified(String property_gmt_modified) {
        this.property_gmt_modified = property_gmt_modified;
    }
}
