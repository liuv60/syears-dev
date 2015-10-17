package com.syears.services.client.impl;

import com.syears.commons.vo.client.ClientUserVO;
import com.syears.data.dao.client.UserDao;
import com.syears.services.client.ClientUserService;
import com.syears.system.redis.RedisPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by icepros on 15-8-25.
 */
@Service("ucService")
public class ClientUserServiceImpl implements ClientUserService {

    private static Logger logger = LoggerFactory.getLogger(ClientUserServiceImpl.class);

    @Resource
    private UserDao ucDAO;

    @Override
    public void insert(ClientUserVO uc) {
        if (uc != null) {
            ucDAO.insert(uc);
        }
    }

    @Override
    public void update(ClientUserVO uc) {

    }


    @Override
    public ClientUserVO getUserByTel(String tel) {
        return ucDAO.getUserByTel(tel);
    }

    @Override
    public ClientUserVO findUserByTelAndPwd(String tel, String password) {
        return ucDAO.getUserByTelAndPwd(tel, password);
    }

    @Override
    public String getUserIdByToken(String token) {
        RedisPool redisPool = new RedisPool();
        String result = new String();
        try {
            result = redisPool.getJedis().get(token);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return result;
    }

    @Override
    public void update(String id, ClientUserVO clientUserVO) {
        ucDAO.update(id, clientUserVO);
    }

    @Override
    public void updateUserPwd(String id, String pwd) {
        ucDAO.updateUserPwd(id, pwd);
    }
}
