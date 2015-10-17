package com.syears.services.person.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.syears.commons.vo.person.STUserVO;
import com.syears.data.dao.person.STUserDAO;
import com.syears.services.person.STUserService;
import com.syears.controllers.params.person.UserParams;

@Service
public class STUserServiceImpl implements STUserService {

	@Resource
	private STUserDAO userDAO;
	@Override
	public STUserVO createUser(STUserVO user) {
		return userDAO.insert(user);
	}
	
	@Override
	public STUserVO getUserInfo(String username, String password)
	{
		UserParams params = new UserParams();
		params.setUserName(username);
		params.setPassword(password);
		params.setUserStatus(1); //默认为在用的用户
		return userDAO.getUser(params);
	}

}
