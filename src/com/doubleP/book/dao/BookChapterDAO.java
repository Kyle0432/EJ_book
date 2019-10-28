package com.doubleP.book.dao;

import java.util.List;

import com.doubleP.book.bean.BookChapter;
/**
 * 书籍章节接口类
 * @author JackieL&EvanC
 *
 */
public interface BookChapterDAO extends baseDAO<BookChapter, Integer> {
	
	public List<BookChapter> findById(int book_id,int chapter_id);
	
	/**
	 * 取得总记录条数
	 * @param book_id 书
	 * @return 记录条数
	 */
	public Long getAllCount(int book_id);
	
	public List<BookChapter> findByBookId(int book_id);
	
}
