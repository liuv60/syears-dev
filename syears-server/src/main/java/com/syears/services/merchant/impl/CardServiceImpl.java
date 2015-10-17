package com.syears.services.merchant.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.syears.commons.vo.merchant.CardVO;
import com.syears.data.dao.merchant.CardDAO;
import com.syears.services.merchant.CardService;

@Service("cardService")
public class CardServiceImpl implements CardService {

    private final ReentrantLock lock = new ReentrantLock();

    @Resource
    private CardDAO cardDAO;

    @Override
    public void insert(CardVO card) {
        lock.lock();

        try {
            cardDAO.insert(card);
        } finally {
            lock.unlock();
        }

    }

    @Override
    public CardVO findOne(String id) {
        return cardDAO.findOne(id);
    }

    @Override
    public List<CardVO> list(String sellerId) {
        List<CardVO> cardList = cardDAO.findBySellerId(sellerId);

        if (cardList == null || cardList.isEmpty()) {
            return Collections.emptyList();
        }

        return cardList;
    }

    @Override
    public void update(CardVO card) {
        Map<String, Object> map = new HashMap<>();
        map.put(BANK_NAME, card.getBankName());
        map.put(AREA_NAME, card.getAreaName());
        map.put(CARD_NAME, card.getCardName());
        map.put(CARD_NUMBER, card.getCardNumber());
        map.put(IDENTITY_NAME, card.getIdentityName());
        map.put(IDENTITY_NUMBER, card.getIdentityNumber());
        cardDAO.update(card, map);
    }

}
