package com.doubleP.book.action;

import java.util.List;

import com.doubleP.book.bean.MemberType;
import com.doubleP.book.biz.MemberTypeBiz;
import com.doubleP.book.biz.impl.MemberTypeBizImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MemberTypeAction extends ActionSupport implements ModelDriven<MemberType> {
	/** 会员类型对象属性 */
	private MemberType memberType=new MemberType();
	/** 列表 */
	private List<MemberType> memberTypeList;
	/** 返回信息*/
	private String message;
	/** 会员类型业务逻辑层接口类属性 */
	private MemberTypeBiz biz;
	
	
	public List<MemberType> getMemberTypeList() {
		return memberTypeList;
	}
	public void setMemberTypeList(List<MemberType> memberTypeList) {
		this.memberTypeList = memberTypeList;
	}
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MemberTypeAction(){
		this.biz=new MemberTypeBizImpl();
	}
	@Override
	public MemberType getModel() {
		// TODO Auto-generated method stub
		return memberType;
	}
	
	/**
	 * 根据会员id查询会员类型
	 * @return
	 */
	public String findById(){
		memberType=this.biz.findById(memberType.getMember_id());
		//System.out.println(memberType);
		if(memberType!=null){
			ActionContext.getContext().getValueStack().push(memberType);  //将查询成功的对象放入栈顶
			return SUCCESS;
		}else{
			message="数据请求错误";
			return INPUT;
		}
	}
	
	/**
	 * 查询所有会员类型信息
	 * @return
	 */
	public String findAll(){
		memberTypeList=this.biz.findAll();
		if(memberTypeList.size()!=0&&!memberTypeList.isEmpty()){
			return SUCCESS;
		}else{
			message="数据请求错误";
			return INPUT;
		}
	}
}
