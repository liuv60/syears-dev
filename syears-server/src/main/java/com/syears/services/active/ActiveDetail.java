package com.syears.services.active;

import java.util.Map;

import com.syears.commons.vo.ActiveVO;
import com.syears.data.dao.server.CouponsDAO;

public interface ActiveDetail {

	public Object active(ActiveVO active,Map<String,Object> pramsMap,CouponsDAO couponsDAO);
}
