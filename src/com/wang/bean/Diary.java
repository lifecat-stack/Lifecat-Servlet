package com.wang.bean;
/**
 * @name Diary
 * @description Diary用户日记信息
 * @auther ten
 */
public class Diary implements Bean{

	private int id;
	private String diaryname;
	private String diarydescription;
	private String diarydate;
	private String diarypath;

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getName() {
		return diaryname;
	}
	public void setName(String name) {
		this.diaryname = name;
	}
	public String getDescription() {
		return diarydescription;
	}
	public void setDescription(String description) {
		this.diarydescription = description;
	}
	public String getDate() {
		return diarydate;
	}
	public void setDate(String date) {
		this.diarydate = date;
	}
	public String getPath() {
		return diarypath;
	}
	public void setPath(String path) {
		this.diarypath = path;
	}
}
