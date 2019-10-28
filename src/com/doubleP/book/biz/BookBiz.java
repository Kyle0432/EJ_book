package com.doubleP.book.biz;

import java.util.List;

import com.doubleP.book.bean.Book;

public interface BookBiz {
	
	/**
	 * 查询出所有的书籍。分页操作
	 * @param currentPage 每页的数据量
	 * @param pageSize 页数
	 * @param keyWord 关键字
	 * @param orderType 排序类型
	 * @return
	 */
	public List<Book> findAll(int currentPage, int pageSize, String keyWord,
			String orderType);
	
	/**
	 * 根据id查询书籍信息
	 * @param beanId 书id
	 * @return 返回book对象
	 */
	public Book findById(Integer book_id);
	
	/**
	 * 获取总数
	 * @param book_id 书籍id
	 * @return 返回长整型数量
	 */
	public Long getAllCount(String keyWord);
}
