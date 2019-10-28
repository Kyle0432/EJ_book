package com.doubleP.book.biz;

import com.doubleP.book.bean.BookPrice;

public interface BookPriceBiz {
	/**
	 * 根据书籍id查询书籍价格
	 * @param book_Id 书籍id
	 * @return 返回对象
	 */
	public BookPrice findById(Integer book_id);
}
