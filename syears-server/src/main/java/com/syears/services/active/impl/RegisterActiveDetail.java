package com.syears.services.active.impl;

import java.util.Date;
import java.util.Map;

import com.syears.commons.vo.ActiveVO;
import com.syears.commons.vo.client.ClientUserVO;
import com.syears.commons.vo.server.CouponsVO;
import com.syears.data.dao.server.CouponsDAO;
import com.syears.services.active.ActiveDetail;

public class RegisterActiveDetail implements ActiveDetail {

	@Override
	public Object active(ActiveVO active, Map<String, Object> pramsMap, CouponsDAO couponsDAO) {
		// TODO Auto-generated method stub
		//得到用户
		ClientUserVO user  = (ClientUserVO) pramsMap.get("userVO");
		//判定用户是否满足活动条件

		//
		if (active.getActiveType() != 1) {
			// 非注册是活动
		}

		int type = 1;
		switch (type) {
		case 1:

			break;
		case 2:

			break;

		default:
			break;
		}
		if (active.getCouponsType() == 1) {// 发放优惠券
			// 调用优惠券方法接口完成
			CouponsVO cv = new CouponsVO();

			cv.setUserId(user.getId());
			cv.setCreateTime(new Date().getTime());
			cv.setIfAll(active.isIfAll());
			cv.setStatus(0);
			cv.setValidityTime(active.getValidityTime());
			cv.setCouponsTypeId(active.getCouponsTypeId());
			cv.setUpdateTime(new Date().getTime());
			cv.setKitchenId("");
			couponsDAO.insert(cv);
		} else if (active.getCouponsType() == 2) {// 减免返现 不符合注册时逻辑

		}
		return null;
	}

}
