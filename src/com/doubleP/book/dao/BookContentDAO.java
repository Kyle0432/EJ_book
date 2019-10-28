package com.doubleP.book.dao;

import java.util.List;

import com.doubleP.book.bean.BookContent;
/**
 * 书籍内容接口类
 * @author JackieL&EvanC
 *
 */
public interface BookContentDAO extends baseDAO<BookContent, Integer> {
	/**
	 * 取得总记录条数
	 * @param book_id 书
	 * @param chapter_id 章
	 * @return 记录条数
	 */
	public Long getAllCount(int book_id,int chapter_id);
	
	/**
	 * 查询某书某章所有内容
	 * @param book_id 书编号
	 * @param chapter_id 章节编号
	 * @return 文本内容
	 */
	public List<BookContent> findAll(int book_id,int chapter_id);
	
	public Long getCount(int book_id,int chapter_id);
}
