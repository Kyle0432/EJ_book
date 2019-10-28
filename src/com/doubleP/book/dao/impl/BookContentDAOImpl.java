package com.doubleP.book.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.doubleP.book.bean.BookContent;
import com.doubleP.book.bean.BookType;
import com.doubleP.book.dao.BookContentDAO;
import com.doubleP.book.util.DBUtils;

public class BookContentDAOImpl implements BookContentDAO {

	@Override
	public boolean doCreat(BookContent bean) {
		boolean flag=false;
		String sql="INSERT INTO bookContent (book_id,chapter_id,p_id,contents) VALUES(?,?,?,?) ";
		flag=DBUtils.update(sql, bean.getBook_id(), bean.getChapter_id(), bean.getP_id(), bean.getContents());
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		// TODO Auto-generated method stub
		//不删除段落
		return false;
	}

	@Override
	public boolean doUpdate(BookContent bean) {
		boolean flag=false;
		String sql="UPDATE bookContent SET p_id=?,contents=? WHERE book_id=? AND chapter_id=?";
		flag=DBUtils.update(sql, bean.getP_id(),bean.getContents(),bean.getBook_id(), bean.getChapter_id());
		return flag;
	}

	@Override
	public List<BookContent> findAll(int currentPage, int pageSize,
			String keyWord, String orderType) {
		//文章内容不需要分页
		return null;
	}

	@Override
	public BookContent mapToBean(Map<String, Object> map) {
		BookContent bookContent=null;
		int size=map.size();  //获取map集合大小
		if(size!=0&&!map.isEmpty()){
			for(int i=0;i<size;i++){
				bookContent=new BookContent();
				bookContent.setBook_id((Integer) map.get("book_id"));
				bookContent.setChapter_id((Integer) map.get("chapter_id"));
				bookContent.setP_id((Integer) map.get("p_id"));
				bookContent.setContents((String) map.get("contents"));
				
			}
		}
		return bookContent;
	}

	@Override
	public BookContent findById(Integer beanId) {
		
		return null;
	}

	@Override
	public Integer getAllCountBean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(int book_id, int chapter_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookContent> findAll(int book_id, int chapter_id) {
		List<BookContent> bookContentList=new ArrayList<BookContent>();
		/*String sql="SELECT *,ROW_NUMBER() OVER (ORDER BY p_id asc) AS rn FROM bookContent "
				+ "WHERE book_id=? AND chapter_id=?";*/
		String sql="SELECT * from bookcontent "
				+ "WHERE book_id=? AND chapter_id=? ORDER BY p_id asc";
		List<Map<String,Object>> mapList=DBUtils.queryList(sql, book_id, chapter_id);
		int size=mapList.size();
		if(size!=0&&!mapList.isEmpty()){
			BookContent bookContent=null;
			for(int i=0;i<size;i++){
				Map<String,Object> map=mapList.get(i);
				bookContent=mapToBean(map);
				bookContentList.add(bookContent);
			}
		}
		return bookContentList;
	}

	@Override
	public Long getCount(int book_id, int chapter_id) {
		Long count=0l;
		String sql="SELECT COUNT(*) total FROM bookContent WHERE book_id=? AND chapter_id=?";
		count=Long.parseLong(DBUtils.query(sql, book_id, chapter_id).get("total").toString());
		return count;
	}

}
