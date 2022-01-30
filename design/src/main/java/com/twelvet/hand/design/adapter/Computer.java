package com.twelvet.hand.design.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 计算器
 */
public class Computer {

    private final static Logger log = LoggerFactory.getLogger(Computer.class);

    /**
     * 使用转接口上网
     *
     * @param netToUsb NetToUsb
     */
    public void net(NetToUsb netToUsb) {
        netToUsb.handleRequest();
    }

}
