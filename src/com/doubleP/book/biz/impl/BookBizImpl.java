package com.doubleP.book.biz.impl;

import java.util.List;

import com.doubleP.book.bean.Book;
import com.doubleP.book.biz.BookBiz;
import com.doubleP.book.dao.BookDAO;
import com.doubleP.book.dao.impl.BookDAOImpl;

public class BookBizImpl implements BookBiz {
	
	private BookDAO dao;
	
	public BookBizImpl(){
		this.dao=new BookDAOImpl();
	}
	@Override
	public List<Book> findAll(int currentPage, int pageSize, String keyWord,
			String orderType) {
		List<Book> bookList=null;
		try{
			bookList=this.dao.findAll(currentPage, pageSize, keyWord, orderType);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public Book findById(Integer book_id) {
		Book book=null;
		try{
			book=this.dao.findById(book_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public Long getAllCount(String keyWord) {
		Long count=0l;
		try{
			count=this.dao.getAllCount(keyWord);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

}
