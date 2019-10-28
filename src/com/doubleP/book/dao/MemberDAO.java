package com.doubleP.book.dao;

import com.doubleP.book.bean.Member;
/**
 * 会员接口类
 * @author JackieL&EvanC
 *
 */
public interface MemberDAO extends baseDAO<Member, Integer> {
	
	/**
	 * 用户选择充值会员或者续费
	 * @param bean member对象
	 * @param count 增加的天数
	 * @return true为执行成功，false为执行失败
	 */
	public boolean doUpdate(Member bean,int count);
	
	/**
	 * 用户升级会员
	 * @param bean member对象
	 * @param count 增加的天数
	 * @return true为执行成功，false为执行失败
	 */
	public boolean doCreat(Member bean,int count);
	
}
