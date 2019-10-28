package com.doubleP.book.bean;

import java.util.Date;

/**
 * 用户详情类
 * @author JackieL&EvanC
 *
 */
public class UserDescription {
	/** 用户id */
	private int user_id;
	/** 用户昵称 */
	private String nickname;
	/** 用户性别 */
	private String gender;
	/** 用户出生日期 */
	private Date birthday;
	/** 用户年龄 */
	private int year_old;
	/** 用户简介 */
	private String explain;
	
	
	public int getYear_old() {
		return year_old;
	}
	public void setYear_old(int year_old) {
		this.year_old = year_old;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
}
