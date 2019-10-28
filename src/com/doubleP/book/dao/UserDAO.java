package com.doubleP.book.dao;

import com.doubleP.book.bean.User;
/**
 * 用户接口类
 * @author JackieL&EvanC
 *
 */
public interface UserDAO extends baseDAO<User, Integer> {
	
	/**
	 * 查找用户
	 * @param u user对象
	 * @return 返回查询到的user对象
	 */
	public User findUser(User u);
	
	/**
	 * 根据用户名查询用户是否存在
	 * @param username 用户输入的用户名 
	 * @return true为存在，false为不存在
	 */
	public boolean findByUsername(String username); 
}
