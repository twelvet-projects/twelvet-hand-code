package com.twelvet.hand.design.staticProxy.impl;

import com.twelvet.hand.design.staticProxy.Rent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 房东
 */
public class Landlord implements Rent {

    private final static Logger log = LoggerFactory.getLogger(Landlord.class);

    @Override
    public void rent() {
        log.info("房东要租房");
    }

}
