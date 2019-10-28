package com.doubleP.book.biz.impl;

import com.doubleP.book.bean.Member;
import com.doubleP.book.biz.MemberBiz;
import com.doubleP.book.dao.MemberDAO;
import com.doubleP.book.dao.impl.MemberDAOImpl;

public class MemberBizImpl implements MemberBiz {
	
	/** MemberDAO接口类属性  */
	private MemberDAO dao;
	
	/**
	 * 构造方法
	 */
	public MemberBizImpl(){
		this.dao=new MemberDAOImpl();
	}

	@Override
	public boolean addMember(Member member, int count) {
		boolean flag=false;
		try{
			flag=this.dao.doCreat(member, count);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean renew(Member member, int count) {
		boolean flag=false;
		try{
			flag=this.dao.doUpdate(member, count);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Member findById(int user_id) {
		Member member=null;
		try{
			member=this.dao.findById(user_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return member;
	}

}
