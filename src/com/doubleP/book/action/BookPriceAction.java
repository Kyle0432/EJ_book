package com.doubleP.book.action;

import com.doubleP.book.bean.BookPrice;
import com.doubleP.book.biz.BookPriceBiz;
import com.doubleP.book.biz.impl.BookPriceBizImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BookPriceAction extends ActionSupport implements
		ModelDriven<BookPrice> {
	/** 书籍价钱类属性 */
	private BookPrice bookPrice=new BookPrice();
	/** 返回到配置的信息，对应不同的处理 */
	private String message;
	/** 书籍业务逻辑层接口类属性 */
	private BookPriceBiz biz;
	
	
	public BookPrice getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(BookPrice bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BookPriceAction(){
		this.biz=new BookPriceBizImpl();
	}
	@Override
	public BookPrice getModel() {
		// TODO Auto-generated method stub
		return bookPrice;
	}
	
	/**
	 * 根据书籍id查询书价钱
	 * @return
	 */
	public String findById(){
		bookPrice=this.biz.findById(bookPrice.getBook_id());
		if(bookPrice!=null){
			ActionContext.getContext().getValueStack().push(bookPrice);  //将查询到的用户详情类对象放入栈顶
			message=SUCCESS;
		}else{
			message=INPUT;
		}
		return message;
	}
}
