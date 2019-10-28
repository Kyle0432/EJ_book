package com.doubleP.book.biz;

import java.util.List;

import com.doubleP.book.bean.BookChapter;

public interface BookChapterBiz {
	
	public List<BookChapter> findById(int book_id,int chapter_id);
	
	/**
	 * 取得总记录条数
	 * @param book_id 书
	 * @return 记录条数
	 */
	public Long getAllCount(int book_id);
	
	public List<BookChapter> findAll(int currentPage, int pageSize,
			String keyWord, String orderType);
	
	public List<BookChapter> findByBookId(int book_id);
}
