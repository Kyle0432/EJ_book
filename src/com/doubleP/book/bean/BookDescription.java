package com.doubleP.book.bean;
/**
 * 书籍详情类
 * @author JackieL&EvanC
 *
 */
public class BookDescription {
	/** 书籍id */
	private int book_id;
	/** 书籍类型id */
	private int type_id;
	/** 书籍章节总数 */
	private int chapter_count;
	/** 书籍状态 */
	private String status;
	/** 书籍简介 */
	private String explain;
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getChapter_count() {
		return chapter_count;
	}
	public void setChapter_count(int chapter_count) {
		this.chapter_count = chapter_count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	
	
}
