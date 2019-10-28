package com.doubleP.book.bean;

/**
 * 书籍段落类
 * @author JackieL&EvanC
 *
 */
public class BookP {
	
	/** 书籍id */
	private int book_id;
	/** 书籍章节id */
	private int chapter_id;
	/** 段落id */
	private int p_id;
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
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
}
