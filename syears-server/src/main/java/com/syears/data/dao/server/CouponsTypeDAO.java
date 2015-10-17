package com.syears.data.dao.server;

import java.util.List;
import java.util.Map;

import com.syears.commons.vo.ActiveVO;
import com.syears.commons.vo.server.CouponsTypeVO;
import com.syears.controllers.params.CouponsParams;
import com.syears.data.dao.MongoBaseDAO;
import com.syears.data.dao.NewMongoBaseDAO;
import com.syears.data.models.ActiveEntity;
import com.syears.data.models.CouponsTypeEntity;

public interface CouponsTypeDAO extends  NewMongoBaseDAO<CouponsTypeEntity, CouponsTypeVO, String>{

	public void insert(CouponsTypeVO couponsTypeVO);
	
	@Override
    default Class<CouponsTypeEntity> getEntityClass() {
        return CouponsTypeEntity.class;
    }

    @Override
    default Class<CouponsTypeVO> getVOClass() {
        return CouponsTypeVO.class;
    }

//	public Long count(CouponsParams couponsParams);
//
//	public List<CouponsTypeVO> getByCondition(CouponsParams couponsParams);
//	
//	public int updateById(String id, Map<String, Object> updateMap);
//
//	public int updateById(String id, CouponsTypeVO vo);
}
