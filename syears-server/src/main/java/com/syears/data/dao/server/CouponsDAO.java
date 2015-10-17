package com.syears.data.dao.server;

import java.util.List;

import com.syears.commons.vo.server.CouponsVO;
import com.syears.data.dao.MongoBaseDAO;
import com.syears.data.models.CouponsEntity;

public interface CouponsDAO extends MongoBaseDAO<CouponsEntity, CouponsVO, String>{

	
	@Override
    default Class<CouponsEntity> getEntityClass() {
        return CouponsEntity.class;
    }

    @Override
    default Class<CouponsVO> getVOClass() {
        return CouponsVO.class;
    }

	List<CouponsVO> findUserId(Long userId);

	boolean updateStatus(Long couponsid);
}
