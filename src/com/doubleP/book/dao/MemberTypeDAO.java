package com.doubleP.book.dao;

import java.util.List;
import com.doubleP.book.bean.MemberType;
/**
 * 会员类型接口类
 * @author JackieL&EvanC
 *
 */
public interface MemberTypeDAO extends baseDAO<MemberType, Integer> {
	
	/**
	 * 查询所有的会员类型信息
	 * @return 返回member列表
	 */
	public List<MemberType> findAll();
}
