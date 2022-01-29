package com.twelvet.hand.design.factory.abstractFactory.phone;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 手机工厂
 */
public interface PhoneFactory {

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
    void call();

    /**
     * 发短信
     */
    void sendSms();

}
