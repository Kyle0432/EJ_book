package com.doubleP.book.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.doubleP.book.bean.MemberType;
import com.doubleP.book.dao.MemberTypeDAO;
import com.doubleP.book.util.DBUtils;

public class MemberTypeDAOImpl implements MemberTypeDAO {

	@Override
	public boolean doCreat(MemberType bean) {
		String sql="INSERT INTO memberType (member_name,time) VALUES (?,?) ";
		boolean flag=DBUtils.update(sql, bean.getMember_name(),bean.getTime());
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		String sql="DELETE memberType WHERE member_id=?";
		boolean flag=DBUtils.update(sql, id);
		return flag;
	}

	@Override
	public boolean doUpdate(MemberType bean) {
		String sql="UPDATE memberType SET member_time=? AND time=? WHERE member_id=?";
		boolean flag=DBUtils.update(sql, bean.getMember_name(),bean.getTime(),bean.getMember_id());
		return flag;
	}

	@Override
	public List<MemberType> findAll(int currentPage, int pageSize,
			String keyWord, String orderType) {
		// TODO Auto-generated method stub
		/**
		 * 
		 */
		return null;
	}

	@Override
	public MemberType mapToBean(Map<String, Object> map) {
		int size=map.size();
		MemberType membertype=null;
		if(size!=0&&!map.isEmpty()){
			for(int i=0;i<size;i++){
				membertype=new MemberType();
				membertype.setMember_id((Integer)map.get("member_id"));
				membertype.setMember_name((String)map.get("member_name"));
				membertype.setTime((Integer)map.get("time"));
			}
		}
		return membertype;
	}

	@Override
	public MemberType findById(Integer beanId) {
		String sql="SELECT * FROM memberType WHERE member_id=?";
		Map<String,Object> map=DBUtils.query(sql, beanId);
		MemberType membertype=this.mapToBean(map);
		return membertype;
	}

	@Override
	public Integer getAllCountBean() {
		// TODO Auto-generated method stub
		/**
		 * 此方法暂未实现
		 */
		return null;
	}

	@Override
	public List<MemberType> findAll() {
		List<MemberType> memberTypeList=null;
		String sql="SELECT * FROM memberType";
		List<Map<String,Object>> mapList=DBUtils.queryList(sql);
		if(mapList.size()!=0&&!mapList.isEmpty()){
			memberTypeList=new ArrayList<MemberType>();
			//数据查询成功
			for(int i=0;i<mapList.size();i++){
				Map<String,Object> map=mapList.get(i);
				MemberType membertype=this.mapToBean(map);
				memberTypeList.add(membertype);
			}
		}
		return memberTypeList;
	}

}
