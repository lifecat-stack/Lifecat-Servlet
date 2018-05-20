package com.wang.doo;

/**
 * DO :image_class
 *
 * @auther ten
 */
public class ImageClassDO {

    private int image_class_id;
    private String image_class_name;
    private String image_class_desc;
    private String class_gmt_create;
    private String class_gmt_modified;

    public int getImage_class_id() {
        return image_class_id;
    }

    public void setImage_class_id(int image_class_id) {
        this.image_class_id = image_class_id;
    }

    public String getImage_class_name() {
        return image_class_name;
    }

    public void setImage_class_name(String image_class_name) {
        this.image_class_name = image_class_name;
    }

    public String getImage_class_desc() {
        return image_class_desc;
    }

    public void setImage_class_desc(String image_class_desc) {
        this.image_class_desc = image_class_desc;
    }

    public String getClass_gmt_create() {
        return class_gmt_create;
    }

    public void setClass_gmt_create(String class_gmt_create) {
        this.class_gmt_create = class_gmt_create;
    }

    public String getClass_gmt_modified() {
        return class_gmt_modified;
    }

    public void setClass_gmt_modified(String class_gmt_modified) {
        this.class_gmt_modified = class_gmt_modified;
    }
}
