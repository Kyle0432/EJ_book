package com.doubleP.book.biz;

import com.doubleP.book.bean.UserDescription;

/**
 * 用户详情业务逻辑层接口类 
 * @author JackieL&EvanC
 *
 */
public interface UserDescriptionBiz {
	
	/**
	 * 增加用户详情
	 * @param userdescription userdescription对象
	 * @return 返回true为增加成功，返回false为增加失败
	 */
	public boolean creatUserDescription(UserDescription userdescription);
	
	/**
	 * 修改用户详情
	 * @param userdescription userdescription对象
	 * @return 修改成功返回true，修改失败返回fasle
	 */
	public boolean updateUserDescription(UserDescription userdescription);
	
	/**
	 * 根据用户id查询用户详情
	 * @param user_id 用户id
	 * @return 返回userdescription对象
	 */
	public UserDescription findById(int user_id);
	
}
