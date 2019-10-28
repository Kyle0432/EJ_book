package com.doubleP.book.biz.impl;

import java.util.List;

import com.doubleP.book.bean.BookChapter;
import com.doubleP.book.biz.BookChapterBiz;
import com.doubleP.book.dao.BookChapterDAO;
import com.doubleP.book.dao.impl.BookChapterDAOImpl;

public class BookChapterBizImpl implements BookChapterBiz {
	private BookChapterDAO dao;
	
	public BookChapterBizImpl(){
		this.dao=new BookChapterDAOImpl();
	}
	@Override
	public List<BookChapter> findById(int book_id, int chapter_id) {
		List<BookChapter> bookChapterList=null;
		try{
			bookChapterList=this.dao.findById(book_id, chapter_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookChapterList;
	}

	@Override
	public Long getAllCount(int book_id) {
		Long count=0l;
		try{
			count=this.dao.getAllCount(book_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<BookChapter> findAll(int currentPage, int pageSize,
			String keyWord, String orderType) {
		List<BookChapter> bookChapterList=null;
		try{
			bookChapterList=this.dao.findAll(currentPage, pageSize, keyWord, orderType);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookChapterList;
	}
	@Override
	public List<BookChapter> findByBookId(int book_id) {
		List<BookChapter> bookChapterList=null;
		try{
			bookChapterList=this.dao.findByBookId(book_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookChapterList;
	}

}
