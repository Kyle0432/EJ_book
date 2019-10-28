package com.doubleP.book.action;

import java.util.List;

import com.doubleP.book.bean.BookDescription;
import com.doubleP.book.biz.BookDescriptionBiz;
import com.doubleP.book.biz.impl.BookDescriptionBizImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BookDescriptionAction extends ActionSupport implements
		ModelDriven<BookDescription> {
	/** 书籍详情类属性 */
	private BookDescription bookDescription=new BookDescription();
	/** 每页的数据量 */
	private int currentPage;
	/** 页数 */
	private int pageSize;
	/** 总页数 */
	private int totalPages;
	/** 关键字 */
	private String keyWord;
	/** 1为升序，2为降序,默认为升序*/
	private String orderType;
	/** 决定不同的排序类型属性 */
	private int order;
	/** 返回到配置的信息，对应不同的处理 */
	private String message;
	/** 书籍业务逻辑层接口类属性 */
	private BookDescriptionBiz biz;
	
	
	public BookDescription getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(BookDescription bookDescription) {
		this.bookDescription = bookDescription;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BookDescriptionAction(){
		this.biz=new BookDescriptionBizImpl();
	}
	@Override
	public BookDescription getModel() {
		// TODO Auto-generated method stub
		return bookDescription;
	}
	
	/**
	 * 根据书籍id查询书籍详情
	 * @return 
	 */
	public String findById(){
		bookDescription=this.biz.findById(bookDescription.getBook_id());
		if(bookDescription!=null){
			ActionContext.getContext().getValueStack().push(bookDescription);  //将查询成功的对象放入栈顶
			return SUCCESS;
		}else{
			message="数据请求错误";
			return INPUT;
		}
	}
}
