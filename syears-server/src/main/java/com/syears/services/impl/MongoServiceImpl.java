package com.syears.services.impl;

import static com.syears.commons.Constants.MONGO_DELETED_DATA;

import java.util.List;

import com.syears.commons.Pagination;
import com.syears.controllers.params.MongoParams;
import com.syears.data.dao.NewMongoBaseDAO;
import com.syears.services.MongoService;
/**
 * 
 * @title MongoServiceImpl.java
 * @package com.youfan.services.impl
 * @description mongo业务层接口实现 基础Mongo CURD操作
 * @author QinghaiDeng   
 * @update 2015年9月11日 上午11:37:51
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
public class MongoServiceImpl<E, T> implements MongoService<E, T>{
	
	private NewMongoBaseDAO<E, T, String> mongoDao;
	public MongoServiceImpl( NewMongoBaseDAO<E, T, String> mongoDao){
		this.mongoDao=mongoDao;
	}

	@Override
	public void save(T t) {
		mongoDao.insert(t);
	}

	@Override
	public long count(MongoParams params) {
		return mongoDao.count(params);
	}

	@Override
	public int updateById(String id, MongoParams params) {
		return mongoDao.updateById(id, params);
	}

	@Override
	public int updateById(String id, T t) {
		return mongoDao.updateById(id, t);
	}
	
	@Override
	public int logicDelete(String id) {
		MongoParams params=new MongoParams();
		params.setDataStatus(MONGO_DELETED_DATA);
		return mongoDao.updateById(id, params);
	}

	@Override
	public T get(String id) {
		return mongoDao.findOne(id);
	}
	@Override
	public T getUniqueOne(String key, Object value) {
		return mongoDao.findUniqueOne(key, value);
	}

	@Override
	public List<T> getPagerByParams(MongoParams params, Pagination pager) {
		return mongoDao.findPagerByParams(params, pager);
	}

	
}
