package com.syears.services.active.impl;

import java.util.Map;

import com.syears.commons.vo.ActiveVO;
import com.syears.data.dao.server.CouponsDAO;
import com.syears.services.active.ActiveDetail;

public class BeforOrderActiveDetail implements ActiveDetail{

	@Override
	public Object active(ActiveVO active, Map<String, Object> pramsMap, CouponsDAO couponsDAO) {
		System.out.println("BeforOrderActiveDetail");
		return null;
	}

}
