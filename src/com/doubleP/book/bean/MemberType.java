package com.doubleP.book.bean;

/**
 * 会员类型
 * @author JackieL&EvanC
 *
 */
public class MemberType {
	
	/** 会员id */
	private int member_id;
	/** 会员类型名 */
	private String member_name;
	/** 时间 */
	private int time;
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}
