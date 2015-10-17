package com.syears.data.dao.server.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.syears.commons.OrderNoGenerator;
import com.syears.commons.Pagination;
import com.syears.commons.vo.MerchantOrderDetailVO;
import com.syears.commons.vo.merchant.MerchantOrderHeaderVO;
import com.syears.commons.vo.server.OrderDishRelVO;
import com.syears.commons.vo.server.OrderVO;
import com.syears.controllers.params.OrderParams;
import com.syears.data.dao.server.OrderDAO;
import com.syears.data.models.OrderDishRelEntity;
import com.syears.data.models.OrderEntity;
import com.syears.data.support.IdGenerator;

/**
 * Created by yousheng on 15/8/13.
 */
@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {

	@Resource
	private IdGenerator idGenerator;

	@Resource
	private SqlSession sqlSession;

	@Override
	public OrderVO insert(OrderVO order) {

		OrderEntity orderEntity = createEntity(order);

		long no = idGenerator.next(SEQ_ORDER);

		String orderNo = OrderNoGenerator.orderNo(no);

		orderEntity.setOrderNo(orderNo);

		int ret = sqlSession.insert("createOrder", orderEntity);
		if (ret == 0) {
			return null;
		}

		order.setOrderNo(orderEntity.getOrderNo());
		return order;
	}

	@Override
	public OrderVO getOrderByOrderNo(String orderNo) {

		OrderEntity orderEntity = sqlSession.selectOne("getOrderByOrderNo",
				orderNo);

		OrderVO order = createObject(orderEntity);
		List<OrderDishRelEntity> dishList = sqlSession.selectList(
				"getOrderItemsByOrderNo", orderNo);

		return null;
	}


	@Override
	public List<OrderVO> findAll(Pagination pagination) {
		List<OrderVO> list = sqlSession.selectList("findAllByPagination",
				pagination);

		return list;
	}


	@Override
	public List<OrderVO> findBySellerId(String sellerId, Pagination pagination) {
		List<OrderVO> orders = sqlSession.selectList("findBySellerId",
				pagination);

		return orders;
	}

	private OrderEntity createEntity(OrderVO order) {
		OrderEntity orderEntity = new OrderEntity();

		orderEntity.setId(order.getId());
		orderEntity.setBuyerId(order.getBuyerId());
		orderEntity.setSellerId(order.getSellerId());
		orderEntity.setOrgPrice(BigDecimal.valueOf(order.getOrgPrice()));
		orderEntity.setDiscountPrice(BigDecimal.valueOf(order
                .getDiscountPrice()));
        orderEntity.setDataStatus(order.getDataStatus());
		orderEntity.setOrderStatus(order.getOrderStatus());

		orderEntity.setOrderTime(Timestamp.from(Instant.now()));
		orderEntity.setRepastTime(Timestamp.from(order.getRepastTime()
				.toInstant()));
		orderEntity.setRepastMode(order.getRepastMode());
		orderEntity.setRepastAddress(order.getRepastAddress());
		orderEntity.setCouponId(order.getCouponId());
		orderEntity.setComments(order.getComments());

		return orderEntity;
	}

	private OrderVO createObject(OrderEntity orderEntity) {
		OrderVO order = new OrderVO();

		order.setId(orderEntity.getId());
		order.setOrderNo(orderEntity.getOrderNo());
		order.setBuyerId(orderEntity.getBuyerId());
		order.setSellerId(orderEntity.getSellerId());

		order.setComments(orderEntity.getComments());
		order.setOrderStatus(orderEntity.getOrderStatus());

		order.setOrgPrice(orderEntity.getOrgPrice()
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
		order.setDiscountPrice(orderEntity.getDiscountPrice()
				.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
		order.setCouponId(orderEntity.getCouponId());

		order.setOrderTime(orderEntity.getOrderTime());
		order.setRepastTime(orderEntity.getRepastTime());
		order.setRepastMode(orderEntity.getRepastMode());
		order.setRepastAddress(orderEntity.getRepastAddress());

		return order;
	}

	@Override
	public List<MerchantOrderHeaderVO> findMerchantOrders(OrderParams order) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderStatus(order.getOrderStatus());
		orderEntity.setSellerId(order.getSellerId());
		orderEntity.setRepastMode(order.getRepastMode());
		orderEntity.setOrderStatusList(order.getOrderStatusList());

		List<MerchantOrderHeaderVO> orders = sqlSession.selectList(
				"findOrders", orderEntity);

		return orders;
	}

	@Override
	public MerchantOrderDetailVO findOrderDetail(String orderNo) {

		Map<String, Object> parameter = new HashMap<>();
		parameter.put("orderNo", orderNo);

		MerchantOrderDetailVO order = sqlSession.selectOne("findOrderDetail",
				parameter);

		return order;
	}

	@Override
	public int count(OrderParams op) {
		List<Object> lenO = sqlSession.selectList("count");
		return Integer.parseInt(lenO.get(0).toString());
	}

	@Override
	public int countAll() {
		List<Object> lenO = sqlSession.selectList("countAll");
		return Integer.parseInt(lenO.get(0).toString());
	}

	@Override
	public List<OrderVO> getOrdersByParams(OrderParams op) {
		return sqlSession.selectList("getOrdersByParams", op);
	}

	@Override
	public void saveOrderDishes(List<OrderDishRelVO> dishRelVOs) {
		List<OrderDishRelEntity> dishRelEntities = convertToEntityList(
				dishRelVOs, OrderDishRelEntity.class, OrderDishRelVO.class);
		sqlSession.insert("saveOrderDishes", dishRelEntities);

	}

	@Override
	public int updateOrderStatus(OrderParams order) {
		return sqlSession.update("updateOrder", order);
	}

	@Override

	public List<Map<String, Object>> findOrdersByMerchantSummary(OrderParams order) {

		return sqlSession.selectList("findOrderSummary", order);

	}
    public List<OrderDishRelVO> findDishByOrderNo(String orderNo) {
        List<OrderDishRelEntity> dishRelEntities = sqlSession.selectList("findDishByOrderNo", orderNo);
        return convertToVOList(dishRelEntities, OrderDishRelEntity.class, OrderDishRelVO.class);
    }


    @Override
    public OrderVO findOrderById(Long id) {
        OrderEntity entity = sqlSession.selectOne("findOrderById", id);
        return convertToVO(entity, OrderEntity.class, OrderVO.class);
    }

    @Override
    public List<OrderVO> findByBuyerId(String buyerId, Pagination pagination) {
        List<OrderEntity> orderEntityList = sqlSession.selectList("findByBuyerId", pagination.getParams());
        if (orderEntityList == null)
            return Collections.emptyList();

        return convertToVOList(orderEntityList, OrderEntity.class, OrderVO.class);
    }

}
