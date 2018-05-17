package com.wang.doo;

/**
 * DO :image_type
 *
 * @auther ten
 */
public class ImageTypeDO {

    private int image_id;
    private int user_id;
    private int image_class;
    private String type_gmt_create;
    private String type_gmt_modified;

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getImage_class() {
        return image_class;
    }

    public void setImage_class(int image_class) {
        this.image_class = image_class;
    }

    public String getType_gmt_create() {
        return type_gmt_create;
    }

    public void setType_gmt_create(String type_gmt_create) {
        this.type_gmt_create = type_gmt_create;
    }

    public String getType_gmt_modified() {
        return type_gmt_modified;
    }

    public void setType_gmt_modified(String type_gmt_modified) {
        this.type_gmt_modified = type_gmt_modified;
    }
}
