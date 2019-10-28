package com.doubleP.book.dao;

import java.util.List;

import com.doubleP.book.bean.BookType;
/**
 * 书籍类型接口类
 * @author JackieL&EvanC
 *
 */
public interface BookTypeDAO extends baseDAO<BookType, Integer> {
	
	/**
	 * 取得总记录条数
	 * @return 记录条数
	 */
	public Long getAllCount();
	
	public List<BookType> findAll();
}
