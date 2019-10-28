package com.doubleP.book.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.doubleP.book.bean.BookChapter;
import com.doubleP.book.bean.BookContent;
import com.doubleP.book.dao.BookChapterDAO;
import com.doubleP.book.util.DBUtils;

public class BookChapterDAOImpl implements BookChapterDAO {

	@Override
	public boolean doCreat(BookChapter bean) {
		boolean flag=false;
		String sql="INSERT INTO bookChapter (book_id,chapter_id,time) VALUES(?,?,?)";
		flag=DBUtils.update(sql, bean.getBook_id(), bean.getChapter_id(), bean.getTime());
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag=false;
		String sql="DELETE bookChapter WHERE book_id=?";
		flag=DBUtils.update(sql, id);
		return flag;
	}

	@Override
	public boolean doUpdate(BookChapter bean) {
		boolean flag=false;
		String sql="UPDATE bookChapter SET chapter_id=?,time=? WHERE book_id=?";
		flag=DBUtils.update(sql, bean.getChapter_id(), bean.getTime(), bean.getBook_id());
		return flag;
	}

	@Override
	public List<BookChapter> findAll(int currentPage, int pageSize,
			String keyWord, String orderType) {
		List<BookChapter> listBookChapter=new ArrayList<BookChapter>();
		//SQLServer
		/*String sql="SELECT TOP "+pageSize+" * FROM( "
				+ "SELECT *,ROW_NUMBER() OVER(ORDER BY chapter_id "+orderType+") AS rn FROM bookChapter) page "
				+ "WHERE book_id like '?'  AND page.rn>"+(currentPage-1)*pageSize;*/
		//MySQL
		String sql="SELECT * FROM bookChapter WHERE book_id like '?' ORDER BY chapter_id "+orderType+" LIMIT "+(currentPage-1)*pageSize+","+pageSize;
		List<Map<String,Object>> mapList=DBUtils.queryList(sql, keyWord);
		int size=mapList.size();
		if(size!=0&&!mapList.isEmpty()){
			//当查询到内容时
			BookChapter bookChapter=null;
			for(int i=0;i<size;i++){
				Map<String,Object> map=mapList.get(i);
				if(size!=0&&!map.isEmpty()){
					bookChapter=new BookChapter();
					//Chapter
					bookChapter.setBook_id((Integer)map.get("book_id"));
					bookChapter.setTime((Date)map.get("time"));
					bookChapter.setChapter_id((Integer)map.get("chapter_id"));				
					
					listBookChapter.add(bookChapter);
				}
			}
		}
		return listBookChapter;
		
	}

	@Override
	public BookChapter mapToBean(Map<String, Object> map) {
		BookChapter bookChapter=null;
		int size=map.size();  //获取map集合大小
		if(size!=0&&!map.isEmpty()){
			for(int i=0;i<size;i++){
				bookChapter=new BookChapter();
				//Chapter
				bookChapter.setBook_id((Integer)map.get("book_id"));
				bookChapter.setTime((Date)map.get("time"));
				//Content
				BookContent bookContent=new BookContent();
				bookContent.setChapter_id((Integer)map.get("chapter_id"));
				bookContent.setP_id((Integer)map.get("p_id"));
				bookContent.setContents((String)map.get("contents"));
				bookChapter.setBookcontent(bookContent);
			}
		}
		return bookChapter;
	}

	@Override
	public List<BookChapter> findById(int book_id,int chapter_id) {
		List<BookChapter> listBookChapter=new ArrayList<BookChapter>();
		//SQLServer
		String sql="SELECT * FROM bookChapter bch "
				+ "LEFT JOIN bookContent bco "
				+ "ON bch.book_id=bco.book_id AND bch.chapter_id=bco.chapter_id "
				+ "WHERE bch.book_id=? AND bch.chapter_id=?";
		//
		List<Map<String,Object>> mapList=DBUtils.queryList(sql, book_id, chapter_id);
		int size=mapList.size();
		if(size!=0&&!mapList.isEmpty()){
			//当查询到内容时
			BookChapter bookChapter=null;
			for(int i=0;i<size;i++){
				Map<String,Object> map=mapList.get(i);
				bookChapter=this.mapToBean(map);
				listBookChapter.add(bookChapter);
			}
		}
		return listBookChapter;
	}
	
	

	@Override
	public Integer getAllCountBean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookChapter findById(Integer beanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(int book_id) {
		Long count=0l;
		String sql="SELECT COUNT(*) AS total FROM bookChapter WHERE book_id=?";
		count=(Long)DBUtils.query(sql, book_id).get("total");
		return count;
	}

	@Override
	public List<BookChapter> findByBookId(int book_id) {
		List<BookChapter> listBookChapter=new ArrayList<BookChapter>();
		//SQLServer
		String sql="SELECT * FROM bookChapter bch "
				+ "WHERE book_id=?";
		//
		List<Map<String,Object>> mapList=DBUtils.queryList(sql, book_id);
		int size=mapList.size();
		if(size!=0&&!mapList.isEmpty()){
			//当查询到内容时
			BookChapter bookChapter=null;
			for(int i=0;i<size;i++){
				Map<String,Object> map=mapList.get(i);
				bookChapter=new BookChapter();
				bookChapter.setBook_id((Integer) map.get("book_id"));
				bookChapter.setChapter_id((Integer) map.get("chapter_id"));
				bookChapter.setTime((Date) map.get("time"));
				listBookChapter.add(bookChapter);
			}
		}
		return listBookChapter;
	}


}
