package com.doubleP.book.biz;

import com.doubleP.book.bean.UserWallet;

public interface UserWalletBiz {
	
	/**
	 * 用户充值
	 * @param userwallet 用户钱包类
	 * @return true为充值成功，false为充值失败
	 */
	public boolean updateUser_wallet(UserWallet userwallet);
	
	/**
	 * 根据用户id查询用户钱包
	 * @param user_id 用户id
	 * @return 返回userwallet对象
	 */
	public UserWallet findById(int user_id);
}
