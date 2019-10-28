package com.doubleP.book.action;

import java.util.List;

import com.doubleP.book.bean.BuyBook;
import com.doubleP.book.biz.BuyBookBiz;
import com.doubleP.book.biz.impl.BuyBookBizImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BuyBookAction extends ActionSupport implements
		ModelDriven<BuyBook> {
	/** 购买书籍类属性 */
	private BuyBook buyBook=new BuyBook();
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
	/** List<BuyBook>用于保存查询到的信息 */
	private List<BuyBook> buyBookList;
	/** 书籍业务逻辑层接口类属性 */
	private BuyBookBiz biz;
	
	
	public BuyBook getBuyBook() {
		return buyBook;
	}
	public void setBuyBook(BuyBook buyBook) {
		this.buyBook = buyBook;
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
	public List<BuyBook> getBuyBookList() {
		return buyBookList;
	}
	public void setBuyBookList(List<BuyBook> buyBookList) {
		this.buyBookList = buyBookList;
	}
	public BuyBookAction(){
		this.biz=new BuyBookBizImpl();
	}
	@Override
	public BuyBook getModel() {
		// TODO Auto-generated method stub
		return buyBook;
	}
	
	/**
	 * 查询分页
	 * @return
	 */
	public String findAll(){
		totalPages = (int)Math.ceil((double)this.biz.getAllCount(buyBook.getUser_id())/pageSize);
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
		buyBookList=this.biz.findAll(currentPage, pageSize, keyWord, orderType);
		int size=buyBookList.size();
		if(size!=0&&!buyBookList.isEmpty()){
			//当查询到信息时
			return SUCCESS;
		}else{
			message="数据请求错误!";
			return INPUT;
		}	
	}
}
