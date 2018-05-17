package com.wang.doo;

/**
 * DO :image_feature
 *
 * @auther ten
 */
public class ImageFeatureDO {

    private int image_id;
    private int image_class;
    private String image_feature_path;
    private String feature_gmt_create;
    private String feature_gmt_modified;

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public int getImage_class() {
        return image_class;
    }

    public void setImage_class(int image_class) {
        this.image_class = image_class;
    }

    public String getImage_feature_path() {
        return image_feature_path;
    }

    public void setImage_feature_path(String image_feature_path) {
        this.image_feature_path = image_feature_path;
    }

    public String getFeature_gmt_create() {
        return feature_gmt_create;
    }

    public void setFeature_gmt_create(String feature_gmt_create) {
        this.feature_gmt_create = feature_gmt_create;
    }

    public String getFeature_gmt_modified() {
        return feature_gmt_modified;
    }

    public void setFeature_gmt_modified(String feature_gmt_modified) {
        this.feature_gmt_modified = feature_gmt_modified;
    }
}
