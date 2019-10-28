package com.doubleP.book.dao;

import com.doubleP.book.bean.BuyBook;
/**
 * 用户购买书籍接口类
 * @author JackieL&EvanC
 *
 */
public interface BuyBookDAO extends baseDAO<BuyBook, Integer> {
	/**
	 * 取得总记录条数
	 * user_id 用户id
	 * @return 记录条数
	 */
	public Long getAllCount(int user_id);
}
