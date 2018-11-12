package com.ten.bean.entity;

/**
 * image_class
 *
 * @auther ten
 */
public class ImageClass {

    private Integer id;
    private String imageClassName;
    private String imageClassDesc;
    private String createTime;
    private String updateTime;

    @Override
    public String toString() {
        return super.toString();
    }

    public Integer getId() {
        return id;
    }

    public ImageClass setId(Integer id) {
        this.id = id;return this;
    }

    public String getImageClassName() {
        return imageClassName;
    }

    public ImageClass setImageClassName(String imageClassName) {
        this.imageClassName = imageClassName;return this;
    }

    public String getImageClassDesc() {
        return imageClassDesc;
    }

    public ImageClass setImageClassDesc(String imageClassDesc) {
        this.imageClassDesc = imageClassDesc;return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public ImageClass setCreateTime(String createTime) {
        this.createTime = createTime;return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public ImageClass setUpdateTime(String updateTime) {
        this.updateTime = updateTime;return this;
    }
}
