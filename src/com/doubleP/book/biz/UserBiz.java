package com.doubleP.book.biz;

import com.doubleP.book.bean.User;

/**
 * 用户业务逻辑层接口类
 * @author JackieL&EvanC
 *
 */
public interface UserBiz {
	/**
	 * 用户登录
	 * @return 返回user对象
	 */
	public User login(User u);
	
	/**
	 * 注册用户
	 * @return 注册成功返回true，注册失败返回false
	 */
	public boolean register(User u);
	
	/**
	 * 判断用户名是否重复
	 * @param username 用户输入的用户名
	 * @return true为重复用户名，false为可用用户名
	 */
	public boolean judgeUsername(String username);
}
