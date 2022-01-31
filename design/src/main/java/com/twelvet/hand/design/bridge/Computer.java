package com.twelvet.hand.design.bridge;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 抽象电脑
 */
public abstract class Computer {

    protected Brand brand;

    public Computer(Brand brand) {

        this.brand = brand;

    }

    /**
     * 自带品牌信息
     */
    public void info() {
        brand.info();
    }

}
