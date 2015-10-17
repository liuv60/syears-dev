package com.syears.commons.vo.server;

import java.util.List;

import com.syears.data.models.CouponsContentEntity;

public class CouponsTypeVO {
	private String id;

	/**
	 * 优惠券针对端 2 客户端 3商家端
	 */
	private Integer port;

	/**
	 * 标题
	 */
	private String title;
	/**
	 * 优惠券时效
	 */
	private Integer timeLine;

	
	/**
	 * 是否为全场使用
	 */
	private Boolean ifAll;
	private Long createTime;
	/**
	 * 优惠券内容
	 */
	private List<CouponsContentEntity> content;

	/**
	 * 优惠券描述
	 */
	private String desc;

	private Integer status;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getTimeLine() {
		return timeLine;
	}

	public void setTimeLine(Integer timeLine) {
		this.timeLine = timeLine;
	}

	public List<CouponsContentEntity> getContent() {
		return content;
	}

	public void setContent(List<CouponsContentEntity> content) {
		this.content = content;
	}

	public String getDesc() {
		return desc;
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

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Boolean getIfAll() {
		return ifAll;
	}

	public void setIfAll(Boolean ifAll) {
		this.ifAll = ifAll;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	private Integer dataStatus=1;
	public Integer getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
}
