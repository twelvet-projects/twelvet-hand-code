package com.twelvet.hand.design.factory;

import com.twelvet.hand.design.factory.simple.Car;
import com.twelvet.hand.design.factory.simple.impl.TesLaCarFactoryImpl;
import com.twelvet.hand.design.factory.simple.impl.WuLinCarFactoryImpl;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 汽车消费者
 */
public class Consumer {

    public static void main(String[] args) {

        Car wuLin = new WuLinCarFactoryImpl().getCar();
        Car tesLa = new TesLaCarFactoryImpl().getCar();

        wuLin.name();
        tesLa.name();

    }

}
