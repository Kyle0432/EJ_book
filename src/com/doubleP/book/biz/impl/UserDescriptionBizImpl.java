package com.doubleP.book.biz.impl;

import com.doubleP.book.bean.UserDescription;
import com.doubleP.book.biz.UserDescriptionBiz;
import com.doubleP.book.dao.UserDescriptionDAO;
import com.doubleP.book.dao.impl.UserDescriptionDAOImpl;

public class UserDescriptionBizImpl implements UserDescriptionBiz {
	/** 用户详情实现层接口类属性 */
	private UserDescriptionDAO dao;
	
	/**
	 * 构造方法
	 */
	public UserDescriptionBizImpl(){
		this.dao=new UserDescriptionDAOImpl();
	}
	
	@Override
	public boolean creatUserDescription(UserDescription userdescription) {
		boolean flag=false;
		try{
			flag=this.dao.doCreat(userdescription);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateUserDescription(UserDescription userdescription) {
		boolean flag=false;
		try{
			flag=this.dao.doUpdate(userdescription);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public UserDescription findById(int user_id) {
		UserDescription ud=null;
		try{
			ud=this.dao.findById(user_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ud;
	}

}
