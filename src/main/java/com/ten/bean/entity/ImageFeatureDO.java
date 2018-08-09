package com.ten.bean.entity;

/**
 * DO :image_feature
 *
 * @auther ten
 */
public class ImageFeatureDO {

    private Integer imageId;
    private Integer imageClass;
    private String imageFeaturePath;
    private String featureGmtCreate;
    private String featureGmtModified;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getImageClass() {
        return imageClass;
    }

    public void setImageClass(Integer imageClass) {
        this.imageClass = imageClass;
    }

    public String getImageFeaturePath() {
        return imageFeaturePath;
    }

    public void setImageFeaturePath(String imageFeaturePath) {
        this.imageFeaturePath = imageFeaturePath;
    }

    public String getFeatureGmtCreate() {
        return featureGmtCreate;
    }

    public void setFeatureGmtCreate(String featureGmtCreate) {
        this.featureGmtCreate = featureGmtCreate;
    }

    public String getFeatureGmtModified() {
        return featureGmtModified;
    }

    public void setFeatureGmtModified(String featureGmtModified) {
        this.featureGmtModified = featureGmtModified;
    }
}
