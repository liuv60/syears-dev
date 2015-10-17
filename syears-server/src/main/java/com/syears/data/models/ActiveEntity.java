package com.syears.data.models;

import static com.syears.commons.Constants.COLLECTION_SERVER_ACTIVE;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.syears.commons.vo.ConditionVO;

@Document(collection = COLLECTION_SERVER_ACTIVE)
public class ActiveEntity {
	@Id
	private String id;

	/**
	 * 活动事件
	 */
	@Indexed(unique = true)
	private String event;

	/**
	 * 活动标题
	 */
	private String title;
	/**
	 * 活动针对端 目前默认为2 2.客户端 3.商家端
	 */
	private Integer port = 2;

	/**
	 * 活动类型 1.注册完成活动 2.登录后活动 3.订单生成后活动 4.订单完成后活动 5.其他
	 */
	@Field("atype")
	private Integer activeType;

	/**
	 * 优惠方式 1.发放优惠券 2.价格折扣减免
	 */
	@Field("ctype")
	private Integer couponsType;

	/**
	 * 是否为唯一参加活动 即和别的活动一起参加
	 */
	@Field("ifuique")
	private boolean ifUnique=false;

	/**
	 * 是否可以同时使用优惠券
	 */
	@Field("iuc")
	private boolean ifUseCoupons=true;

	/**
	 * 是否为全场
	 */
	@Field("ifall")
	private boolean ifAll=true;

//	@Field("ats")
	private Integer allowTimes;

	/**
	 * 非全场时指定厨房ID
	 */
	@Field("kid")
	private String kitchenId;

	/**
	 * 优惠规则内容 包括 满减、折扣、返现
	 */
	@Field("ctid")
	private String couponsTypeId;

	/**
	 * 优惠券有效期 设置时候若给天数 则从第二日起计算出有效期 若给日期则有效期至指定日期
	 */
	@Field("vt")
	private Long validityTime;

	/**
	 * 活动创建时间
	 */
	@Field("ct")
	private Long createTime;
	/**
	 * 活动发布日期 UNIX时间 以 00:00:00开始
	 */
	@Field("st")
	private Long startTime;
	/**
	 * 活动结束日期 UNIX时间 以23:59:59结束
	 */
	@Field("et")
	private Long endTime;
	@Field("userc")
	private List<ConditionVO> userConditions;
	@Field("orderc")
	private List<ConditionVO> orderConditions;
//	/**
//	 * 活动处理类
//	 */
//	@Field("adc")
//	private String activeDetailClazz;

	/**
	 * 活动描述
	 */
	private String desc;
	/**
	 * 活动状态 -1:删除 0:待开启 1:开启 2:暂定
	 */
	private Integer status;
	@Field("ds")
	private Integer dataStatus=1;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getActiveType() {
		return activeType;
	}

	public void setActiveType(Integer activeType) {
		this.activeType = activeType;
	}

	public Integer getCouponsType() {
		return couponsType;
	}

	public void setCouponsType(Integer couponsType) {
		this.couponsType = couponsType;
	}

	public boolean isIfUnique() {
		return ifUnique;
	}

	public void setIfUnique(boolean ifUnique) {
		this.ifUnique = ifUnique;
	}

	public boolean isIfUseCoupons() {
		return ifUseCoupons;
	}

	public void setIfUseCoupons(boolean ifUseCoupons) {
		this.ifUseCoupons = ifUseCoupons;
	}

	public boolean isIfAll() {
		return ifAll;
	}

	public void setIfAll(boolean ifAll) {
		this.ifAll = ifAll;
	}

	public Long getValidityTime() {
		return validityTime;
	}

	public void setValidityTime(Long validityTime) {
		this.validityTime = validityTime;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

//	public String getActiveDetailClazz() {
//		return activeDetailClazz;
//	}
//
//	public void setActiveDetailClazz(String activeDetailClazz) {
//		this.activeDetailClazz = activeDetailClazz;
//	}
	

	public String getDesc() {
		return desc;
	}

	public List<ConditionVO> getUserConditions() {
		return userConditions;
	}

	public void setUserConditions(List<ConditionVO> userConditions) {
		this.userConditions = userConditions;
	}

	public List<ConditionVO> getOrderConditions() {
		return orderConditions;
	}

	public void setOrderConditions(List<ConditionVO> orderConditions) {
		this.orderConditions = orderConditions;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getKitchenId() {
		return kitchenId;
	}

	public void setKitchenId(String kitchenId) {
		this.kitchenId = kitchenId;
	}

	public String getCouponsTypeId() {
		return couponsTypeId;
	}

	public void setCouponsTypeId(String couponsTypeId) {
		this.couponsTypeId = couponsTypeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAllowTimes(Integer allowTimes) {
		this.allowTimes = allowTimes;
	}

	public Integer getAllowTimes() {
		return allowTimes;
	}

	public Integer getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	

}
