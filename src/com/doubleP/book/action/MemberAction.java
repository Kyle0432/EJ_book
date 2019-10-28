package com.doubleP.book.action;

import com.doubleP.book.bean.Member;
import com.doubleP.book.biz.MemberBiz;
import com.doubleP.book.biz.impl.MemberBizImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MemberAction extends ActionSupport implements ModelDriven<Member>{
	
	/** member类属性 */
	private Member member=new Member();
	/** 返回信息 */
	private String message;
	/** 天数 */
	private int count;
	/** 业务逻辑层接口类属性 */
	private MemberBiz biz;
	
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public MemberAction(){
		this.biz=new MemberBizImpl();
	}
	@Override
	public Member getModel() {
		// TODO Auto-generated method stub
		return member;
	}
	
	/**
	 * 用户充值
	 * @return
	 */
	public String addMember(){
		boolean flag=this.biz.addMember(member, count);
		if(flag){
			//充值成功
			message="恭喜你，你现在是会员了!";
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	/**
	 * 用户续费
	 * @return
	 */
	public String renewMember(){
		boolean flag=this.biz.renew(member, count);
		if(flag){
			//充值成功
			message="续费成功!";
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	/**
	 * 根据用户id查询用户为某种类型的会员
	 * @return
	 */
	public String findById(){
		member=this.biz.findById(member.getUser_id());
		if(member!=null){
			ActionContext.getContext().getValueStack().push(member);  //将登录成功的对象放入栈顶
			return SUCCESS;
		}
		return INPUT;
	}
}
