package com.syears.data.dao.server.impl;

import org.springframework.stereotype.Repository;

import com.syears.commons.vo.ActiveVO;
import com.syears.data.dao.impl.MongoBaseDAOImpl;
import com.syears.data.dao.server.ActiveDAO;
import com.syears.data.models.ActiveEntity;
@Repository("activeDAO")
public class ActiveDAOImpl extends MongoBaseDAOImpl<ActiveEntity, ActiveVO, String>implements ActiveDAO{
	

	public Class<ActiveEntity> getEntityClass() {
		return ActiveEntity.class;
	}

	public Class<ActiveVO> getVOClass() {
		return ActiveVO.class;
	}
	
}
