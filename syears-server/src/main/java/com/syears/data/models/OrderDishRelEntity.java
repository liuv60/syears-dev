package com.syears.data.models;

import org.springframework.data.annotation.Id;

/**
 * Created by yousheng on 15/8/14.
 */
public class OrderDishRelEntity {

    @Id
    private Long id;

    private String orderNo;

    private String itemId;

    private int count;

    private int dataStatus = 1;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(int dataStatus) {
        this.dataStatus = dataStatus;
    }
}
