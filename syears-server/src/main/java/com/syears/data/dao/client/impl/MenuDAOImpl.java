package com.syears.data.dao.client.impl;

import com.syears.commons.vo.MechantMenuVO;
import com.syears.commons.vo.client.MenuVO;
import com.syears.data.dao.client.MenuDAO;
import com.syears.data.models.MenuEntity;
import com.syears.exceptions.MenuNameExistsException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * Created on 2015-08-18.
 *
 * @author dolphineor
 */
@Repository("menuDAO")
public class MenuDAOImpl implements MenuDAO {

	@Resource
	private SqlSession sqlSession;

	@Override
	public List<MenuVO> findBySellerId(String sellerId) {
		return convertToVOList(mongoTemplate.find(
				buildQuery(sellerId, null, true), getEntityClass(),
				COLLECTION_MENU));
	}

	@Override
	public List<MenuVO> findBySellerIdAndType(String sellerId, String type) {
		return convertToVOList(mongoTemplate.find(
				buildMerchantQuery(sellerId, type, true), getEntityClass(),
				COLLECTION_MENU));
	}

	@Override
	public MenuVO findOne(String menuId) {
		MenuEntity menuEntity = mongoTemplate.findOne(
				buildQuery(null, menuId, true), getEntityClass(),
				COLLECTION_MENU);
		if (menuEntity == null) {
			Criteria criteria = Criteria.where(DATA_STATUS).is(1).and(MONGO_ID)
					.is(menuId);
			return findOne(Query.query(criteria));
		} else {
			return convertToVO(menuEntity);
		}
	}

	@Override
	public void insert(MenuVO menu) {
		if (mongoTemplate.findOne(
				Query.query(Criteria.where(SELLER_ID).is(menu.getSellerId())
						.and(NAME).is(menu.getName())), getEntityClass(),
				COLLECTION_MENU) == null) {
			mongoTemplate.insert(convertToEntity(menu));
		}
	}

	@Override
	public void update(MenuVO menu) {

	}

	@Override
	public void update(MenuVO menu, Map<String, Object> map) {
		Criteria criteria = Criteria.where(DATA_STATUS).is(1).and(MONGO_ID)
				.is(menu.getId());
		mongoTemplate.updateFirst(Query.query(criteria), buildUpdate(map),
				getEntityClass());

	}

	@Override
	public void delete(String menuId) {
		Criteria criteria = Criteria.where(DATA_STATUS).is(1).and(MONGO_ID)
				.is(menuId);
		mongoTemplate.updateFirst(Query.query(criteria),
				Update.update(DATA_STATUS, 0), getEntityClass());
	}

	@Override
	public int minusRestNum(String menuId) {
		MenuVO menu = findOne(menuId);
		if (menu == null || menu.getRestNum() == 0)
			return -1;

		int restNum = menu.getRestNum() - 1;
		mongoTemplate.updateFirst(buildQuery(null, menuId, true),
				Update.update(REST_NUM, restNum), getEntityClass());

		return restNum;
	}

	@Override
	public int plusTasteNum(String menuId) {
		MenuVO menu = findOne(menuId);
		if (menu == null)
			return -1;

		int tasteNum = menu.getTasteNum() + 1;
		mongoTemplate.updateFirst(buildQuery(null, menuId, true),
				Update.update(TASTE_NUM, tasteNum), getEntityClass());

		return tasteNum;
	}

	@Override
	public int conversion(String menuId, boolean sale) {
		Criteria criteria = Criteria.where(DATA_STATUS).is(1).and(MONGO_ID)
				.is(menuId);
		MenuVO menu = findOne(Query.query(criteria));
		if (menu == null)
			return -1;

		return mongoTemplate.updateFirst(Query.query(criteria),
				Update.update(SALE, sale), getEntityClass()).getN();
	}

	@Override
	public void resetRestNumBySellerId(String sellerId, int restNum) {
		mongoTemplate.updateMulti(buildQuery(sellerId, null, true),
				Update.update(REST_NUM, restNum), getEntityClass());
	}

	@Override
	public void resetRestNumByMenuId(String menuId, int restNum) {
		mongoTemplate.updateFirst(buildQuery(null, menuId, true),
				Update.update(REST_NUM, restNum), getEntityClass());
	}

	@Override
	public MenuVO findOne(Query query) {
		return convertToVO(mongoTemplate.findOne(query, getEntityClass(),
				COLLECTION_MENU));
	}

	@Override
	public void conversionStock(List<MenuVO> menus) {
		for (int i = 0, l = menus.size(); i < l; i++) {
			Criteria criteria = Criteria.where(DATA_STATUS).is(1).and(MONGO_ID)
					.is(menus.get(i).getId());
			MenuVO menu = findOne(Query.query(criteria));
			if (menu != null) {
				mongoTemplate.updateFirst(Query.query(criteria),
						Update.update(STOCK, menus.get(i).getStock()),
						getEntityClass());
			}

		}
	}

	@Override
	public void conversionRestNum(List<MenuVO> menus) {
		for (int i = 0, l = menus.size(); i < l; i++) {
			Criteria criteria = Criteria.where(DATA_STATUS).is(1).and(MONGO_ID)
					.is(menus.get(i).getId());
			MenuVO menu = findOne(Query.query(criteria));
			if (menu != null) {
				mongoTemplate.updateFirst(Query.query(criteria),
						Update.update(REST_NUM, menus.get(i).getRestNum()),
						getEntityClass());
			}

		}
	}

	@Override
	public List<MenuVO> findByIds(List<String> menuIds) {
        List<MenuEntity> list = mongoTemplate.find(buildQuery(menuIds, true), MenuEntity.class);
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        return convertToVOList(list);
	}

	@Override
	public List<MechantMenuVO> findByMenuIds(List<String> menuIds) {

		// 菜品基本信息
		List<MechantMenuVO> list = mongoTemplate
				.find(buildQuery(menuIds, true), MechantMenuVO.class,
						COLLECTION_MENU);

		return list;
	}

	@Override
	public List<MechantMenuVO> findByMenuIds(List<String> menuIds,
			String orderNo) {

		// 菜品基本信息
		List<MechantMenuVO> menuList = mongoTemplate
				.find(buildQuery(menuIds, true), MechantMenuVO.class,
						COLLECTION_MENU);

		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("orderNo", orderNo);
		parameter.put("dishesId", menuIds);

		// 菜品份数信息
		List<MechantMenuVO> menuCountList = sqlSession.selectList(
				"findMenuCount", parameter);

		lambdaInterface li = (MechantMenuVO menu, MechantMenuVO menuCount) -> {

			if (menu.getId().equals(menuCount.getMenuId())) {
				menu.setDishCount(menuCount.getDishCount());
			}

		};

		if (menuList != null && menuCountList != null) {
			for (MechantMenuVO menu : menuList) {
				for (MechantMenuVO menuCount : menuCountList) {
					li.group(menu, menuCount);
				}
			}
		}

		return menuList;
	}

	interface lambdaInterface {
		public void group(MechantMenuVO menu, MechantMenuVO menuCount);
	}

	@Override
	public void insertMenu(MenuVO menu) throws MenuNameExistsException {

		if (mongoTemplate.findOne(
				Query.query(Criteria.where(SELLER_ID).is(menu.getSellerId())
						.and(NAME).is(menu.getName())), getEntityClass(),
				COLLECTION_MENU) != null) {
			throw new MenuNameExistsException("菜单已存在");
		}

		mongoTemplate.insert(convertToEntity(menu));
	}


}
