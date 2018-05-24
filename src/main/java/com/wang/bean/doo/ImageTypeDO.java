package com.wang.bean.doo;

/**
 * DO :image_type
 *
 * @auther ten
 */
public class ImageTypeDO {

    private Integer imageId;
    private Integer userId;
    private Integer classId;
    private String typeGmtCreate;
    private String typeGmtModified;

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

    public String getTypeGmtCreate() {
        return typeGmtCreate;
    }

    public void setTypeGmtCreate(String typeGmtCreate) {
        this.typeGmtCreate = typeGmtCreate;
    }

    public String getTypeGmtModified() {
        return typeGmtModified;
    }

    public void setTypeGmtModified(String typeGmtModified) {
        this.typeGmtModified = typeGmtModified;
    }

    /**
     * @return ImageTypeDO@1234{ImageID:'',UserID:'',ClassID:'',Create:'',Modified:''}
     */
    @Override
    public String toString() {
        return "UserDO@" + imageId
                + "{ImageID:" + imageId
                + ",UserID:" + userId
                + ",ClassID:" + classId
                + ",Create:" + typeGmtCreate
                + ",Modified:" + typeGmtModified
                + "}";
    }
}
