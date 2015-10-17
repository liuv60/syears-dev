package com.syears.services.server;

import com.syears.commons.vo.ActiveVO;
import com.syears.data.models.ActiveEntity;
import com.syears.services.MongoService;

/**
 * 
 * @title ActiveService.java
 * @package com.youfan.services.server
 * @description 活动业务层接口
 * 				2015年9月11日 11:38:29 切换到 Mongoservice接口
 * @author QinghaiDeng   
 * @update 2015年9月11日 上午11:12:57
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
public interface ActiveService extends MongoService<ActiveEntity, ActiveVO>{

	void saveActive(ActiveVO activeVo);

//	public long count(ActiveParams activeParams);
//
//	public List<ActiveVO> getByCondition(ActiveParams activeParams);
//
//	public void updateById(String id, Map<String, Object> updateMap);

}
