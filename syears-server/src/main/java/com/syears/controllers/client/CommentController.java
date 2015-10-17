package com.syears.controllers.client;

import com.syears.commons.Pagination;
import com.syears.commons.vo.CollectionVO;
import com.syears.commons.vo.CommentVO;
import com.syears.controllers.support.Response;
import com.syears.controllers.support.Responses;
import com.syears.services.merchant.CommentService;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaowei on 15-8-31.
 */
@RestController
@Scope("prototype")
@RequestMapping("/cm")
public class CommentController {
    @Resource
    private CommentService commentService;


    @RequestMapping(value = "/save")
    public Response createComment(@RequestBody CommentVO cm) {
//        String commentUser=
        System.out.println(cm.getComment_user());
        Integer result = commentService.createCm(cm);
        if (result != 0) {
            return Responses.SUCCESS();
        } else {
            return Responses.FAILED();
        }
    }

    @RequestMapping(value = "/findComment")
    public Response findComment() {
        List<CommentVO> findResult = commentService.findComment();
        if (findResult.size() > 0) {
            return Responses.SUCCESS().setPayload(findResult);
        } else {
            return Responses.FAILED().setMsg("No Data Found");
        }
    }

    @RequestMapping(value = "/getComment")
    public Response getComment(Integer orderId) {
        CommentVO cv = commentService.findCommentById(orderId);
        return Responses.SUCCESS().setPayload(cv);
    }

    @RequestMapping(value = "/getCommentPager")
    public Response getComment(@RequestBody Pagination pagination) {
        CollectionVO<CommentVO> p = commentService.findCommentByPager(pagination);
        return Responses.SUCCESS().setPayload(p);
    }
}
