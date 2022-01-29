package com.twelvet.hand.design.factory.abstractFactory.router.impl;

import com.twelvet.hand.design.factory.abstractFactory.router.RouterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 小米路由工厂
 */
public class XiaoMiRouterFactoryImpl implements RouterFactory {

    private final static Logger log = LoggerFactory.getLogger(XiaoMiRouterFactoryImpl.class);

    /**
     * 开机
     */
    @Override
    public void start() {
        log.info("开启小米路由");
    }

    /**
     * 关机
     */
    @Override
    public void shutdown() {
        log.info("关闭小米路由");
    }

    /**
     * 打电话
     */
    @Override
    public void openWifi() {
        log.info("小米打开wifi");
    }

    /**
     * 发短信
     */
    @Override
    public void setting() {
        log.info("小米设置");
    }
}
