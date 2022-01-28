package com.twelvet.hand.design.factory.simple.impl;

import com.twelvet.hand.design.factory.simple.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description:
 */
public class TesLaImpl implements Car {

    private final static Logger log = LoggerFactory.getLogger(TesLaImpl.class);

    @Override
    public void name() {
        log.info("特斯拉");
    }


}
