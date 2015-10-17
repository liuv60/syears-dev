package com.syears.data.dao.merchant.impl;

import org.springframework.stereotype.Repository;

import com.syears.commons.vo.merchant.MerchantUserVO;
import com.syears.data.dao.impl.MongoBaseDAOImpl;
import com.syears.data.dao.merchant.MerchantDAO;
import com.syears.data.models.MerchantUserEntity;

@Repository("merchantDAO")
public class MerchantDAOImpl extends MongoBaseDAOImpl<MerchantUserEntity, MerchantUserVO, String> implements MerchantDAO{

	public Class<MerchantUserEntity> getEntityClass() {
		return MerchantUserEntity.class;
	}

	public Class<MerchantUserVO> getVOClass() {
		return MerchantUserVO.class;
	}
	
}
