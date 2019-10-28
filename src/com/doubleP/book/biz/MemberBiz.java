package com.doubleP.book.biz;

import com.doubleP.book.bean.Member;

public interface MemberBiz {
	
	/**
	 * 用户充值会员
	 * @param member member对象
	 * @param count 充值天数
	 * @return 充值成功返回true，充值失败返回false
	 */
	public boolean addMember(Member member,int count);
	
	/**
	 * 用户续费
	 * @param member member对象
	 * @param count 续费天数
	 * @return 返回true续费成功，返回false续费失败
	 */
	public boolean renew(Member member,int count);
	
	/**
	 * 查询用户是否为会员
	 * @param user_id 用户id
	 * @return 返回member对象
	 */
	public Member findById(int user_id);
}	
