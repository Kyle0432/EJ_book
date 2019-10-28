package com.doubleP.book.dao.impl;

import java.util.List;
import java.util.Map;

import com.doubleP.book.bean.BookPrice;
import com.doubleP.book.dao.BookPriceDAO;
import com.doubleP.book.util.DBUtils;

public class BookPriceDAOImpl implements BookPriceDAO {

	@Override
	public boolean doCreat(BookPrice bean) {
		boolean flag=false;
		String sql="INSERT INTO bookPrice (book_id,money) VALUES(?,?)";
		flag=DBUtils.update(sql, bean.getBook_id(), bean.getMoney());
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag=false;
		String sql="DELETE bookPrice WHERE book_id=?";
		flag=DBUtils.update(sql, id);
		return flag;
	}

	@Override
	public boolean doUpdate(BookPrice bean) {
		boolean flag=false;
		String sql="UPDATE bookPrice SET book_id=?,money=?";
		flag=DBUtils.update(sql, bean.getBook_id(), bean.getMoney());
		return flag;
	}

	@Override
	public List<BookPrice> findAll(int currentPage, int pageSize,
			String keyWord, String orderType) {
		// TODO Auto-generated method stub
		//书价钱不需要分页
		return null;
	}

	@Override
	public BookPrice mapToBean(Map<String, Object> map) {
		BookPrice bookPrice=null;
		int size=map.size();  //获取map集合大小
		if(size!=0&&!map.isEmpty()){
			for(int i=0;i<size;i++){
				bookPrice=new BookPrice();
				
				bookPrice.setBook_id((Integer)map.get("book_id"));
				bookPrice.setMoney((Integer)map.get("money"));
				
			}
		}
		return bookPrice;
	}

	@Override
	public BookPrice findById(Integer beanId) {
		BookPrice bookPrice=null;
		String sql="SELECT * FROM bookPrice WHERE book_id=?";
		Map<String,Object> map=DBUtils.query(sql, beanId);
		mapToBean(map);
		return bookPrice;
	}

	@Override
	public Integer getAllCountBean() {
		Integer count=-1;
		String sql="SELECT COUNT(*) AS total FROM bookPrice";
		count=(Integer)DBUtils.query(sql).get("total");
		return count;
	}

	@Override
	public Long getAllCount() {
		Long count=0l;
		String sql="SELECT COUNT(*) AS total FROM bookPrice";
		count=(Long)DBUtils.query(sql).get("total");
		return count;
	}

}
