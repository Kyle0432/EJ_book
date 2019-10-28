package com.doubleP.book.biz;

import java.util.List;

import com.doubleP.book.bean.BookType;

public interface BookTypeBiz {
	public BookType findById(Integer beanId);
	
	public List<BookType> findAll();
}
