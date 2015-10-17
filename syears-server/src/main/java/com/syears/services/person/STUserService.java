package com.syears.services.person;

import com.syears.commons.vo.person.STUserVO;
import com.syears.controllers.params.person.UserParams;

public interface STUserService {
	

	STUserVO createUser(STUserVO order);
	
	STUserVO getUserInfo(String username, String password);

}
