package com.doubleP.book.action;

import com.doubleP.book.bean.UserDescription;
import com.doubleP.book.biz.UserDescriptionBiz;
import com.doubleP.book.biz.impl.UserDescriptionBizImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserDescriptionAction extends ActionSupport implements
		ModelDriven<UserDescription> {
	
	/** 用户详情类属性 */
	private UserDescription userdescription=new UserDescription();
	/** action返回信息  */
	private String message;
	/** 业务逻辑层接口类属性 */
	private UserDescriptionBiz biz;
	
	
	
	public UserDescription getUserdescription() {
		return userdescription;
	}
	public void setUserdescription(UserDescription userdescription) {
		this.userdescription = userdescription;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 构造方法，实例化业务逻辑层，方便调用业务层的方法
	 */
	public UserDescriptionAction(){
		this.biz=new UserDescriptionBizImpl();
	}
	@Override
	public UserDescription getModel() {
		// TODO Auto-generated method stub
		return userdescription;
	}
	
	/**
	 * 用户添加详情
	 * @return 
	 */
	public String addDescription(){
		boolean flag=this.biz.creatUserDescription(userdescription);
		if(flag){
			//添加成功
			message="信息添加成功!";
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	/**
	 * 用户修改详情
	 * @return
	 */
	public String updateDescription(){
		boolean flag=this.biz.updateUserDescription(userdescription);
		if(flag){
			//修改成功
			message="信息修改成功";
			return SUCCESS;
		}else{
			message="数据请求错误!";
			return ERROR;
		}
	}
	
	/**
	 * 根据用户id查询用户详情
	 * @return
	 */
	public String findById(){
		userdescription=this.biz.findById(userdescription.getUser_id());
		if(userdescription!=null){
			ActionContext.getContext().getValueStack().push(userdescription);  //将查询到的用户详情类对象放入栈顶
			message=SUCCESS;
		}else{
			message=INPUT;
		}
		return message;
	}
}
