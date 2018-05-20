package com.wang.doo;

/**
 * DO :diary
 *
 * @auther ten
 */
public class DiaryDO {

    private int diary_id;
    private int user_id;
    private String diary_name;
    private String diary_text;
    private String is_deleted;
    private String diary_gmt_create;
    private String diary_gmt_modified;

    public int getDiary_id() {
        return diary_id;
    }

    public void setDiary_id(int diary_id) {
        this.diary_id = diary_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDiary_name() {
        return diary_name;
    }

    public void setDiary_name(String diary_name) {
        this.diary_name = diary_name;
    }

    public String getDiary_text() {
        return diary_text;
    }

    public void setDiary_text(String diary_text) {
        this.diary_text = diary_text;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getDiary_gmt_create() {
        return diary_gmt_create;
    }

    public void setDiary_gmt_create(String diary_gmt_create) {
        this.diary_gmt_create = diary_gmt_create;
    }

    public String getDiary_gmt_modified() {
        return diary_gmt_modified;
    }

    public void setDiary_gmt_modified(String diary_gmt_modified) {
        this.diary_gmt_modified = diary_gmt_modified;
    }
}
