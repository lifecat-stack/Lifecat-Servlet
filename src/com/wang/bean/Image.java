package com.wang.bean;
/**
 * @name Image
 * @description Image图片信息
 * @auther ten
 */
public class Image implements Bean{

	private int id;
	private String imagename;
	private String imagedescription;
	private String imagedate;
	private String imagepath;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getImagedescription() {
		return imagedescription;
	}
	public void setImagedescription(String imagedescription) {
		this.imagedescription = imagedescription;
	}
	public String getImagedate() {
		return imagedate;
	}
	public void setImagedate(String imagedate) {
		this.imagedate = imagedate;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
}
