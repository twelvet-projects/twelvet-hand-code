package com.twelvet.hand.design.factory.abstractFactory;

import com.twelvet.hand.design.factory.abstractFactory.phone.PhoneFactory;
import com.twelvet.hand.design.factory.abstractFactory.router.RouterFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 产品工厂
 */
public interface ProductFactory {

    /**
     * 制作路由器
     *
     * @return RouterFactory
     */
    RouterFactory routerFactory();

    /**
     * 制作手机
     *
     * @return PhoneFactory
     */
    PhoneFactory phoneFactory();


}
