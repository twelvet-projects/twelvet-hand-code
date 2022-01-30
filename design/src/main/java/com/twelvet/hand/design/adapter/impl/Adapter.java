package com.twelvet.hand.design.adapter.impl;

import com.twelvet.hand.design.adapter.NetToUsb;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 需要倍适配的class
 */
public class Adapter implements NetToUsb {

    private NetworkCable networkCable;

    public Adapter(NetworkCable networkCable) {
        this.networkCable = networkCable;
    }

    @Override
    public void handleRequest() {
        networkCable.request();
    }
}
