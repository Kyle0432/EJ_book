package com.doubleP.book.bean;

/***
 * 用户所购买的书籍类
 * @author JackieL&EvanC
 *
 */
public class BuyBook {
	
	/** 用户id */
	private int user_id;
	/** 书籍id */
	private int book_id;
	/** 书籍信息 */
	private Book book;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
}
