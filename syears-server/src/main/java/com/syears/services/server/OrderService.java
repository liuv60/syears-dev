package com.syears.services.server;

import java.util.List;

import com.syears.commons.Pagination;
import com.syears.commons.vo.MerchantOrderDetailVO;
import com.syears.commons.vo.merchant.MerchantOrderHeaderVO;
import com.syears.commons.vo.server.OrderDishRelVO;
import com.syears.commons.vo.server.OrderVO;
import com.syears.controllers.params.OrderParams;

import java.util.Map;

/**
 * Created by yousheng on 15/8/18.
 */
public interface OrderService {

	List<OrderVO> findAll(Pagination pagination);

	List<OrderVO> findByUserId(String userId, Pagination pagination);

	List<OrderVO> findBySellerId(String sellerId, Pagination pagination);

	OrderVO findOrderById(Long id);

	OrderVO findByOrderNo(String orderNo);

	OrderVO createOrder(OrderVO order);

	void updateOrder(OrderVO order);

	OrderVO cancelOrder(OrderVO order);

	OrderVO refundOrder(OrderVO order);

	void saveOrderDishes(List<OrderDishRelVO> dishRelVOs);

	List<MerchantOrderHeaderVO> findOrdersByMerchant(OrderParams order);

	Map<String, Long> findOrdersByMerchantSummary(OrderParams order);

	MerchantOrderDetailVO findOrderDetailByOrderNo(String orderNo);

	int count(OrderParams op);

	int countAll();

	List<OrderVO> getOrdersByParams(OrderParams op);

	int updateOrderStatus(OrderParams order);

	List<OrderDishRelVO> findDishByOrderNo(String orderNo);

}
