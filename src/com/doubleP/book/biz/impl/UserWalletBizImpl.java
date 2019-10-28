package com.doubleP.book.biz.impl;

import com.doubleP.book.bean.UserWallet;
import com.doubleP.book.biz.UserWalletBiz;
import com.doubleP.book.dao.UserWalletDAO;
import com.doubleP.book.dao.impl.UserWalletDAOImpl;

public class UserWalletBizImpl implements UserWalletBiz {
	
	/** 用户钱包接口类属性 */
	private UserWalletDAO dao;
	
	/**
	 * 构造方法，实例化实现层接口对象，便于调用实现层的方法
	 */
	public UserWalletBizImpl(){
		this.dao=new UserWalletDAOImpl();
	}

	@Override
	public boolean updateUser_wallet(UserWallet userwallet) {
		boolean flag=false;
		try{
			flag=this.dao.doUpdate(userwallet);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public UserWallet findById(int user_id) {
		UserWallet userwallet=null;
		try{
			userwallet=this.dao.findById(user_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return userwallet;
	}

}
