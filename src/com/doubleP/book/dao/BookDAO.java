package com.doubleP.book.dao;

import com.doubleP.book.bean.Book;
/**
 * 书籍接口类
 * @author JackieL&EvanC
 *
 */
public interface BookDAO extends baseDAO<Book,Integer> {
	
	/**
	 * 取得总记录条数
	 * @param book_id 书
	 * @return 记录条数
	 */
	public Long getAllCount(String keyWord);
}
