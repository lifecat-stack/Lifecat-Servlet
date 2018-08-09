package com.ten.bean.entity;

/**
 * DO :image
 *
 * @auther ten
 */
public class ImageDO {

    private Integer imageId;
    private Integer userId;
    private Integer classId;
    private String imageText;
    private String imagePath;
    private Integer deleted;
    private String imageGmtCreate;
    private String imageGmtModified;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getImageText() {
        return imageText;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getImageGmtCreate() {
        return imageGmtCreate;
    }

    public void setImageGmtCreate(String imageGmtCreate) {
        this.imageGmtCreate = imageGmtCreate;
    }

    public String getImageGmtModified() {
        return imageGmtModified;
    }

    public void setImageGmtModified(String imageGmtModified) {
        this.imageGmtModified = imageGmtModified;
    }

    /**
     * @return ImageDO@1234{ImageID:'',UserID:'',ClassID:'',Text:'',Path:'',isDeleted:'',Create:'',Modified:''}
     */
    @Override
    public String toString() {
        return "ImageDO@" + imageId
                + "{ImageID:" + imageId
                + ",UserID:" + userId
                + ",ClassID:" + classId
                + ",Text:" + imageText
                + ",Path:" + imagePath
                + ",isDeleted:" + deleted
                + ",Create:" + imageGmtCreate
                + ",Modified:" + imageGmtModified
                + "}";
    }
}
