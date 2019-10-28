package com.doubleP.book.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.doubleP.book.bean.UserDescription;
import com.doubleP.book.dao.UserDescriptionDAO;
import com.doubleP.book.util.DBUtils;

/**
 * 用户详情实现类
 * @author JackieL&EvanC
 *
 */
public class UserDescriptionDAOImpl implements UserDescriptionDAO {

	@Override
	public boolean doCreat(UserDescription bean) {
		boolean flag=false; //默认返回值为false
		Timestamp ts=null;
		if(bean.getBirthday()!=null){
			ts=new Timestamp(bean.getBirthday().getTime());
		}
		String sql="INSERT INTO  userDescription (user_id,nickname,gender,birthday,explain) VALUES (?,?,?,?,?)";
		flag=DBUtils.update(sql, bean.getUser_id(),bean.getNickname(),bean.getGender(),ts,bean.getExplain());
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		// TODO Auto-generated method stub
		/**
		 * 此方法暂未实现
		 */
		return false;
	}

	@Override
	public boolean doUpdate(UserDescription bean) {
		boolean flag=false;
		Timestamp ts=null;
		if(bean.getBirthday()!=null){
			ts=new Timestamp(bean.getBirthday().getTime());
		}
		String sql="UPDATE userDescription SET nickname=?,gender=?,birthday=?,explain=? WHERE user_id=?";
		flag=DBUtils.update(sql, bean.getNickname(),bean.getGender(),ts,bean.getExplain(),bean.getUser_id());
		return flag; 
	}

	@Override
	public List<UserDescription> findAll(int currentPage, int pageSize,
			String keyWord, String orderType) {
		// TODO Auto-generated method stub
		/**
		 * 此方法暂未实现
		 */
		return null;
	}

	@Override
	public UserDescription mapToBean(Map<String, Object> map) {
		int size=map.size();  //获取保存的map集合的size
		UserDescription userdescription=null;
		if(size!=0&&!map.isEmpty()){
			//当确定map集合里面查询到内容时将信息存入对象中
			userdescription=new UserDescription();
			userdescription.setUser_id((Integer)map.get("user_id"));
			userdescription.setNickname((String)map.get("nickname"));
			userdescription.setGender((String)map.get("gender"));
			userdescription.setBirthday((Date)map.get("birthday"));
			userdescription.setExplain((String)map.get("explain"));
			userdescription.setYear_old(Integer.parseInt(map.get("year_old").toString()));
		}
		return userdescription;
	}

	@Override
	public UserDescription findById(Integer beanId) {
		String sql="SELECT *,FLOOR(DATEDIFF(DAY,(SELECT birthday FROM userDescription WHERE user_id=?),GETDATE())/365.25) AS year_old FROM userDescription WHERE user_id=?";
		Map<String,Object> map=DBUtils.query(sql, beanId,beanId);
		UserDescription userdescription=this.mapToBean(map);
		return userdescription;
	}

	@Override
	public Integer getAllCountBean() {
		// TODO Auto-generated method stub
		/**
		 * 此方法暂未实现
		 */
		return null;
	}

}
