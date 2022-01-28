package com.twelvet.hand.design.factory.simple.impl;

import com.twelvet.hand.design.factory.simple.Car;
import com.twelvet.hand.design.factory.simple.CarFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 特斯拉车工厂
 */
public class TesLaCarFactoryImpl implements CarFactory {

    /**
     * 获取车
     *
     * @return Car
     */
    @Override
    public Car getCar() {
        return new TesLaImpl();
    }

}
