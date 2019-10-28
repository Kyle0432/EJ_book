package com.doubleP.book.dao.impl;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.doubleP.book.bean.User;
import com.doubleP.book.dao.UserDAO;
import com.doubleP.book.util.DBUtils;
/**
 * 用户实现层类
 * @author JackieL&EvanC
 *
 */
public class UserDAOImpl implements UserDAO {

	@Override
	public boolean doCreat(User bean) {
		boolean flag=false;
		try {
			 // 开启事务
	         //不把其设置为true之前都是一个当作一个事务来处理
			/**
			 * 只要其中一个事务发生错误，结束所有的事务
			 */
			DBUtils.getConn().setAutoCommit(false);
			String sql="INSERT INTO users (username,password,is_valid,is_member) VALUES (?,?,1,0)";
			String sql1="INSERT INTO userWallet (user_id,user_wallet) VALUES (?,0)";
			DBUtils.update(sql, bean.getUsername(),bean.getPassword());
			DBUtils.update(sql1, bean.getUser_id());
			flag=true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		String sql="UPDATE users SET is_valid=0 WHERE user_id=?";
		boolean flag=DBUtils.update(sql, id);
		return flag;
	}

	@Override
	public boolean doUpdate(User bean) {
		String sql="UPDAET users SET username=? AND password=? WHERE user_id=?";//根据user_id修改用户信息
		boolean flag=DBUtils.update(sql, bean.getUsername(),bean.getPassword(),bean.getUser_id());
		return flag;
	}

	@Override
	public List<User> findAll(int currentPage, int pageSize, String keyWord,
			String orderType) {
		/**
		 * 此方法暂未实现
		 */
		return null;
	}

	@Override
	public User mapToBean(Map<String, Object> map) {
		/**
		 * 将map容器里的信息放入实例化的User对象中
		 */
		int mapSize=map.size();  //获取map集合的内容大小
		User u=null;  
		for(int i=0;i<mapSize;i++){
			//遍历map集合中的所有内容，并将查询到的信息保存到User对象
			u=new User();
			u.setUser_id((Integer)map.get("user_id"));
			u.setUsername((String)map.get("username"));
			u.setPassword((String)map.get("password"));
			u.setIs_valid((Integer)map.get("is_valid"));
			u.setIs_member((Integer)map.get("is_member"));
		}
		return u;
	}

	@Override
	public User findUser(User u) {
		User user=null;
		String sql="SELECT user_id,username,password,is_member,is_valid FROM users WHERE username=? AND password=? AND is_valid=1";
		Map<String,Object> map=DBUtils.query(sql, u.getUsername(),u.getPassword());
		if(map.size()!=0&&!map.isEmpty()){
			//判断map集合是否查询到内容，如果查询到内容便将信息保存到User对象中
			user=this.mapToBean(map);
		}
		return user;
	}

	@Override
	public User findById(Integer beanId) {
		// TODO Auto-generated method stub
		/**
		 * 此方法暂未实现
		 */
		return null;
	}

	@Override
	public Integer getAllCountBean() {
		String sql="SELECT count(*) AS count FROM users WHERE 0=0";
		int allCount=(Integer)DBUtils.query(sql).get("count");
		return allCount;
	}

	@Override
	public boolean findByUsername(String username) {
		boolean flag=false;
		String sql="SELECT (username) FROM users WHERE username=?";
		Map<String,Object> map=DBUtils.query(sql, username); 
		if(map.size()!=0&&!map.isEmpty()){
			//判断map集合是否查询到内容，如果不为空则返回true
			flag=true;
		}
		return flag;
	}

}
