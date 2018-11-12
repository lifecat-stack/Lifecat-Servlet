package com.ten.bean.entity;

/**
 * DO :diary
 *
 * @auther ten
 */
public class DiaryDO {

    private Integer diaryId;
    private Integer userId;
    private String diaryName;
    private String diaryText;
    private Integer deleted;
    private String diaryGmtCreate;
    private String diaryGmtModified;

    public Integer getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Integer diaryId) {
        this.diaryId = diaryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public String getdiaryText() {
        return diaryText;
    }

    public void setdiaryText(String diaryText) {
        this.diaryText = diaryText;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getdiaryGmtCreate() {
        return diaryGmtCreate;
    }

    public void setdiaryGmtCreate(String diaryGmtCreate) {
        this.diaryGmtCreate = diaryGmtCreate;
    }

    public String getdiaryGmtModified() {
        return diaryGmtModified;
    }

    public void setdiaryGmtModified(String diaryGmtModified) {
        this.diaryGmtModified = diaryGmtModified;
    }
     /**
     * @return DiaryDO@1234{DiaryId:'',UserID:'',Name:'',Text:'',isDeleted:'',Create:'',Modified:''}
     */
    @Override
    public String toString() {
        return "DiaryDO@" + diaryId
                + "{DiaryId:" + diaryId
                + ",UserID:" + userId
                + ",Name:" + diaryName
                + ",Text:" + diaryText
                + ",isDeleted:" + deleted
                + ",Create:" + diaryGmtCreate
                + ",Modified:" + diaryGmtModified
                + "}";
    }
}
