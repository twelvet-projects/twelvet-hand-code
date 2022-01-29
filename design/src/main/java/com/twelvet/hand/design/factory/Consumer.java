package com.twelvet.hand.design.factory;

import com.twelvet.hand.design.factory.abstractFactory.impl.HuaWeiProductFactoryImpl;
import com.twelvet.hand.design.factory.abstractFactory.impl.XiaoMiProductFactoryImpl;
import com.twelvet.hand.design.factory.simple.Car;
import com.twelvet.hand.design.factory.simple.impl.TesLaCarFactoryImpl;
import com.twelvet.hand.design.factory.simple.impl.WuLinCarFactoryImpl;
import org.junit.Test;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 汽车消费者
 */
public class Consumer {

    /**
     * 简单工厂模式
     */
    public void simple() {
        Car wuLin = new WuLinCarFactoryImpl().getCar();
        Car tesLa = new TesLaCarFactoryImpl().getCar();

        wuLin.name();
        tesLa.name();

    }

    /**
     * 产品概念工厂(抽象工厂)
     */
    @Test
    public void abstractFactory() {

        // 生成小米产品
        XiaoMiProductFactoryImpl xiaoMiProductFactory = new XiaoMiProductFactoryImpl();
        xiaoMiProductFactory.routerFactory().openWifi();

        // 生成华为产品
        HuaWeiProductFactoryImpl huaWeiProductFactory = new HuaWeiProductFactoryImpl();
        huaWeiProductFactory.phoneFactory().sendSms();

    }

}
