package com.wang.bean;
/**
 * @name User
 * @description User用户登录信息数据库
 * @auther ten
 */
public class User implements Bean{
  
    private int id;
    private String name; 
    private String password;
    private String level;
    
    public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }  
}