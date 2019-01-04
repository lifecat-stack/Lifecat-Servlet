package com.ten.lifecat.servlet.entity;

public class Diary {

    private Integer id;
    private Integer userId;
    private String diaryName;
    private String diaryText;
    private String createTime;
    private String updateTime;
    private Integer isDeleted;

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", userId=" + userId +
                ", diaryName='" + diaryName + '\'' +
                ", diaryText='" + diaryText + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Diary setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDiaryText() {
        return diaryText;
    }

    public Diary setDiaryText(String diaryText) {
        this.diaryText = diaryText;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Diary setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public Diary setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Diary setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getDiaryName() {
        return diaryName;
    }

    public Diary setDiaryName(String diaryName) {
        this.diaryName = diaryName;
        return this;
    }

    public String getdiaryText() {
        return diaryText;
    }

    public Diary setdiaryText(String diaryText) {
        this.diaryText = diaryText;
        return this;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public Diary setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public String getdiaryGmtCreate() {
        return createTime;
    }

    public Diary setdiaryGmtCreate(String diaryGmtCreate) {
        this.createTime = diaryGmtCreate;
        return this;
    }

    public String getdiaryGmtModified() {
        return updateTime;
    }

    public Diary setdiaryGmtModified(String diaryGmtModified) {
        this.updateTime = diaryGmtModified;
        return this;
    }

}
