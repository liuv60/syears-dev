package com.syears.services.server.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syears.commons.vo.server.CouponsTypeVO;
import com.syears.data.dao.server.CouponsTypeDAO;
import com.syears.data.models.CouponsTypeEntity;
import com.syears.services.impl.MongoServiceImpl;
import com.syears.services.server.CouponsTypeService;

/**
 * 
 * @title CouponsTypeServiceImpl.java
 * @package com.youfan.services.server.impl
 * @description TODO
 * @author QinghaiDeng   
 * @update 2015年8月31日 下午5:24:50
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
@Service("couponsTypeService")
public class CouponsTypeServiceImpl extends MongoServiceImpl<CouponsTypeEntity, CouponsTypeVO>implements CouponsTypeService{
	@Autowired
	public CouponsTypeServiceImpl(CouponsTypeDAO couponsTypeDAO) {
		super(couponsTypeDAO);
	}
}
