package com.syears.services.merchant.impl;

import com.syears.commons.Pagination;
import com.syears.commons.vo.CollectionVO;
import com.syears.commons.vo.CommentVO;
import com.syears.controllers.params.CommentParams;
import com.syears.data.dao.merchant.CommentDAO;
import com.syears.services.merchant.CommentService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaowei on 15-8-31.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDAO commentDAO;

    @Override
    public Integer createCm(CommentVO cm) {
        try {
            commentDAO.insert(cm);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<CommentVO> findComment() {
        return commentDAO.findComment();
    }

    @Override
    public CommentVO findCommentById(long orderId) {
        return commentDAO.findComment(orderId);
    }

    @Override
    public CollectionVO<CommentVO> findCommentByPager(Pagination p) {
        return commentDAO.findPager(p);
    }


    @Override
    public List<CommentVO> getPagerByCondition(Pagination pager) {
        return commentDAO.getComments(pager);
    }

    @Override
    public long count(Map<String, Object> paramMap) {
        return commentDAO.count(paramMap);
    }

    @Override
    public int deleteById(String id) {
        // TODO Auto-generated method stub
        return commentDAO.updateStatus(id, -1);
    }

    @Override
    public long commentCount(String sellerId) {
        return commentDAO.commentCount(sellerId);
    }
}
