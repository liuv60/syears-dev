package com.syears.services.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syears.commons.vo.ActiveVO;
import com.syears.data.dao.server.ActiveDAO;
import com.syears.data.models.ActiveEntity;
import com.syears.services.impl.MongoServiceImpl;
import com.syears.services.server.ActiveService;

@Service("activeService")
public class ActiveServiceImpl extends MongoServiceImpl<ActiveEntity, ActiveVO>implements ActiveService{


//	@Resource
//	ActiveDAO activeDAO;
	
	@Autowired
	public ActiveServiceImpl(ActiveDAO mongoDao) {
		super(mongoDao);
	}

	
	@Override
	public void saveActive(ActiveVO activeVo) {
		activeVo.setStatus(1);// 状态默认为1 表示开启使用状态
		activeVo.setDataStatus(1);//数据状态
		save(activeVo);
	}

//	@Override
//	public long count(ActiveParams activeParams) {
//		return activeDAO.count(activeParams) ;
//	}
//
//	@Override
//	public List<ActiveVO> getByCondition(ActiveParams activeParams) {
//		return activeDAO.getByCondition(activeParams);
//	}
//
//	@Override
//	public void updateById(String id, Map<String, Object> updateMap) {
//		activeDAO.updateById(id,updateMap);
//	}

}
