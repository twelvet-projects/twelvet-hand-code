package com.twelvet.hand.design.factory.simple;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 车工厂(可以进行横向扩展，无需更改现有代码)
 */
public interface CarFactory {

    /**
     * 实现获取车接口
     *
     * @return Car
     */
    Car getCar();

}
