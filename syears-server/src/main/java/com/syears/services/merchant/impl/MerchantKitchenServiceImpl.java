package com.syears.services.merchant.impl;

import com.syears.commons.Pagination;
import com.syears.commons.vo.CollectionVO;
import com.syears.commons.vo.merchant.MerchantKitchenInfoVO;
import com.syears.data.dao.merchant.MerchantKitchenDAO;
import com.syears.data.models.MerchantKitchenInfoEntity;
import com.syears.services.merchant.MerchantKitchenService;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by perfection on 15-8-19.
 */
@Service("merchantKitchenServer")
public class MerchantKitchenServiceImpl implements MerchantKitchenService {


    @Resource
    private MerchantKitchenDAO merchantKitchenDAO;


    @Override
    public long count(Query query) {
        return merchantKitchenDAO.count(query);
    }

    @Override
    public List<MerchantKitchenInfoEntity> find(Query query) {
        return merchantKitchenDAO.find(query);
    }

    @Override
    public CollectionVO<MerchantKitchenInfoVO> geographicalSearch(Pagination pagination) {
        return merchantKitchenDAO.getGeographicalSearch(pagination);
    }
}
