package com.syears.data.dao.person.impl;


import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.syears.commons.OrderNoGenerator;

import com.syears.commons.vo.person.STPersonArticleGroupVO;

import com.syears.data.dao.person.STPersonArticleGroupDAO;

import com.syears.data.models.person.STPersonArticleGroupEntity;
import com.syears.data.support.IdGenerator;

@Repository("STPersonArticleGroupDAO")
public class STPersonArticleGroupDAOImp implements STPersonArticleGroupDAO {

	@Resource
	private IdGenerator idGenerator;

	@Resource
	private SqlSession sqlSession;
	
	
	@Override
	public STPersonArticleGroupVO createPersonArticleGroup(STPersonArticleGroupVO vo) {
		STPersonArticleGroupEntity E = createEntity(vo);
		
		long no = idGenerator.next(SEQ_STPersonArticleGroup);

		String code = OrderNoGenerator.orderNo(no);

		E.setPersonArticleGroupID(code);
		
		int ret = sqlSession.insert("createPersonArticleGroup", E);
		if (ret == 0) {
			return null;
		}
		
		vo.setPersonArticleGroupID(E.getPersonArticleGroupID());
		return vo;
	}


	@Override
	public List<STPersonArticleGroupVO> getPersonArticleGroup() {
		List<STPersonArticleGroupVO> list = sqlSession.selectList("getPersonArticleGroup");
		return list;
	}

	@Override
	public int deletePersonArticleGroup(String ID) {
		return sqlSession.update("deletePersonArticleGroup", ID);
	}
	


	@Override
	public int editPersonArticleGroup(STPersonArticleGroupVO vo) {
		STPersonArticleGroupEntity E = createEntity(vo);
		return sqlSession.update("editPersonArticleGroup", E);

	}
	
	
	private STPersonArticleGroupEntity createEntity(STPersonArticleGroupVO vo) {
		STPersonArticleGroupEntity e = new STPersonArticleGroupEntity();
		
		e.setPersonArticleGroupID(vo.getPersonArticleGroupID());
		e.setPersonArticleGroupName(vo.getPersonArticleGroupName());
		e.setPersonArticleGroupStatus(vo.getPersonArticleGroupStatus());
		e.setPersonArticleGroupType(vo.getPersonArticleGroupType());
		return e;
	}

	private STPersonArticleGroupVO createObject(STPersonArticleGroupEntity e) {
		STPersonArticleGroupVO vo = new STPersonArticleGroupVO();
		
		vo.setPersonArticleGroupID(e.getPersonArticleGroupID());
		vo.setPersonArticleGroupName(e.getPersonArticleGroupName());
		vo.setPersonArticleGroupType(e.getPersonArticleGroupType());
		vo.setPersonArticleGroupStatus(e.getPersonArticleGroupStatus());
		
		return vo;
	}

}
