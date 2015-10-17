package com.syears.eventbus;

import com.google.common.eventbus.Subscribe;
import com.syears.eventbus.events.ActiveEvent;
import com.syears.eventbus.events.CouponEvent;
/**
 * 
 * @description 事件监听总线
 * @author ZhangHuaRong   
 */
public class ServerEventListener {
	
	
	@Subscribe
	public void postCoupon(CouponEvent couponEvent){
		couponEvent.domain();
	}
	
	@Subscribe
	public void postActive(ActiveEvent activeEvent){
		activeEvent.domain();
	}

	
}
