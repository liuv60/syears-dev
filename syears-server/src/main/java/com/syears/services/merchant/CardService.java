package com.syears.services.merchant;

import java.util.List;

import com.syears.commons.Constants;
import com.syears.commons.vo.merchant.CardVO;

public interface CardService extends Constants {
    void insert(CardVO card);

    CardVO findOne(String id);

    List<CardVO> list(String sellerId);

    void update(CardVO card);
}
