package com.twelvet.hand.design.factory.factoryMethod;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 抽象工厂
 */
public interface Factory {

    /**
     * 制作产品
     *
     * @return Product
     */
    public abstract Product make();

}
