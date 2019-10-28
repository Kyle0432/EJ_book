package com.doubleP.book.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.doubleP.book.bean.Member;
import com.doubleP.book.dao.MemberDAO;
import com.doubleP.book.util.DBUtils;
/**
 * 会员实现类
 * @author JackieL&EvanC
 *
 */
public class MemberDAOImpl implements MemberDAO {

	@Override
	public boolean doCreat(Member bean) {
		// TODO Auto-generated method stub
				/**
				 * 此方法暂未完成
				 */
				return false;
	}

	@Override
	public boolean doRemove(Integer id) {
		// TODO Auto-generated method stub
		/**
		 * 此方法暂未完成
		 */
		return false;
	}

	@Override
	public boolean doUpdate(Member bean) {
		// TODO Auto-generated method stub
				/**
				 * 此方法暂未完成
				 */
				return false;
	}

	@Override
	public List<Member> findAll(int currentPage, int pageSize, String keyWord,
			String orderType) {
		// TODO Auto-generated method stub
		/**
		 * 此方法暂未完成
		 */
		return null;
	}

	@Override
	public Member mapToBean(Map<String, Object> map) {
		int size=map.size();  //获取map集合size大小
		Member member=null;
		if(size!=0&&!map.isEmpty()){
			member=new Member();
			member.setUser_id((Integer)map.get("user_id"));
			member.setMember_id((Integer)map.get("member_id"));
			member.setRemaining_time((Date)map.get("remaining_time"));
		}
		return member;
	}

	@Override
	public Member findById(Integer beanId) {
		String sql="SELECT * FROM member WHERE user_id=?";
		Member member=null;
		Map<String,Object> map=DBUtils.query(sql, beanId);
		member=this.mapToBean(map);
		return member;
	}

	@Override
	public Integer getAllCountBean() {
		// TODO Auto-generated method stub
		/**
		 * 此方法暂未完成
		 */
		return null;
	}

	@Override
	public boolean doUpdate(Member bean, int count) {
		String sql="UPDATE member SET member_id=? AND remaining_time=remaning+? WHERE user_id=?";
		boolean flag=DBUtils.update(sql, bean.getMember_id(),bean.getRemaining_time(),count,bean.getUser_id());
		return flag;
	}

	@Override
	public boolean doCreat(Member bean, int count) {
		boolean flag=false;
		try {
			 // 开启事务
	         //不把其设置为true之前都是一个当作一个事务来处理
			/**
			 * 只要其中一个事务发生错误，结束所有的事务
			 */
			DBUtils.getConn().setAutoCommit(false);
			String sql="UPDATE users SET is_member=1 WHERE user_id=?";
			String sql1="INSERT INTO member (user_id,member_id,remaining_time) VALUES(?,?,GETDATE()+?)";
			DBUtils.update(sql, bean.getUser_id());
			DBUtils.update(sql1, bean.getUser_id(),bean.getMember_id(),bean.getRemaining_time(),count);
			flag=true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}

}
