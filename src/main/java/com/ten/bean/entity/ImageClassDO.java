package com.ten.bean.entity;

/**
 * DO :image_class
 *
 * @auther ten
 */
public class ImageClassDO {

    private Integer imageClassId;
    private String imageClassName;
    private String imageClassDesc;
    private String classGmtCreate;
    private String classGmtModified;

    public Integer getImageClassId() {
        return imageClassId;
    }

    public void setImageClassId(Integer imageClassId) {
        this.imageClassId = imageClassId;
    }

    public String getImageClassName() {
        return imageClassName;
    }

    public void setImageClassName(String imageClassName) {
        this.imageClassName = imageClassName;
    }

    public String getImageClassDesc() {
        return imageClassDesc;
    }

    public void setImageClassDesc(String imageClassDesc) {
        this.imageClassDesc = imageClassDesc;
    }

    public String getClassGmtCreate() {
        return classGmtCreate;
    }

    public void setClassGmtCreate(String classGmtCreate) {
        this.classGmtCreate = classGmtCreate;
    }

    public String getClassGmtModified() {
        return classGmtModified;
    }

    public void setClassGmtModified(String classGmtModified) {
        this.classGmtModified = classGmtModified;
    }
}
