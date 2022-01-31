package com.twelvet.hand.design.bridge.impl;

import com.twelvet.hand.design.bridge.Brand;
import com.twelvet.hand.design.bridge.Computer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 台式电脑
 */
public class Desktop extends Computer {

    private final static Logger log = LoggerFactory.getLogger(Desktop.class);

    public Desktop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        log.info("台式机");
    }
}
