package com.doubleP.book.biz;

import java.util.List;

import com.doubleP.book.bean.BuyBook;

public interface BuyBookBiz {
	
	public List<BuyBook> findAll(int currentPage, int pageSize, String keyWord,
			String orderType);
	
	public Long getAllCount(int user_id);
}
