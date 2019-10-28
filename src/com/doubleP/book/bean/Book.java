package com.doubleP.book.bean;

/**
 * 书类
 * @author JackieL&EvanC
 *
 */
public class Book {
	
	/** 书籍id */
	private int book_id;
	/** 书籍名称 */
	private String book_name;
	/** 作者姓名 */
	private String alternate_name;
	/** 书籍详情类属性 */
	private	BookDescription bookdescription;
	/** 书籍类型类属性 */
	private BookType booktype;
	/** 海报    */
	private String poster;
	/** 该书是否上架0为没有上架，1为上架 */
	private int is_Valid;
	
	public BookType getBooktype() {
		return booktype;
	}
	public void setBooktype(BookType booktype) {
		this.booktype = booktype;
	}
	public BookDescription getBookdescription() {
		return bookdescription;
	}
	public void setBookdescription(BookDescription bookdescription) {
		this.bookdescription = bookdescription;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAlternate_name() {
		return alternate_name;
	}
	public void setAlternate_name(String alternate_name) {
		this.alternate_name = alternate_name;
	}
	public int getIs_Valid() {
		return is_Valid;
	}
	public void setIs_Valid(int is_Valid) {
		this.is_Valid = is_Valid;
	}
}
