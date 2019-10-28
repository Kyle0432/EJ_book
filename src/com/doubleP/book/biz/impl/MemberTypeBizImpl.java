package com.doubleP.book.biz.impl;

import java.util.List;

import com.doubleP.book.bean.MemberType;
import com.doubleP.book.biz.MemberTypeBiz;
import com.doubleP.book.dao.MemberTypeDAO;
import com.doubleP.book.dao.impl.MemberTypeDAOImpl;

public class MemberTypeBizImpl implements MemberTypeBiz {
	/** 会员类型接口类属性 */
	private MemberTypeDAO dao;
	
	public MemberTypeBizImpl(){
		this.dao=new MemberTypeDAOImpl();
	}
	@Override
	public List<MemberType> findAll() {
		List<MemberType> memberTypeList=null;
		try{
			memberTypeList=this.dao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return memberTypeList;
	}

	@Override
	public MemberType findById(int member_id) {
		MemberType memberType=null;
		try{
			memberType=this.dao.findById(member_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return memberType;
	}

}
