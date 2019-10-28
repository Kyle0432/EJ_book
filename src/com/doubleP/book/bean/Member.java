package com.doubleP.book.bean;

import java.util.Date;

/**
 * 会员
 * @author JackieL&EvanC
 *
 */
public class Member {
	/** 用户id */
	private int user_id;
	/** 会员类型id */
	private int member_id;
	/** 到期时间 */
	private Date remaining_time;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public Date getRemaining_time() {
		return remaining_time;
	}
	public void setRemaining_time(Date remaining_time) {
		this.remaining_time = remaining_time;
	}
}
