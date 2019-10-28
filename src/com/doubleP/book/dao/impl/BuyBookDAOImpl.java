package com.doubleP.book.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.doubleP.book.bean.Book;
import com.doubleP.book.bean.BuyBook;
import com.doubleP.book.dao.BuyBookDAO;
import com.doubleP.book.util.DBUtils;

public class BuyBookDAOImpl implements BuyBookDAO {

	@Override
	public boolean doCreat(BuyBook bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(BuyBook bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BuyBook> findAll(int currentPage, int pageSize, String keyWord,
			String orderType) {
		List<BuyBook> buyBookList=null;
		BuyBook buyBook=null;
		Book book=null;
		String sql="SELECT * FROM book bk"
				   +" LEFT JOIN buyBook b"
				   +" ON b.book_id=bk.book_id"
				   +" WHERE user_id LIKE '"+keyWord+"' ORDER BY bk.book_id "+orderType+" limit "+(currentPage-1)*pageSize+","+pageSize;
		List<Map<String,Object>> mapList=DBUtils.queryList(sql);
		int size=mapList.size();
		if(size!=0&&!mapList.isEmpty()){
			buyBookList=new ArrayList<BuyBook>();
			for(int i=0;i<size;i++){
				buyBook=new BuyBook();
				book=new Book();
				Map<String,Object> map=mapList.get(i);
				buyBook.setBook_id((Integer)map.get("book_id"));
				buyBook.setUser_id((Integer)map.get("user_id"));
				book.setBook_id((Integer)map.get("book_id"));
				book.setBook_name((String)map.get("book_name"));
				book.setAlternate_name((String)map.get("alternate_name"));
				book.setPoster((String)map.get("poster"));
				book.setIs_Valid((Integer)map.get("is_valid"));
				buyBook.setBook(book);
				buyBookList.add(buyBook);
			}
		}
		return buyBookList;
	}

	@Override
	public BuyBook mapToBean(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuyBook findById(Integer beanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCountBean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(int user_id) {
		Long count=0l;
		String sql="SELECT COUNT(*) AS total FROM buyBook WHERE user_id=?";
		count=Long.parseLong(DBUtils.query(sql,user_id).get("total").toString());
		return count;
	}

}
