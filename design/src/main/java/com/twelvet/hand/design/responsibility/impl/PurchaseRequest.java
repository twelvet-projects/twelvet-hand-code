package com.twelvet.hand.design.responsibility.impl;

/**
 * 请求类
 *
 */
public class PurchaseRequest {
    
    /**
     * 请求类型
     */
    private int type = 0;
    
    /**
     * 请求金额
     */
    private float price = 0.0f;
    
    private int id = 0;

    /**
     * 构造器
     * @param type
     * @param price
     * @param id
     */
    public PurchaseRequest(int type, float price, int id) {
        super();
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

