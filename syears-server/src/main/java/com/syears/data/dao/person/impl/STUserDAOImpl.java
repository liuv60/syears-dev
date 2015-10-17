package com.syears.data.dao.person.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.syears.commons.vo.person.STUserVO;
import com.syears.controllers.params.person.UserParams;
import com.syears.data.dao.person.STUserDAO;

import com.syears.commons.OrderNoGenerator;

import com.syears.data.support.IdGenerator;

import com.syears.data.models.person.STUserEntity;

@Repository("STUserDAO")
public class STUserDAOImpl implements STUserDAO {

	@Resource
	private IdGenerator idGenerator;

	@Resource
	private SqlSession sqlSession;
	
	@Override
	public STUserVO insert(STUserVO user) {
		STUserEntity userEntity = createEntity(user);
		long no = idGenerator.next(SEQ_STUSER);
		String userNo = OrderNoGenerator.orderNo(no);  //暂时如此
		userEntity.setUserid(userNo);
		
		int ret= sqlSession.insert("createUser", userEntity);
		if (ret == 0)
		{
			return null;
		}
		user.setUserid(userEntity.getUserid());
		return user;
	}
	
	@Override
    public STUserVO getUser(UserParams params)   //获取用户信息
    {
    	STUserEntity userEntity = sqlSession.selectOne("getUser", params);
    	return convertToVO(userEntity, STUserEntity.class, STUserVO.class);
    }
	
	@Override
    public int deleteUser(String username)  //删除用户，逻辑型
    {
    	return sqlSession.update("deleteUser", username);
    	
    }
    @Override
    public STUserVO findUserById(String userid)  //通过用户编号查找用户
    {
    	STUserEntity userEntity = sqlSession.selectOne("findUserById", userid);
    	return convertToVO(userEntity, STUserEntity.class, STUserVO.class);
    
    }
    @Override
    public STUserVO findUserByName(String username) //用户用户名称查找用户
    {
      	STUserEntity userEntity = sqlSession.selectOne("findUserById", username);
    	return convertToVO(userEntity, STUserEntity.class, STUserVO.class);
  
    }
    @Override
    public int countAll()  //统计所有用户
    {
    	return 0;
    	//List<Object> lenO = sqlSession.selectList("countAll");
		//return Integer.parseInt(lenO.get(0).toString());
    }
    @Override
    public int countUser(String username) //统计用户数，判断是否有该用户
    {
     	return 0;
    	//List<Object> lenO = sqlSession.selectList("countUser", username);
    	//return Integer.parseInt(lenO.get(0).toString());
    }
    @Override
    public int updatePassword(UserParams params)  //修改密码
    {
    	return sqlSession.update("updatePassword", params);
    	
    }
    @Override
    public int updateUserName(String username)    //修改用户名称
    {
    	return sqlSession.update("updateUserName", username);
    }
	
	
	
	private STUserEntity createEntity(STUserVO user) {
		STUserEntity userEntity = new STUserEntity();
		
		userEntity.setUserid(user.getUserid());
		
		userEntity.setUsername(user.getUsername());
		
		userEntity.setFullname(user.getFullname());
		
		userEntity.setTel(user.getTel());
		
		userEntity.setQq(user.getQq());
		
		userEntity.setWeixin(user.getWeixin());
		
		userEntity.setPassword(user.getPassword());
		
		userEntity.setSex(user.getSex());
		
		userEntity.setRegdate(user.getRegdate());
		
		userEntity.setPersonid(user.getPersonid());
		return userEntity;
	}
/*
	private STUserVO createObject(STUserEntity userEntity) {
		STUserVO user = new STUserVO();
		
		user.setUserid(userEntity.getUserid());
		
		user.setUsername(userEntity.getUsername());
		
		user.setFullname(userEntity.getFullname());
		
		user.setTel(userEntity.getTel());
		
		user.setQq(userEntity.getQq());
		
		user.setWeixin(userEntity.getWeixin());
		
		user.setPassword(userEntity.getPassword());
		
		user.setSex(userEntity.getSex());
		
		user.setRegdate(userEntity.getRegdate());
		
		user.setPersonid(userEntity.getPersonid());


		return user;
	}
*/
}
