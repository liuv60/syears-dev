package com.syears.data.dao.merchant;

import com.syears.commons.Pagination;
import com.syears.commons.vo.CollectionVO;
import com.syears.commons.vo.CommentVO;
import com.syears.controllers.params.CommentParams;
import com.syears.data.dao.MongoBaseDAO;
import com.syears.data.models.CommentEntity;

import redis.clients.jedis.Jedis;

import java.time.Instant;
import java.util.List;
import java.util.Map;


/**
 * Created by xiaowei on 15-8-31.
 */
public interface CommentDAO extends MongoBaseDAO<CommentEntity, CommentVO, Long> {
    List<CommentVO> findComment();

    CommentVO findComment(long orderId);

    CollectionVO<CommentVO> findPager(Pagination p);

    long commentCount(String muId);

    default long getGenerator(long no) {

        return Instant.now().getEpochSecond() + no;
    }

	long count(Map<String, Object> paramMap);
	
	List<CommentVO> getComments(Pagination pager);
	
	int updateStatus(String id,Integer status);

}
