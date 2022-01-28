package com.twelvet.hand.design.factory.simple.impl;

import com.twelvet.hand.design.factory.simple.Car;
import com.twelvet.hand.design.factory.simple.CarFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description:
 */
public class WuLinCarFactoryImpl implements CarFactory {

    @Override
    public Car getCar() {
        return new WuLinImpl();
    }

}
