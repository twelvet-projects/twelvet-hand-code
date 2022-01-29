package com.twelvet.hand.design.factory.abstractFactory.impl;

import com.twelvet.hand.design.factory.abstractFactory.ProductFactory;
import com.twelvet.hand.design.factory.abstractFactory.phone.PhoneFactory;
import com.twelvet.hand.design.factory.abstractFactory.phone.impl.XiaoMiPhoneFactoryImpl;
import com.twelvet.hand.design.factory.abstractFactory.router.RouterFactory;
import com.twelvet.hand.design.factory.abstractFactory.router.impl.XiaoMiRouterFactoryImpl;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 小米工厂
 */
public class XiaoMiProductFactoryImpl implements ProductFactory {

    /**
     * 制作路由器
     *
     * @return RouterFactory
     */
    @Override
    public RouterFactory routerFactory() {
        return new XiaoMiRouterFactoryImpl();
    }

    /**
     * 制作手机
     *
     * @return PhoneFactory
     */
    @Override
    public PhoneFactory phoneFactory() {
        return new XiaoMiPhoneFactoryImpl();
    }
}
