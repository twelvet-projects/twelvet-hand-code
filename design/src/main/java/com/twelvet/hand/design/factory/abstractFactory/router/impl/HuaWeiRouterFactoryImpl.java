package com.twelvet.hand.design.factory.abstractFactory.router.impl;

import com.twelvet.hand.design.factory.abstractFactory.router.RouterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 华为路由工厂
 */
public class HuaWeiRouterFactoryImpl implements RouterFactory {

    private final static Logger log = LoggerFactory.getLogger(HuaWeiRouterFactoryImpl.class);

    /**
     * 开机
     */
    @Override
    public void start() {
        log.info("开启华为路由");
    }

    /**
     * 关机
     */
    @Override
    public void shutdown() {
        log.info("关闭华为路由");
    }

    /**
     * 打电话
     */
    @Override
    public void openWifi() {
        log.info("华为打开wifi");
    }

    /**
     * 发短信
     */
    @Override
    public void setting() {
        log.info("华为设置");
    }
}
