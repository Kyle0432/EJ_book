package com.doubleP.book.biz.impl;

import com.doubleP.book.bean.User;
import com.doubleP.book.biz.UserBiz;
import com.doubleP.book.dao.UserDAO;
import com.doubleP.book.dao.impl.UserDAOImpl;

public class UserBizImpl implements UserBiz {
	
	private UserDAO dao;
	
	public UserBizImpl(){
		this.dao=new UserDAOImpl();
	}
	
	@Override
	public User login(User u) {
		User user=null;
		try{
			user=this.dao.findUser(u);
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean register(User u) {
		boolean flag=false;
		try{
			flag=this.dao.doCreat(u);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean judgeUsername(String username) {
		boolean flag=false;
		try{
			flag=this.dao.findByUsername(username);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	
}
