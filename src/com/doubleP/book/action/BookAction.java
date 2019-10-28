package com.doubleP.book.action;

import java.util.List;

import com.doubleP.book.bean.Book;
import com.doubleP.book.biz.BookBiz;
import com.doubleP.book.biz.impl.BookBizImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BookAction extends ActionSupport implements ModelDriven<Book> {
	/** 书籍类属性 */
	private Book book=new Book();
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
	/** List<Book>用于保存查询到的信息 */
	private List<Book> bookList;
	/** 书籍业务逻辑层接口类属性 */
	private BookBiz biz;
	
	public BookAction(){
		this.biz=new BookBizImpl();
	}
	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
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


	public List<Book> getBookList() {
		return bookList;
	}


	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}


	@Override
	public Book getModel() {
		// TODO Auto-generated method stub
		return book;
	}

	/**
	 * 查询分页
	 * @return
	 */
	public String findAll(){
		totalPages = (int)Math.ceil((double)this.biz.getAllCount(keyWord)/pageSize);
		if(currentPage==0||currentPage>totalPages){
			//当首次进入页面时的currentPage为0并且当也在第三页时currentPage无法在往上加，则此时需要将currentPage值改为1
			currentPage = 1;
		}
		if(order==1){
			//当为1时，类型为降序
			orderType="desc";
		}else{
			orderType="asc";
		}
		bookList=this.biz.findAll(currentPage, pageSize, keyWord, orderType);
		int size=bookList.size();
		if(size!=0&&!bookList.isEmpty()){
			//当查询到信息时
			return SUCCESS;
		}else{
			message="数据请求错误!";
			return INPUT;
		}	
	}
	
	public String findById(){
		book=this.biz.findById(book.getBook_id());
		if(book!=null){
			return SUCCESS;
		}else{
			message="数据请求错误!";
			return INPUT;
		}
	}
}
