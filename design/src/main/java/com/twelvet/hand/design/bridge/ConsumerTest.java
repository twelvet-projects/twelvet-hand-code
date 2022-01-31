package com.twelvet.hand.design.bridge;

import com.twelvet.hand.design.bridge.impl.Apple;
import com.twelvet.hand.design.bridge.impl.Desktop;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 测试类
 */
public class ConsumerTest {

    public static void main(String[] args) {

        Apple apple = new Apple();
        Desktop desktop = new Desktop(apple);

        desktop.info();

    }

}
