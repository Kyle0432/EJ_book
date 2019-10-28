package com.doubleP.book.action;

import java.util.Map;

import com.doubleP.book.bean.User;
import com.doubleP.book.biz.UserBiz;
import com.doubleP.book.biz.impl.UserBizImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户类Action
 * @author JackieLEvanC
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	/** 用户类 */
	private User user=new User();
	/** UserBiz对象 */
	private UserBiz biz;
	/** 返回信息 */
	private String message;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	public UserAction(){
		this.biz=new UserBizImpl();
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		user=this.biz.login(user);
		Map<String, Object>  session=ActionContext.getContext().getSession();
		if(user!=null){
			ActionContext.getContext().getValueStack().push(user);  //将登录成功的对象放入栈顶
			session.put("user", user);  //将登录的用户保存到session中
			//登录成功
			message=SUCCESS;
			return message;
		}else{
			message="用户名或密码错误!";
			return INPUT;
		}
	}
	
	/**
	 * 在注册时判断用户名是否重复
	 * @return
	 */
	public String judge(){
		boolean flag=true;  //默认为true
		flag=this.biz.judgeUsername(user.getUsername());
		try{
			if(!flag){
				/**
				 * 当返回值为true时，说明查询到重复的用户，则无法进行之后的操作
				 * 所以只有当返回值为False的时候才能执行之后的操作
				 */
				if(user.getUsername().length()>=6 && user.getUsername().length()<=16){
					message="用户名可以使用！";
				}else{
					message="用户名必须是6到16个字符！";
				}
			}else{
				message="用户名重复！";
			}
			return SUCCESS;
		}catch(Exception e){
			return INPUT;
		}	
	}
	
	/**
	 * 注销 
	 * @return
	 */
	public String logout(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;
	}
	
	/**
	 * 注册
	 * @return
	 */
	public String register(){
		boolean flag=false; //默认为false
		flag=this.biz.register(user);  //执行登录，并将返回结果赋值给flag
		if(flag){
			//注册成功
			message="registerSuccess";
		}
		return message;
	}
}
