package com.doubleP.book.dao.impl;

import java.util.List;
import java.util.Map;

import com.doubleP.book.bean.UserWallet;
import com.doubleP.book.dao.UserWalletDAO;
import com.doubleP.book.util.DBUtils;
/**
 * 用户钱包实现层类
 * @author JackieL&EvanC
 *
 */
public class UserWalletDAOImpl implements UserWalletDAO {

	@Override
	public boolean doCreat(UserWallet bean) {
		String sql="INSERT INTO userWallet (user_id,user_wallet) VALUES (?,?)";
		boolean flag=DBUtils.update(sql, bean.getUser_id(),bean.getUser_wallet());
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		// TODO Auto-generated method stub
		/**
		 * 此方法暂未实现
		 */
		return false;
	}

	@Override
	public boolean doUpdate(UserWallet bean) {
		String sql="UPDATE userWallet SET user_wallet=user_wallet+? WHERE user_id=?";
		boolean flag=DBUtils.update(sql, bean.getUser_wallet(),bean.getUser_id());
		return flag;
	}

	@Override
	public List<UserWallet> findAll(int currentPage, int pageSize,
			String keyWord, String orderType) {
		// TODO Auto-generated method stub
		/**
		 * 此方法暂未实现
		 */
		return null;
	}

	@Override
	public UserWallet mapToBean(Map<String, Object> map) {
		int size=map.size();  //获取保存的map集合的size
		UserWallet userwallet=null;
		if(size!=0&&!map.isEmpty()){
			//当确定map集合里面查询到内容时将信息存入对象中
			userwallet=new UserWallet();
			userwallet.setUser_id((Integer)map.get("user_id"));
			userwallet.setUser_wallet((Integer)map.get("user_wallet"));
		}
		return userwallet;
	}

	@Override
	public UserWallet findById(Integer beanId) {
		String sql="SELECT * FROM userWallet WHERE user_id=?";
		Map<String,Object> map=DBUtils.query(sql, beanId);
		UserWallet userwallet=this.mapToBean(map);
		return userwallet;
	}

	@Override
	public Integer getAllCountBean() {
		// TODO Auto-generated method stub
		/**
		 * 此方法暂未实现
		 */
		return null;
	}

}
