package com.syears.services.merchant.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syears.commons.vo.merchant.MerchantUserVO;
import com.syears.data.dao.merchant.MerchantDAO;
import com.syears.data.models.MerchantUserEntity;
import com.syears.services.impl.MongoServiceImpl;
import com.syears.services.merchant.MerchantService;

@Service("merchantService")
public class MerchantServiceImpl extends MongoServiceImpl<MerchantUserEntity, MerchantUserVO>implements MerchantService{

	@Autowired
	public MerchantServiceImpl(MerchantDAO merchantDAO) {
		super(merchantDAO);
	}
}
