package com.doubleP.book.biz.impl;

import java.util.List;

import com.doubleP.book.bean.BuyBook;
import com.doubleP.book.biz.BuyBookBiz;
import com.doubleP.book.dao.BuyBookDAO;
import com.doubleP.book.dao.impl.BuyBookDAOImpl;

public class BuyBookBizImpl implements BuyBookBiz {
	private BuyBookDAO dao;
	
	public BuyBookBizImpl(){
		this.dao=new BuyBookDAOImpl();
	}
	@Override
	public List<BuyBook> findAll(int currentPage, int pageSize, String keyWord,
			String orderType) {
		List<BuyBook> buyBookList=null;
		try{
			buyBookList=this.dao.findAll(currentPage, pageSize, keyWord, orderType);
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyBookList;
	}
	@Override
	public Long getAllCount(int user_id) {
		Long count=0l;
		try{
			count=this.dao.getAllCount(user_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

}
