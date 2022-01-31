package com.twelvet.hand.design.staticProxy;

import com.twelvet.hand.design.staticProxy.impl.Landlord;
import com.twelvet.hand.design.staticProxy.impl.Proxy;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 消费者
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Landlord landlord = new Landlord();
        Proxy proxy = new Proxy(landlord);

        proxy.rent();

    }

}
