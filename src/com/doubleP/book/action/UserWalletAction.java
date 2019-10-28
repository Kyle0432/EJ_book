package com.doubleP.book.action;


import com.doubleP.book.bean.UserWallet;
import com.doubleP.book.biz.UserWalletBiz;
import com.doubleP.book.biz.impl.UserWalletBizImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户钱包Action
 * @author JackieL&EvanC
 *
 */
public class UserWalletAction extends ActionSupport implements ModelDriven<UserWallet>{
	
	/** 用户钱包类属性 */
	private UserWallet userwallet=new UserWallet();
	/** Action返回信息  */
	private String message;
	/** userwallet业务逻辑层接口类属性  */
	private UserWalletBiz biz;
	
	
	public UserWallet getUserwallet() {
		return userwallet;
	}

	public void setUserwallet(UserWallet userwallet) {
		this.userwallet = userwallet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 构造方法
	 */
	public UserWalletAction(){
		this.biz=new UserWalletBizImpl();
	}
	
	@Override
	public UserWallet getModel() {
		// TODO Auto-generated method stub
		return userwallet;
	}
	
	/**
	 * 充值
	 * @return
	 */
	public String addWallet(){
		boolean flag=this.biz.updateUser_wallet(userwallet);
		if(flag){
			//充值成功
			message="充值成功!";
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	/**
	 * 查询用户账户余额
	 * @return
	 */
	public String findById(){
		userwallet=this.biz.findById(userwallet.getUser_id());
		if(userwallet!=null){
			//查询到数据时
			ActionContext.getContext().getValueStack().push(userwallet);  //将查询到的用户详情类对象放入栈顶
			message=SUCCESS;
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
