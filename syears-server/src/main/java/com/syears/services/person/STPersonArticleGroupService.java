package com.syears.services.person;

import java.util.List;

import com.syears.commons.vo.person.STPersonArticleGroupVO;
import com.syears.commons.vo.person.STUserVO;
import com.syears.controllers.params.person.UserParams;

public interface STPersonArticleGroupService {
    STPersonArticleGroupVO createPersonArticleGroup(STPersonArticleGroupVO vo);  //插入
    List<STPersonArticleGroupVO> getPersonArticleGroup();   //获取分组列表
    int deletePersonArticleGroup(String ID);  //删除
    int editPersonArticleGroup(STPersonArticleGroupVO vo);  //修改
}
