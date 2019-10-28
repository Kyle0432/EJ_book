package com.doubleP.book.bean;

import java.util.Date;

/**
 * 书籍章节类
 * @author JackieL&EvanC
 *
 */
public class BookChapter {
	
	/** 书籍id */
	private int book_id;
	/** 书籍章节id */
	private int chapter_id;
	/**  书籍内容类属性  */
	private BookContent bookcontent;
	/** 更新时间 */
	private Date time;
	
	public BookContent getBookcontent() {
		return bookcontent;
	}
	public void setBookcontent(BookContent bookcontent) {
		this.bookcontent = bookcontent;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getChapter_id() {
		return chapter_id;
	}
	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
