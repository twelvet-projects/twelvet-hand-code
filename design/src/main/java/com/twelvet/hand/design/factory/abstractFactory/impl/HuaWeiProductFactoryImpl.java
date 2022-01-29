package com.twelvet.hand.design.factory.abstractFactory.impl;

import com.twelvet.hand.design.factory.abstractFactory.ProductFactory;
import com.twelvet.hand.design.factory.abstractFactory.phone.PhoneFactory;
import com.twelvet.hand.design.factory.abstractFactory.phone.impl.HuaWeiPhoneFactoryImpl;
import com.twelvet.hand.design.factory.abstractFactory.router.RouterFactory;
import com.twelvet.hand.design.factory.abstractFactory.router.impl.HuaWeiRouterFactoryImpl;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 小米工厂
 */
public class HuaWeiProductFactoryImpl implements ProductFactory {

    /**
     * 制作路由器
     *
     * @return RouterFactory
     */
    @Override
    public RouterFactory routerFactory() {
        return new HuaWeiRouterFactoryImpl();
    }

    /**
     * 制作手机
     *
     * @return PhoneFactory
     */
    @Override
    public PhoneFactory phoneFactory() {
        return new HuaWeiPhoneFactoryImpl();
    }
}
