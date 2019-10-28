package com.doubleP.book.bean;
/**
 * 用户类
 * @author JackieL&EvanC
 *
 */
public class User {
	/** 用户id */
	private int user_id;
	/** 用户名称 */
	private String username;
	/** 登录密码 */
	private String password;
	/** 是否为会员 */
	private int is_member;
	/** 用户有效性，1为有效账号，0为无效 */
	private int is_valid;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIs_valid() {
		return is_valid;
	}
	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}
	public int getIs_member() {
		return is_member;
	}
	public void setIs_member(int is_member) {
		this.is_member = is_member;
	}
	
}
