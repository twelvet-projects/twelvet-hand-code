package com.twelvet.hand.design.builder;

import com.twelvet.hand.design.builder.pojo.Product;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 建造者模式
 */
public abstract class Builder {

    /**
     * 手机
     *
     * @param msg 手机类型
     * @return Builder
     */
    abstract Builder phone(String msg);

    /**
     * 电脑
     *
     * @param msg 电脑类型
     * @return Builder
     */
    abstract Builder computer(String msg);

    /**
     * 路由器
     *
     * @param msg 路由器类型
     * @return Builder
     */
    abstract Builder router(String msg);

    /**
     * 手表
     *
     * @param msg 手表类型
     * @return Builder
     */
    abstract Builder watch(String msg);

    /**
     * 获取组合产品
     *
     * @return Product
     */
    abstract Product getProduct();

}
