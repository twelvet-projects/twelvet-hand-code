package com.twelvet.hand.design.factory.simple.impl;

import com.twelvet.hand.design.factory.simple.Car;
import com.twelvet.hand.utils.$;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description:
 */
public class WuLinImpl implements Car {

    private final static Logger log = LoggerFactory.getLogger(WuLinImpl.class);

    @Override
    public void name() {
        log.info("五菱宏光");
    }

}
