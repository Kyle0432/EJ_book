package com.doubleP.book.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.doubleP.book.bean.Book;
import com.doubleP.book.bean.BookDescription;
import com.doubleP.book.bean.BookType;
import com.doubleP.book.dao.BookDAO;
import com.doubleP.book.util.DBUtils;

public class BookDAOImpl implements BookDAO {

	@Override
	public boolean doCreat(Book bean) {
		String sql="INSERT INTO book (book_name,alternate_name,poster,is_valid) VALUES (?,?,?,?)";
		boolean flag=DBUtils.update(sql, bean.getBook_name(),bean.getAlternate_name(),bean.getPoster(),bean.getIs_Valid());
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		String sql="UPDATE book SET is_valid=0 WHERE book_id=?";
		boolean flag=DBUtils.update(sql, id);
		return flag;
	}

	@Override
	public boolean doUpdate(Book bean) {
		String sql="UPDATE book SET book_name=? AND alternate_name AND poster=? WHERE book_id=?";
		boolean flag=DBUtils.update(sql, bean.getBook_name(),bean.getAlternate_name(),bean.getPoster(),bean.getBook_id());
		return flag;
	}

	@Override
	public List<Book> findAll(int currentPage, int pageSize, String keyWord,
			String orderType) {
		List<Book> bookList=null;
		/*String sql="SELECT TOP "+pageSize+" * FROM (SELECT *,ROW_NUMBER() OVER (ORDER BY book_id "+orderType+") AS rn FROM book) bookPage "
				   +" LEFT JOIN bookDescription AS bd"
				   +" ON bookPage.book_id=bd.book_id"
				   +" LEFT JOIN bookType AS bt"
				   +" ON bd.type_id=bt.type_id"
				   +" WHERE (bookPage.book_name LIKE '%"+keyWord+"%' OR bookPage.alternate_name LIKE '%"+keyWord+"%' OR bd.status LIKE '%"+keyWord+"%' OR bt.type_name LIKE '%"+keyWord+"%') "
				   +" AND bookPage.is_valid=1 "
				   +" AND rn>"+(currentPage-1)*pageSize;*/
		String sql="SELECT * from book bookPage "
				   +" LEFT JOIN bookDescription bd"
				   +" ON bookPage.book_id=bd.book_id"
				   +" LEFT JOIN bookType bt"
				   +" ON bd.type_id=bt.type_id"
				   +" WHERE (bookPage.book_name LIKE '%"+keyWord+"%' OR bookPage.alternate_name LIKE '%"+keyWord+"%' OR bd.status LIKE '%"+keyWord+"%' OR bt.type_name LIKE '%"+keyWord+"%') "
				   +" AND bookPage.is_valid=1 ORDER BY bookPage.book_id "+orderType+" LIMIT "+(currentPage-1)*pageSize+","+pageSize;
		List<Map<String,Object>> mapList=DBUtils.queryList(sql);
		if(mapList.size()!=0&&!mapList.isEmpty()){
			//当确定查询到数据时,实例化list
			bookList=new ArrayList<Book>();
			for(int i=0;i<mapList.size();i++){
				Map<String,Object> map=mapList.get(i);
				Book book=this.mapToBean(map);
				bookList.add(book);
			}
		}
		return bookList;
	}

	@Override
	public Book mapToBean(Map<String, Object> map) {
		int size=map.size();   //获取查询到的map集合大小，用于判断
		Book book=null;
		BookDescription bookdescription=null;
		BookType booktype=null;
		if(size!=0&&!map.isEmpty()){
			/**
			 * 当判断到map集合里有内容时
			 * 进行遍历存取
			 */
			for(int i=0;i<size;i++){
				book=new Book();
				bookdescription=new BookDescription();
				booktype=new BookType();
				bookdescription.setChapter_count((Integer)map.get("chapter_count"));
				bookdescription.setExplain((String)map.get("explain"));
				bookdescription.setStatus((String)map.get("status"));
				bookdescription.setType_id((Integer)map.get("type_id"));
				book.setBookdescription(bookdescription);
				booktype.setType_name((String)map.get("type_name"));
				book.setBooktype(booktype);
				book.setBook_id((Integer)map.get("book_id"));
				book.setBook_name((String)map.get("book_name"));
				book.setAlternate_name((String)map.get("alternate_name"));
				book.setPoster((String)map.get("poster"));
				book.setIs_Valid((Integer)map.get("is_valid"));
			}
		}
		return book;
	}

	@Override
	public Book findById(Integer beanId) {
		String sql="SELECT * FROM book AS b"
				   +" LEFT JOIN bookDescription AS bd"
				   +" ON b.book_id=bd.book_id"
				   +" LEFT JOIN bookType AS bt"
				   +" ON bt.type_id=bd.type_id"
				   +" WHERE bd.book_id=?";
	    Map<String,Object> map=DBUtils.query(sql, beanId);
		Book book=this.mapToBean(map);		   
		return book;
	}

	@Override
	public Integer getAllCountBean() {
		String sql="SELECT COUNT(book_id) FROM book WHERE 0=0";
		int count=(Integer)DBUtils.query(sql).get("count");
		return count;
	}

	@Override
	public Long getAllCount(String keyWord) {
		Long count=0l;
		String sql="SELECT COUNT(*) AS total FROM book WHERE book_name LIKE '%"+keyWord+"%' OR alternate_name LIKE '%"+keyWord+"%'";
		count=Long.parseLong(DBUtils.query(sql).get("total").toString());
		return count;
	}

}
