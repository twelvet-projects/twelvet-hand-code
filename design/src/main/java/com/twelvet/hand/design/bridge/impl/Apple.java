package com.twelvet.hand.design.bridge.impl;

import com.twelvet.hand.design.bridge.Brand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 苹果电脑
 */
public class Apple implements Brand {

    private final static Logger log = LoggerFactory.getLogger(Apple.class);

    @Override
    public void info() {
        log.info("苹果电脑");
    }
}
