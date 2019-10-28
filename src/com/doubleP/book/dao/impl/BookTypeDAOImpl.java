package com.doubleP.book.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.doubleP.book.bean.BookContent;
import com.doubleP.book.bean.BookType;
import com.doubleP.book.dao.BookTypeDAO;
import com.doubleP.book.util.DBUtils;

public class BookTypeDAOImpl implements BookTypeDAO {

	@Override
	public boolean doCreat(BookType bean) {
		boolean flag=false;
		String sql="INSERT INTO bookType (type_name) VALUES(?)";
		flag=DBUtils.update(sql, bean.getType_name());
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag=false;
		String sql="DELETE bookType WHERE type_id=?";
		flag=DBUtils.update(sql, id);
		return flag;
	}

	@Override
	public boolean doUpdate(BookType bean) {
		boolean flag=false;
		String sql="UPDATE bookType SET type_name=?";
		flag=DBUtils.update(sql, bean.getType_name());
		return flag;
	}

	@Override
	public List<BookType> findAll(int currentPage, int pageSize,
			String keyWord, String orderType) {
		// TODO Auto-generated method stub
		//书类型不需要分页
		return null;
	}

	@Override
	public BookType mapToBean(Map<String, Object> map) {
		BookType bookType=null;
		int size=map.size();  //获取map集合大小
		if(size!=0&&!map.isEmpty()){
			for(int i=0;i<size;i++){
				bookType=new BookType();
				
				bookType.setType_id((Integer)map.get("type_id"));
				bookType.setType_name((String)map.get("type_name"));
				
			}
		}
		return bookType;
	}

	@Override
	public BookType findById(Integer beanId) {
		BookType bookType=null;
		String sql="SELECT * FROM bookType WHERE type_id=?";
		Map<String,Object> map=DBUtils.query(sql, beanId);
		mapToBean(map);
		return bookType;
	}

	@Override
	public Integer getAllCountBean() {
		Integer count=-1;
//		String sql="SELECT COUNT(*) AS total FROM bookType";
//		count=(Integer)DBUtils.query(sql).get("total");
		return count;
	}

	@Override
	public Long getAllCount() {
		Long count=0l;
		String sql="SELECT COUNT(*) AS total FROM bookType";
		count=(Long)DBUtils.query(sql).get("total");
		return count;
	}

	@Override
	public List<BookType> findAll() {
		List<BookType> bookTypeList=new ArrayList<BookType>();
		String sql="SELECT * FROM bookType";
		List<Map<String,Object>> mapList=DBUtils.queryList(sql);
		int size=mapList.size();
		if(size!=0&&!mapList.isEmpty()){
			BookType bookType=null;
			for(int i=0;i<size;i++){
				Map<String,Object> map=mapList.get(i);
				bookType=mapToBean(map);
				bookTypeList.add(bookType);
			}
		}
		return bookTypeList;
	}

}
