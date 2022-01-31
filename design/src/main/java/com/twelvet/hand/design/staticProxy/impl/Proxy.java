package com.twelvet.hand.design.staticProxy.impl;

import com.twelvet.hand.design.staticProxy.Rent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 代理
 */
public class Proxy implements Rent {

    private final static Logger log = LoggerFactory.getLogger(Proxy.class);

    /**
     * 房东
     */
    private Landlord landlord;

    public Proxy(Landlord landlord) {
        this.landlord = landlord;
    }

    @Override
    public void rent() {
        houseViewing();
        landlord.rent();
        sign();
        fare();
    }

    /**
     * 中介带看房
     */
    public void houseViewing() {
        log.info("带看房");
    }

    /**
     * 签订合同
     */
    public void sign() {
        log.info("签订合同");
    }

    /**
     * 收中介费
     */
    public void fare() {
        log.info("收中介费");
    }

}
