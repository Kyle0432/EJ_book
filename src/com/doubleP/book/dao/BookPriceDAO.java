package com.doubleP.book.dao;

import com.doubleP.book.bean.BookPrice;
/**
 * 书籍价钱接口类
 * @author JackieL&EvanC
 *
 */
public interface BookPriceDAO extends baseDAO<BookPrice, Integer> {
	/**
	 * 取得总记录条数
	 * @return 记录条数
	 */
	public Long getAllCount();
}
