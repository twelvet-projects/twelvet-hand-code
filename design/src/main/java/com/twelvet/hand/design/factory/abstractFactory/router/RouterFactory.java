package com.twelvet.hand.design.factory.abstractFactory.router;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 手机工厂
 */
public interface RouterFactory {

    /**
     * 开机
     */
    void start();

    /**
     * 关机
     */
    void shutdown();

    /**
     * 打电话
     */
    void openWifi();

    /**
     * 发短信
     */
    void setting();

}
