package com.syears.data.dao.merchant.impl;

import org.springframework.stereotype.Repository;

import com.syears.commons.vo.merchant.MerchantKitchenInfoVO;
import com.syears.commons.vo.merchant.MerchantUserVO;
import com.syears.data.dao.impl.MongoBaseDAOImpl;
import com.syears.data.dao.merchant.KitchenDAO;
import com.syears.data.models.MerchantKitchenInfoEntity;
import com.syears.data.models.MerchantUserEntity;

/**
 * 
 * @title KitchenDAOImpl.java
 * @package com.youfan.data.dao.merchant.impl
 * @description 厨房信息DAO层实现
 * @author QinghaiDeng   
 * @update 2015年9月11日 下午5:15:45
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
@Repository("kitchenDAO")
public class KitchenDAOImpl extends MongoBaseDAOImpl<MerchantKitchenInfoEntity, MerchantKitchenInfoVO, String> implements KitchenDAO{

	public Class<MerchantKitchenInfoEntity> getEntityClass() {
		return MerchantKitchenInfoEntity.class;
	}

	public Class<MerchantKitchenInfoVO> getVOClass() {
		return MerchantKitchenInfoVO.class;
	}
	
}
