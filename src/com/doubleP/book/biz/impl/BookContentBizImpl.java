package com.doubleP.book.biz.impl;

import java.util.List;

import com.doubleP.book.bean.BookContent;
import com.doubleP.book.biz.BookContentBiz;
import com.doubleP.book.dao.BookContentDAO;
import com.doubleP.book.dao.impl.BookContentDAOImpl;

public class BookContentBizImpl implements BookContentBiz {
	private BookContentDAO dao;
	
	public BookContentBizImpl(){
		this.dao=new BookContentDAOImpl();
	}
	@Override
	public Long getAllCount(int book_id, int chapter_id) {
		Long count=0l;
		try{
			count=this.dao.getAllCount(book_id, chapter_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<BookContent> findAll(int book_id, int chapter_id) {
		List<BookContent> bookContentList=null;
		try{
			bookContentList=this.dao.findAll(book_id, chapter_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookContentList;
	}
	@Override
	public Long getCount(int book_id, int chapter_id) {
		Long count=0l;
		count=this.dao.getCount(book_id, chapter_id);
		return count;
	}

}
