package com.syears.services.client;

import org.springframework.data.mongodb.core.query.Query;

import com.syears.commons.vo.client.MessageVO;

import java.util.List;

public interface MessageService {


    /**
     * 更新消息查看状态
     *
     * @param id     数据ID
     * @param status 数据查看状态
     * @return
     */
    boolean updateMsg(String id, int status);


    MessageVO findById(String id);

    void insert(MessageVO message);


    /**
     * 通过用户id查询所有消息
     *
     * @param userId   用户ID
     * @param receiver 接收端标识符  2,用户端  3,商家断
     * @return
     */
    List<MessageVO> findMsgList(Long userId, Integer receiver);

    /**
     * 通过用户ID 统计用户未读消息条数
     *
     * @param userId   用户ID
     * @param receiver 接收端标识符  2,用户端  3,商家断
     * @return
     */
    Long countUnreadMsg(Long userId, Integer receiver);

}
