package com.doubleP.book.biz.impl;

import com.doubleP.book.bean.BookDescription;
import com.doubleP.book.biz.BookDescriptionBiz;
import com.doubleP.book.dao.BookDescriptionDAO;
import com.doubleP.book.dao.impl.BookDescriptionDAOImpl;

public class BookDescriptionBizImpl implements BookDescriptionBiz {
	private BookDescriptionDAO dao;
	
	public BookDescriptionBizImpl(){
		this.dao=new BookDescriptionDAOImpl();
	}
	@Override
	public BookDescription findById(int book_id) {
		BookDescription bookdescription=null;
		try{
			bookdescription=this.dao.findById(book_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookdescription;
	}

}
