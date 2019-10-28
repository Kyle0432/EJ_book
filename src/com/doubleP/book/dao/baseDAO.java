package com.doubleP.book.dao;

import java.util.List;
import java.util.Map;

/**
 * 公共接口类，里面写好了公共的方法，由其他类继承实现
 * @author JackieL&EvanC
 *
 */
public interface baseDAO<T,K> {
	/**
	 * 增加方法
	 * @param bean bean包中的类
	 * @return true增加成功，false增加失败
	 */
	public boolean doCreat(T bean);
	
	/**
	 * 删除方法
	 * @param id 删除的id号
	 * @return true删除成功，false删除失败
	 */
	public boolean doRemove(K id);
	
	/**
	 * 修改方法
	 * @param bean 要修改的类
	 * @return true修改成功，false修改失败
	 */
	public boolean doUpdate(T bean);
	
	/**
	 * 查询分页方法
	 * @param currentPage 每一页的数目
	 * @param pageSize 某页
	 * @param keyWord 关键字
	 * @param orderType 排序类型
	 * @return 返回查询的列表
	 */
	public List<T> findAll(int currentPage,int pageSize,String keyWord,String orderType);	
	
	
	/**
	 * 将查询到的List<Map<String,Object>>集合转为bean类
	 * @param bean bean包里面的类
	 * @return 返回类对象信息
	 */
	public T mapToBean(Map<String,Object> map);
	
	/**
	 * 根据id查询对象信息
	 * @param beanid id
	 * @return 返回的对象类型
	 */
	public T findById(K beanId);
	
	/**
	 * 得到查询行数
	 * @return 返回一个整数
	 */
	public K getAllCountBean();
}
