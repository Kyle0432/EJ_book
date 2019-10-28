package com.doubleP.book.biz.impl;

import com.doubleP.book.bean.BookPrice;
import com.doubleP.book.biz.BookPriceBiz;
import com.doubleP.book.dao.BookPriceDAO;
import com.doubleP.book.dao.impl.BookPriceDAOImpl;

public class BookPriceBizImpl implements BookPriceBiz {
	
	private BookPriceDAO dao;
	
	public BookPriceBizImpl(){
		this.dao=new BookPriceDAOImpl();
	}
	@Override
	public BookPrice findById(Integer book_id) {
		BookPrice bookprice=null;
		try{
			bookprice=this.dao.findById(book_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookprice;
	}

}
