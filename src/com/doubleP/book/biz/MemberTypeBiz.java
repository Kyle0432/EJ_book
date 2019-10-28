package com.doubleP.book.biz;

import java.util.List;

import com.doubleP.book.bean.MemberType;

public interface MemberTypeBiz {
	
	/**
	 * 查询所有的会员类型
	 * @return 返回列表
	 */
	public List<MemberType> findAll();
	
	/**
	 * 根据member_id查询出用户会员类型
	 * @param member_id 会员id
	 * @return 返回MemberType对象
	 */
	public MemberType findById(int member_id);
}
