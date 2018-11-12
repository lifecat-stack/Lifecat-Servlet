package com.ten.bean.entity;

public class Image {

    private Integer id;
    private Integer userId;
    private Integer classId;
    private String imageName;
    private String imageText;
    private String imagePath;
    private String createTime;
    private String updateTime;
    private Integer isDeleted;

    @Override
    public String toString() {
        return "Image@{"
                + "id:" + id
                + ",userId:" + userId
                + ",classId:" + classId
                + ",imageName:" + imageName
                + ",imageText:" + imageText
                + ",imagePath:" + imagePath
                + ",createTime:" + createTime
                + ",updateTime:" + updateTime
                + ",isDeleted:" + isDeleted
                + "}";
    }

    public Integer getId() {
        return id;
    }

    public Image setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getImageName() {
        return imageName;
    }

    public Image setImageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Image setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getClassId() {
        return classId;
    }

    public Image setClassId(Integer classId) {
        this.classId = classId;
        return this;
    }

    public String getImageText() {
        return imageText;
    }

    public Image setImageText(String imageText) {
        this.imageText = imageText;
        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Image setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public Image setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Image setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public Image setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
