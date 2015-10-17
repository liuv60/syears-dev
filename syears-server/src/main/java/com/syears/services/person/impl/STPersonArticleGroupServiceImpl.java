package com.syears.services.person.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.syears.services.person.STPersonArticleGroupService;

import com.syears.commons.vo.person.STPersonArticleGroupVO;
import com.syears.data.dao.person.STPersonArticleGroupDAO;

@Service
public class STPersonArticleGroupServiceImpl implements STPersonArticleGroupService {

	@Resource
	private STPersonArticleGroupDAO d;
	
	@Override
    public STPersonArticleGroupVO createPersonArticleGroup(STPersonArticleGroupVO vo)  //插入
    {
    	return d.createPersonArticleGroup(vo);
    }
	
	@Override
    public List<STPersonArticleGroupVO> getPersonArticleGroup()  //获取分组列表
    {
		return d.getPersonArticleGroup();
    }
	
	@Override
    public int deletePersonArticleGroup(String ID)  //删除
    {
    	return d.deletePersonArticleGroup(ID);
    }
	
	@Override
    public int editPersonArticleGroup(STPersonArticleGroupVO vo)  //修改
    {
    	return d.editPersonArticleGroup(vo);
    }
}
