package com.doubleP.book.action;

import java.util.List;

import com.doubleP.book.bean.BookContent;
import com.doubleP.book.biz.BookContentBiz;
import com.doubleP.book.biz.impl.BookContentBizImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BookContentAction extends ActionSupport implements
		ModelDriven<BookContent> {
	/** 书籍内容类属性 */
	private BookContent bookContent=new BookContent();
	/** 返回到配置的信息，对应不同的处理 */
	private String message;
	/** List<bookCotent>用于保存查询到的信息 */
	private List<BookContent> bookContentList;
	
	private Long total;
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}

	/** 书籍业务逻辑层接口类属性 */
	private BookContentBiz biz;
	
	
	public BookContent getBookContent() {
		return bookContent;
	}
	public void setBookContent(BookContent bookContent) {
		this.bookContent = bookContent;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<BookContent> getBookContentList() {
		return bookContentList;
	}
	public void setBookContentList(List<BookContent> bookContentList) {
		this.bookContentList = bookContentList;
	}
	public BookContentAction(){
		this.biz=new BookContentBizImpl();
	}
	@Override
	public BookContent getModel() {
		// TODO Auto-generated method stub
		return bookContent;
	}
	
	/**
	 * 查询分页
	 * @return
	 */
	public String findAll(){
		//System.out.println(bookContent.getBook_id()+bookContent.getChapter_id());
		total=this.biz.getCount(bookContent.getBook_id(), bookContent.getChapter_id());
		//System.out.println(total);
		bookContentList=this.biz.findAll(bookContent.getBook_id(), bookContent.getChapter_id());
		int size=bookContentList.size();
		if(size!=0&&!bookContentList.isEmpty()){
			//当查询到信息时
			return SUCCESS;
		}else{
			message="数据请求错误!";
			return INPUT;
		}	
	}
}
