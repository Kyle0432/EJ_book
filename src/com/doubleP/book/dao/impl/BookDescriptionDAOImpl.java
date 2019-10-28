package com.doubleP.book.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.doubleP.book.bean.BookChapter;
import com.doubleP.book.bean.BookContent;
import com.doubleP.book.bean.BookDescription;
import com.doubleP.book.dao.BookDescriptionDAO;
import com.doubleP.book.util.DBUtils;

public class BookDescriptionDAOImpl implements BookDescriptionDAO {

	@Override
	public boolean doCreat(BookDescription bean) {
		boolean flag=false;
		String sql="INSERT INTO bookDescription (book_id,type_id,chapter_count,status,explain) VALUES(?,?,?,?,?)";
		flag=DBUtils.update(sql, bean.getBook_id(),bean.getType_id(),bean.getChapter_count(),bean.getStatus(),bean.getExplain());
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag=false;
		String sql="DELETE bookDescription WHERE book_id=?";
		flag=DBUtils.update(sql, id);
		return flag;
	}

	@Override
	public boolean doUpdate(BookDescription bean) {
		boolean flag=false;
		String sql="UPDATE bookDescription SET type_id=?,chapter_count=?,status=?,explain=? WHERE book_id=?";
		flag=DBUtils.update(sql, bean.getType_id(),bean.getChapter_count(),bean.getStatus(),bean.getExplain(),bean.getBook_id());
		return flag;
	}

	@Override
	public List<BookDescription> findAll(int currentPage, int pageSize,
			String keyWord, String orderType) {
		List<BookDescription> bookDescriptionList=new ArrayList<BookDescription>();
		/*String sql="SELECT TOP "+pageSize+" * FROM( "
				+ "SELECT *,ROW_NUMBER() OVER(ORDER BY book_id asc) AS rn FROM bookDescription "
				+ ") WHERE rn>"+(currentPage-1)*pageSize;*/
		String sql="SELECT TOP "+pageSize+" * FROM bookDescription "
				+ " ORDER BY book_id asc rn>"+(currentPage-1)*pageSize;;
		List<Map<String,Object>> mapList=DBUtils.queryList(sql, keyWord);
		int size=mapList.size();
		if(size!=0&&!mapList.isEmpty()){
			//当查询到内容时
			BookDescription bookDescription=null;
			for(int i=0;i<size;i++){
				Map<String,Object> map=mapList.get(i);
				bookDescription=mapToBean(map);
				bookDescriptionList.add(bookDescription);
			}
		}
		
		
		return bookDescriptionList;
	}

	@Override
	public BookDescription mapToBean(Map<String, Object> map) {
		BookDescription bookDescription=null;
		int size=map.size();  //获取map集合大小
		if(size!=0&&!map.isEmpty()){
			for(int i=0;i<size;i++){
				bookDescription=new BookDescription();
				bookDescription.setBook_id((Integer) map.get("book_id"));
				bookDescription.setType_id((Integer) map.get("type_id"));
				bookDescription.setChapter_count((Integer) map.get("chapter_count"));
				bookDescription.setStatus((String) map.get("status"));
				bookDescription.setExplain((String) map.get("explain"));
				
			}
		}
		return bookDescription;
	}

	@Override
	public BookDescription findById(Integer beanId) {
		BookDescription bookDescription=null;
		String sql="";
		
		return bookDescription;
	}

	@Override
	public Integer getAllCountBean() {
		// TODO Auto-generated method stub
		return null;
	}

}
