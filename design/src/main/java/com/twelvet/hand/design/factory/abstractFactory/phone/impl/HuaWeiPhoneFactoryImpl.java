package com.twelvet.hand.design.factory.abstractFactory.phone.impl;

import com.twelvet.hand.design.factory.abstractFactory.phone.PhoneFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 华为手机工厂
 */
public class HuaWeiPhoneFactoryImpl implements PhoneFactory {

    private final static Logger log = LoggerFactory.getLogger(HuaWeiPhoneFactoryImpl.class);

    /**
     * 开机
     */
    @Override
    public void start() {
        log.info("开启华为手机");
    }

    /**
     * 关机
     */
    @Override
    public void shutdown() {
        log.info("关闭华为手机");
    }

    /**
     * 打电话
     */
    @Override
    public void call() {
        log.info("华为手机打电话");
    }

    /**
     * 发短信
     */
    @Override
    public void sendSms() {
        log.info("华为手机发送短信");
    }
}
