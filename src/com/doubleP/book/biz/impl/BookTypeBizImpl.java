package com.doubleP.book.biz.impl;

import java.util.List;

import com.doubleP.book.bean.BookType;
import com.doubleP.book.biz.BookTypeBiz;
import com.doubleP.book.dao.BookTypeDAO;
import com.doubleP.book.dao.impl.BookTypeDAOImpl;

public class BookTypeBizImpl implements BookTypeBiz {
	private BookTypeDAO dao;
	
	public BookTypeBizImpl(){
		dao=new BookTypeDAOImpl();
	}
	
	@Override
	public BookType findById(Integer beanId) {
		return dao.findById(beanId);
	}

	@Override
	public List<BookType> findAll() {
		return dao.findAll();
	}

}
