package com.wang.doo;

/**
 * DO :image
 *
 * @auther ten
 */
public class ImageDO {

    private int image_id;
    private int user_id;
    private String image_text;
    private String image_path;
    private String is_deleted;
    private String image_gmt_create;
    private String image_gmt_modified;

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

    public String getImage_text() {
        return image_text;
    }

    public void setImage_text(String image_text) {
        this.image_text = image_text;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getImage_gmt_create() {
        return image_gmt_create;
    }

    public void setImage_gmt_create(String image_gmt_create) {
        this.image_gmt_create = image_gmt_create;
    }

    public String getImage_gmt_modified() {
        return image_gmt_modified;
    }

    public void setImage_gmt_modified(String image_gmt_modified) {
        this.image_gmt_modified = image_gmt_modified;
    }
}
