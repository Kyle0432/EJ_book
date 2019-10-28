package com.doubleP.book.biz;

import com.doubleP.book.bean.BookDescription;

public interface BookDescriptionBiz {
	
	/**
	 * 根据书籍id查询书籍详情信息
	 * @param book_id 书籍id
	 * @return 返回bookdescription对象
	 */
	public BookDescription findById(int book_id);
}
