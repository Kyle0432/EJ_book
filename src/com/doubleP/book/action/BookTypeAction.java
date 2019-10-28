package com.doubleP.book.action;

import java.util.ArrayList;
import java.util.List;

import com.doubleP.book.bean.BookType;
import com.doubleP.book.biz.BookTypeBiz;
import com.doubleP.book.biz.impl.BookTypeBizImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BookTypeAction extends ActionSupport implements ModelDriven<BookType> {
	private BookType bookType=new BookType();
	private List<BookType> bookTypeList=new ArrayList<BookType>();
	private String message;
	private BookTypeBiz biz;
	
	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<BookType> getBookTypeList() {
		return bookTypeList;
	}

	public void setBookTypeList(List<BookType> bookTypeList) {
		this.bookTypeList = bookTypeList;
	}

	public BookTypeBiz getBiz() {
		return biz;
	}

	public void setBiz(BookTypeBiz biz) {
		this.biz = biz;
	}

	@Override
	public BookType getModel() {
		return bookType;
	}
	
	public BookTypeAction(){
		biz=new BookTypeBizImpl();
	}
	
	public String findAll(){
		bookTypeList=this.biz.findAll();
		if(bookTypeList!=null){
			message="查询成功";
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String findById(){
		bookType=this.biz.findById(bookType.getType_id());
		if(bookType!=null){
			message="查询成功";
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
}
