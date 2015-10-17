package com.syears.services.client.impl;

import com.syears.commons.vo.client.MenuVO;
import com.syears.data.dao.client.MenuDAO;
import com.syears.exceptions.MenuNameExistsException;
import com.syears.services.client.MenuService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2015-08-18.
 *
 * @author dolphineor
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    private final ReentrantLock lock = new ReentrantLock();

    @Resource
    private MenuDAO menuDAO;

    @Override
    public void insert(MenuVO menu) throws MenuNameExistsException {
        if (menu == null)
            return;

        menuDAO.insertMenu(menu);
    }

    @Override
    public void delete(String menuId) {
        menuDAO.delete(menuId);
    }

    @Override
    public List<MenuVO> findBySellerId(String sellerId) {
        List<MenuVO> list = menuDAO.findBySellerId(sellerId);
        if (list == null || list.isEmpty())
            return Collections.emptyList();

        return list;
    }

    @Override
    public List<MenuVO> findBySellerIdAndType(String sellerId, String type) {
        List<MenuVO> list = menuDAO.findBySellerIdAndType(sellerId, type);
        if (list == null || list.isEmpty())
            return Collections.emptyList();

        return list;
    }

    @Override
    public MenuVO findByMenuId(String menuId) {
        return menuDAO.findOne(menuId);
    }

    @Override
    public int minusRestNum(String menuId) {
        lock.lock();
        int restNum = -1;

        try {
            restNum = menuDAO.minusRestNum(menuId);
        } finally {
            lock.unlock();
        }

        return restNum;
    }

    @Override
    public int plusTasteNum(String menuId) {
        lock.lock();
        int tasteNum = -1;

        try {
            menuDAO.plusTasteNum(menuId);
        } finally {
            lock.unlock();
        }

        return tasteNum;
    }

    @Override
    public void resetRestNumBySellerId(String sellerId, int restNum) {
        menuDAO.resetRestNumBySellerId(sellerId, restNum);
    }

    @Override
    public void resetRestNumByMenuId(String menuId, int restNum) {
        menuDAO.resetRestNumByMenuId(menuId, restNum);
    }

    @Override
    public int conversion(MenuVO menu) {
        lock.lock();
        int restNum = -1;

        try {
            restNum = menuDAO.conversion(menu.getId(), menu.isSale());
        } finally {
            lock.unlock();
        }

        return restNum;

    }

    @Override
    public void conversionStock(List<MenuVO> menus) {
        lock.lock();

        try {
            menuDAO.conversionStock(menus);
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void conversionRestNum(List<MenuVO> menus) {
        lock.lock();

        try {
            menuDAO.conversionRestNum(menus);
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void updateMenu(String menuId, MenuVO menu) {
        Map<String, Object> map = new HashMap<>();
        map.put(NAME, menu.getName());
        map.put(PRICE, menu.getPrice());
        map.put(STOCK, menu.getStock());
        map.put(PIC_URLS, menu.getPicUrls());
        map.put(DESCRIPTION, menu.getDescription());
        map.put(TASTE, menu.getTaste());
        map.put(STAPLE, menu.isStaple());
        map.put(FEATURES, menu.getFeatures());
        menuDAO.update(menu, map);
    }

    @Override
    public void updateXfzMenu(String menuId, MenuVO menu) {
        Map<String, Object> map = new HashMap<>();

        map.put(PRICE, menu.getPrice());
        map.put(STOCK, menu.getStock());
        map.put(PIC_URLS, menu.getPicUrls());

        menuDAO.update(menu, map);
    }

    @Override
    public void conversionType(String menuId, MenuVO menu) {
        Map<String, Object> map = new HashMap<>();
        String type = menu.getType().equals("nsc") ? "qtc" : "nsc";
        map.put(TYPE, type);

        menuDAO.update(menu, map);
    }

    @Override
    public List<MenuVO> findByIds(List<String> menuIds) {
        return menuDAO.findByIds(menuIds);
    }

}
