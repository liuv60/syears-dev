package com.syears.services.merchant;

import com.syears.commons.vo.merchant.MerchantUserVO;
import com.syears.data.models.MerchantUserEntity;
import com.syears.services.MongoService;

/**
 * 
 * @title MerchantService.java
 * @package com.youfan.services.merchant
 * @description 厨房信息业务层接口
 * @author QinghaiDeng   
 * @update 2015年9月11日 下午4:41:09
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
public interface MerchantService extends MongoService<MerchantUserEntity, MerchantUserVO> {

}
